package com.mstg.todo.repository;

import com.mstg.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findByTitle(String title);
}