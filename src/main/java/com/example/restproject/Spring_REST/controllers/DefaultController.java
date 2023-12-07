package com.example.restproject.Spring_REST.controllers;


import com.example.restproject.Spring_REST.constants.APIConstants;
import com.example.restproject.Spring_REST.constants.Tags;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultController {
    Map<String, Object> responseBody = new HashMap<>();

    @GetMapping(value = APIConstants.init)
    public @ResponseBody Object initFunction(){

        responseBody.put(Tags.SUCCESS, true);
        responseBody.put(Tags.RESULT, "HI, this is the root level endpoint.");

        return responseBody;

    }
}
