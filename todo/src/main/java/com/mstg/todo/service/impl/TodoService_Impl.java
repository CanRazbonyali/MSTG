package com.mstg.todo.service.impl;

import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.repository.TodoRepository;
import com.mstg.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService_Impl implements TodoService {
    private final TodoRepository _todoRepository;

    @Override
    public List<TodoDto> getAlTodos() {
        List<Todo> todos = _todoRepository.findAll();
        if (!todos.isEmpty()) {
            return todos.stream()
                    .map(todo -> TodoDto.builder()
                            .id(todo.getId())
                            .title(todo.getTitle())
                            .detail(todo.getDetail())
                            .build())
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public TodoDto getTodo(String title) {
        try {
            Todo todo = _todoRepository.findByTitle(title);
            return TodoDto.builder()
                    .id(todo.getId())
                    .title(todo.getTitle())
                    .detail(todo.getDetail())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean saveTodo(TodoDto obj) {
        try {
            Todo newTodo = Todo.builder()
                    .title(obj.getTitle())
                    .detail(obj.getDetail())
                    .build();

            _todoRepository.save(newTodo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateTodo(TodoDto obj) {
        try {
            Todo todo = _todoRepository.findById(obj.getId()).orElse(null);
            if (todo != null) {
                todo.setTitle(obj.getTitle());
                todo.setDetail(obj.getDetail());
                _todoRepository.save(todo);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
