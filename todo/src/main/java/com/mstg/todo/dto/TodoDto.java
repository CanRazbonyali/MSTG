package com.mstg.todo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto extends BaseResponseDto{
    private String title;
    private String detail;
    private boolean completed;

    public TodoDto(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
}
