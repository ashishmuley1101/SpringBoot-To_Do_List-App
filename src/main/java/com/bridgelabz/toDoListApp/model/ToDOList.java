package com.bridgelabz.toDoListApp.model;

import com.bridgelabz.toDoListApp.DTO.ToDoListDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "todo_list")
public @Data class ToDOList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean done() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDOList(ToDoListDTO toDOListDTO){
        this.title = toDOListDTO.title;
        this.done = toDOListDTO.done;
    }

    public  ToDOList(){}
}
