package com.mstg.todo.service;

import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<TodoDto>  getAllTodos();
    Todo getTodo(String title);
    boolean saveTodo(TodoDto obj);
    boolean updateTodo(TodoDto obj);
}
