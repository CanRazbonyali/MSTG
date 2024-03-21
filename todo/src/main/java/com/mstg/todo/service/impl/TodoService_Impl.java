package com.mstg.todo.service.impl;

import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.repository.TodoRepository;
import com.mstg.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService_Impl implements TodoService {
    private final Logger _logger = LoggerFactory.getLogger(TodoService_Impl.class);
    private final TodoRepository _todoRepository;
    @Override
    public List<TodoDto> getAllTodos() {
        try {
            List<Todo> dbTodos = _todoRepository.findAll();


            if (!dbTodos.isEmpty()) {
                _logger.info("All Todos fethched...");
                return dbTodos.stream()
                        .map(todo -> TodoDto.builder()
                                .title(todo.getTitle())
                                .detail(todo.getDetail())
                                .build())
                        .collect(Collectors.toList());

//                List<TodoDto> listOfTodo = new ArrayList<>();
//                for (Todo item : dbTodos) {
//                    TodoDto todoDto = TodoDto.builder()
//                            .title(item.getTitle())
//                            .detail(item.getDetail())
//                            .build();
//                    listOfTodo.add(todoDto);
//                }
//                return listOfTodo;
            }

            _logger.info("List is empty.");
            return Collections.emptyList();

        } catch (Exception ex) {
            _logger.error("Error while fetching todos. Ex: {}", ex.getMessage());
           throw new RuntimeException("Internal server error...");
        }
    }

    @Override
    public Todo getTodo(String title) {
        Optional<Todo> optTodo = _todoRepository.findByTitle(title);

        if (optTodo.isPresent()) {
            _logger.info("Find by title, {}", optTodo);
            Todo dbTodo = optTodo.get();
//            TodoDto todoDto = TodoDto.builder()
//                    .title(dbTodo.getTitle())
//                    .detail(dbTodo.getDetail())
//                    .build();
            return dbTodo;
        }

        _logger.info("Resource not found...");
        return null;
    }

    @Override
    public boolean saveTodo(TodoDto obj) {
        try {
            Todo newTodo = Todo.builder()
                    .title(obj.getTitle())
                    .detail(obj.getDetail())
                    .build();

            Todo savedEntity = _todoRepository.save(newTodo);
            _logger.info("{} saved successfully...", savedEntity);
            return true;
        } catch (Exception ex) {
            _logger.info("Error occurred while saving entity.Ex: {}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTodo(TodoDto obj) {
        try {
            Todo dbTodo = getTodo(obj.getTitle());

            if (dbTodo != null) {
                dbTodo.setDetail(obj.getDetail());
                Todo updatedEntity = _todoRepository.save(dbTodo);

                _logger.info("{} updated successfully...", obj);
                return true;
            }

            _logger.warn("Resource not found...");
            return false;
        } catch (Exception ex) {
            _logger.info("Error occurred while updating entity. Ex: {}", ex.getMessage());
            return false;
        }
    }
}
