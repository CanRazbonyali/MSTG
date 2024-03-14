package com.mstg.todo.service;

import com.mstg.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto>  getAllTodos();
    TodoDto getTodo(String title);
    boolean saveTodo(TodoDto obj);
    boolean updateTodo(TodoDto obj);
}
