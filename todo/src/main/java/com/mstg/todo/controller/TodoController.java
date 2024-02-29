package com.mstg.todo.controller;

import com.mstg.todo.dto.HelloDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/")
public class TodoController {
    /*
        @PostMapping
        @DeleteMapping
        @PutMapping
        @PatchMapping
     */
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
    public ResponseEntity<HelloDto> getAllTodos() {
        /*
         * TODO: bütün yapılacakları döndürecek
         * */
        return null;
    }

    @PostMapping("add")
    public ResponseEntity<HelloDto> addTodo(@RequestBody /*dto sınıfı gelecek*/) {
        /*
         * TODO: gelen ,isteği db ye yazacak
         * */
        return null;
    }
}
