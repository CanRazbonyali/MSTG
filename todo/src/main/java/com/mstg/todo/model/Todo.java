package com.mstg.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE", unique = true)
    private String title;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "COMPLETED")
    private boolean completed;

//    public Todo(String title, String detail) {
//        this.title = title;
//        this.detail = detail;
//        this.completed = false;
//    }
}
