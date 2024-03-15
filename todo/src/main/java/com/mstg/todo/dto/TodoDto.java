package com.mstg.todo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private String detail;
    private String message;

    /*
    public TodoDto() {}

    public TodoDto(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
    */
}
