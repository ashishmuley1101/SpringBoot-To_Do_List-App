package com.bridgelabz.toDoListApp.services;

import com.bridgelabz.toDoListApp.DTO.ToDoListDTO;
import com.bridgelabz.toDoListApp.model.ToDOList;

import java.util.List;

public interface IToDOListService {

    List<ToDOList> getAlltoDoListData();

    ToDOList getToListDataById(int empId);

    ToDOList createToDoListData(ToDoListDTO toDOListDTO);

    ToDOList updateToDoListData(int listId);

    void deleteToDolistData(int listId);
}
