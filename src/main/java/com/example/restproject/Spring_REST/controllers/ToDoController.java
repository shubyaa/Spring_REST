package com.example.restproject.Spring_REST.controllers;

import com.example.restproject.Spring_REST.constants.APIConstants;
import com.example.restproject.Spring_REST.constants.Tags;
import com.example.restproject.Spring_REST.models.ToDo;
import com.example.restproject.Spring_REST.repositories.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ToDoController {

    Map<String, Object> responseBody = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(APIConstants.getAllRecords)
    public @ResponseBody Object getAllRecords() {
        Iterable<ToDo> toDoRepositoryList;
        try {
            toDoRepositoryList = toDoRepository.findAll();
            responseBody.put(Tags.SUCCESS, true);
            responseBody.put(Tags.RESULT, toDoRepositoryList);

        } catch (Exception e) {
            logger.debug("Exception at getAll", e.getMessage());
            responseBody.put(Tags.SUCCESS, false);
            responseBody.put(Tags.RESULT, e.getMessage());
        }
        return responseBody;
    }

    @GetMapping("getRecordById/{id}")
    public @ResponseBody Object getRecordById(@PathVariable Integer id){
        try{
            Optional<ToDo> todo = toDoRepository.findById(id);
            if (todo.isPresent()){
                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, todo.get());
            }else {
                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, Tags.NO_RECORD_FOUND);
            }

        }catch (Exception e){
            logger.debug("Exception at Get Record By Id", e.getMessage());
            responseBody.put(Tags.SUCCESS, false);
            responseBody.put(Tags.RESULT, e.getMessage());
        }

        return responseBody;
    }


    @PostMapping(APIConstants.addRecord)
    public @ResponseBody Object addRecord(@RequestBody ToDo toDoObject) {
        try {
            toDoObject.setDatetime(String.valueOf(LocalDateTime.now()));
            ToDo toDo = new ToDo();
            toDo.setTitle(toDoObject.getTitle());
            toDo.setDescription(toDoObject.getDescription());
            toDo.setDatetime(toDoObject.getDatetime());


            if (toDo.checkIsObjectNull()) {
                responseBody.put(Tags.SUCCESS, false);
                responseBody.put(Tags.RESULT, Tags.SOME_VALUES_ARE_NULL);
            } else if (toDoRepository.checkIfRecordExists(toDo.getTitle())) {
                responseBody.put(Tags.SUCCESS, false);
                responseBody.put(Tags.RESULT, Tags.RECORD_EXISTS);
            } else {
                toDoRepository.save(toDo);

                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, Tags.RECORD_ADDED);
            }

        } catch (Exception e) {
            logger.debug("Exception at addRecord", e.getMessage());
            responseBody.put(Tags.SUCCESS, false);
            responseBody.put(Tags.RESULT, e.getMessage());
        }

        return responseBody;
    }

    @PutMapping(APIConstants.delete + "/{id}")
    public @ResponseBody Object deleteRecord(@PathVariable Integer id) {
        try {
            if (toDoRepository.checkIfRecordExistsById(id.toString())) {
                toDoRepository.deleteById(id);

                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, Tags.RECORD_DELETED);
            } else {
                responseBody.put(Tags.SUCCESS, false);
                responseBody.put(Tags.RESULT, Tags.NO_RECORD_FOUND);
            }
        } catch (Exception e) {
            logger.debug("Exception at delete record", e.getMessage());
            responseBody.put(Tags.SUCCESS, false);
            responseBody.put(Tags.RESULT, e.getMessage());
        }

        return responseBody;
    }

    @GetMapping(APIConstants.getMostRecentEntries)
    public @ResponseBody Object getMostRecentEntries(@RequestParam(defaultValue = "1", required = false) Integer limit) {
        try {
            Iterable<ToDo> toDoIterable = toDoRepository.findAll();
            List<ToDo> toDoList = new ArrayList<>(StreamSupport.stream(toDoIterable.spliterator(), false).toList());
            toDoList.sort(ToDo::compareTo);

            if (limit>toDoList.size()){
                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, toDoList.subList(0, toDoList.size()));
            }else {
                responseBody.put(Tags.SUCCESS, true);
                responseBody.put(Tags.RESULT, toDoList.subList(0, limit));
            }

        } catch (Exception e) {
            logger.debug("Exception at get Most Recent Entries", e.getMessage());
            responseBody.put(Tags.SUCCESS, false);
            responseBody.put(Tags.RESULT, e.getMessage());
        }

        return responseBody;
    }
}
