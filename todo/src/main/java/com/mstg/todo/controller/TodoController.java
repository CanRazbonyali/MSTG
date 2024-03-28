package com.mstg.todo.controller;

import com.mstg.todo.dto.BaseResponseDto;
import com.mstg.todo.dto.ExceptionDto;
import com.mstg.todo.dto.HelloDto;
import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.service.impl.TodoService_Impl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo/")
@RequiredArgsConstructor
public class TodoController {
    private final Logger _logger = LoggerFactory.getLogger(TodoController.class);

    private final TodoService_Impl _todoService;
    @GetMapping("all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        try {
            List<TodoDto> allTodos = _todoService.getAllTodos();

            _logger.info("All todos were fetched...");
            return ResponseEntity.status(200).body(allTodos);
        } catch (Exception ex) {
            _logger.error("Internal server error...");
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("add")
    public ResponseEntity<BaseResponseDto> addTodo(@RequestBody TodoDto dtoObj) {
        try {
            boolean result = _todoService.saveTodo(dtoObj);
            _logger.info("Saved successfully...");
            return ResponseEntity.status(201).body(dtoObj);
        } catch (DataIntegrityViolationException ex) {
            _logger.error(ex.getMessage());
            return ResponseEntity.status(400).body(ExceptionDto.builder().message(ex.getMessage()).build());
        } catch (Exception ex) {
            _logger.error("Internal server error.Ex:\n{}", ex.getMessage());
            return ResponseEntity.status(500).body(ExceptionDto.builder().message(ex.getMessage()).build());
        }
    }

    @PutMapping("update")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto dtoObj) {

        boolean result = _todoService.updateTodo(dtoObj);

        if (result) {
            _logger.info("Updated successfully...");
            return ResponseEntity.status(200).body(dtoObj);
        }

        _logger.error("Internal server error...");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dtoObj);
    }
}
