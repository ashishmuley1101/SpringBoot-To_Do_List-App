package com.bridgelabz.toDoListApp.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ToDoListDTO {

    @NotBlank(message = "Title cannot be Blank...! ")
    public String title;
    public boolean done;
}
