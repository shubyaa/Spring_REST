package com.example.restproject.Spring_REST.repositories;

import com.example.restproject.Spring_REST.models.ToDo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

    @Query(value = "SELECT COUNT(t)>0 FROM ToDo t WHERE t.title = :title")
    public boolean checkIfRecordExists(@Param("title") String title);

    @Query(value = "SELECT COUNT(t)>0 FROM ToDo t WHERE t.id = :id")
    public boolean checkIfRecordExistsById(@Param("id") String id);

    @Query(value = "SELECT t FROM ToDo t WHERE t.id = :id")
    public ToDo findRecordById(@Param("id") String id);

}
