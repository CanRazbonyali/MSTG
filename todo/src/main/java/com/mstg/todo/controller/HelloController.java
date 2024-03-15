package com.mstg.todo.controller;

import com.mstg.todo.dto.HelloDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello/")
public class HelloController {
    @GetMapping()
    public ResponseEntity<HelloDto> hello(@RequestParam String name) {
        if (!name.isEmpty())
            /*
            return "Hello " + name + "!";
            return ResponseEntity.status(200).body("Hello " + name + "!");
            */
            return ResponseEntity.status(200).body(HelloDto.builder()
                    .message("Hello " + name + "!")
                    .build());
        //return "Name is required";
        //return ResponseEntity.status(400).body("Name is required");
        return ResponseEntity.status(400).body(HelloDto.builder()
                .message("Name is required!")
                .build());
    }
}
