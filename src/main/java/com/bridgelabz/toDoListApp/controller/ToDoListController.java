package com.bridgelabz.toDoListApp.controller;

import com.bridgelabz.toDoListApp.DTO.ResponseDTO;
import com.bridgelabz.toDoListApp.DTO.ToDoListDTO;
import com.bridgelabz.toDoListApp.model.ToDOList;
import com.bridgelabz.toDoListApp.services.ToDOListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/todolist")
public class ToDoListController {

    @Autowired
    private ToDOListService toDOListService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createToDoListData(@Valid @RequestBody ToDoListDTO toDoListDTO) {
        ToDOList listData = null;
        listData = toDOListService.createToDoListData(toDoListDTO);
        ResponseDTO respDTO = new ResponseDTO("Created To Do List Successfully ", listData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllToDoListData() {
        List<ToDOList> toDOListData = null;
        toDOListData = toDOListService.getAlltoDoListData();
        ResponseDTO respDTO = new ResponseDTO("Get all To Do List Successful", toDOListData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/getListById/{listId}")
    public ResponseEntity<ResponseDTO> getToListDataById(@PathVariable("listId") int listId) {
        ToDOList toDOListData = null;
        toDOListData = toDOListService.getToListDataById(listId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful ", toDOListData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{listId}")
    public ResponseEntity<ResponseDTO> deleteListByIdData(@PathVariable("listId") int listId) {
        toDOListService.deleteToDolistData(listId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + listId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{listId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("listId") int listId) {
        ToDOList toDOListData ;
        toDOListData = toDOListService.updateToDoListData(listId);
        ResponseDTO respDTO = new ResponseDTO("Updated To Do List Data Successfully", toDOListData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
