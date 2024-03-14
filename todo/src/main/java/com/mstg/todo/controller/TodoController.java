package com.mstg.todo.controller;

import com.mstg.todo.dto.HelloDto;
import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.service.impl.TodoService_Impl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo/")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService_Impl _todoService;
    @GetMapping("hello")
    public ResponseEntity<HelloDto> hello(@RequestParam String name) {
        if (!name.isEmpty())
//            return "Hello " + name +  " from server.";
//            return ResponseEntity.status(200).body("Hello " + name +  " from server.");
            return ResponseEntity.status(200).body(HelloDto.builder()
                    .message("Hello " + name +  " from server.")
                    .build());

//        return "Hello noname";
        return ResponseEntity.status(400).body(HelloDto.builder()
                .message("Name required.")
                .build());
    }
    @GetMapping("all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todoList = new ArrayList<>();

        TodoDto todo1 = TodoDto.builder()
                .title("Masanı topla.")
                .detail("Kalemliğin yerini oynatmadan.")
                .build();

        TodoDto todo2 = new TodoDto("Çamaşırları topla", "Çorapları ayrı topla");

        TodoDto todo3 = new TodoDto();
        todo3.setTitle("WebRTC araştır.");
        todo3.setDetail("Çok kendini kaybemeden yap.");

        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);

        return ResponseEntity.status(200).body(todoList);
    }

    @PostMapping("add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto dtoObj) {
        boolean result = _todoService.saveTodo(dtoObj);

        if (result)
            return ResponseEntity.status(201).body(dtoObj);

        return ResponseEntity.status(500).body(new TodoDto());
    }

    /**
     * TODO: düzenleme
     * */
}
