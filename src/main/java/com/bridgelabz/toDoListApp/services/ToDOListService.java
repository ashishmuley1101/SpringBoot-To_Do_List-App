package com.bridgelabz.toDoListApp.services;

import com.bridgelabz.toDoListApp.DTO.ToDoListDTO;
import com.bridgelabz.toDoListApp.exception.ToDoListException;
import com.bridgelabz.toDoListApp.model.ToDOList;
import com.bridgelabz.toDoListApp.repository.IToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDOListService implements IToDOListService{

    @Autowired
    private IToDoListRepository iToDoListRepository;

    @Override
    public List<ToDOList> getAlltoDoListData() {
        return iToDoListRepository.findAll();
    }

    @Override
    public ToDOList getToListDataById(int listId) {
        return iToDoListRepository.findById(listId).orElseThrow(()->new ToDoListException
                ("To Do List with list id : "+listId+" does not exits..!"));
    }

    @Override
    public ToDOList createToDoListData(ToDoListDTO toDOListDTO) {
        ToDOList listData ;
        listData= new ToDOList(toDOListDTO);
        listData.setDone(false);
        return iToDoListRepository.save(listData);
    }

    @Override
    public ToDOList updateToDoListData(int listId) {
        ToDOList toDOListData = this.getToListDataById(listId);
        toDOListData.setDone(true);
        return iToDoListRepository.save(toDOListData);
    }

    @Override
    public void deleteToDolistData(int listId) {
        ToDOList toDOListData=this.getToListDataById(listId);
        iToDoListRepository.delete(toDOListData);
    }
}
