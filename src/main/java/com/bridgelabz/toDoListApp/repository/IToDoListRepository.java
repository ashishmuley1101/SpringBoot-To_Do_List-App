package com.bridgelabz.toDoListApp.repository;

import com.bridgelabz.toDoListApp.model.ToDOList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoListRepository extends JpaRepository<ToDOList,Integer> {

}
