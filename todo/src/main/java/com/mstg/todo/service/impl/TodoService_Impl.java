package com.mstg.todo.service.impl;

import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.repository.TodoRepository;
import com.mstg.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService_Impl implements TodoService {
    private final TodoRepository _todoRepository;
    @Override
    public List<TodoDto> getAllTodos() {
        return null;
    }

    @Override
    public TodoDto getTodo(String title) {
        return null;
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
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean updateTodo(TodoDto obj) {
        return false;
    }
}
