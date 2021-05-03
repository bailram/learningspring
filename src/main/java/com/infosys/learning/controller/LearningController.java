package com.infosys.learning.controller;

import com.infosys.learning.dto.Person;
import com.infosys.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LearningController {

    @Autowired
    LearningService learningService;

    @GetMapping("/getpersonname")
    public String getPersonName(@RequestParam(value = "gender", defaultValue = "gender") String gender) {
        return learningService.getName(gender);
    }

    @GetMapping("/getperson")
    public Person getPerson(@RequestParam(value = "gender", defaultValue = "gender") String gender) {
        return learningService.getNameV2(gender);
    }

    @PostMapping(value = "getpersonnamev3", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPersonNameV3(@RequestBody(required = true) Person person) {
        return learningService.getNameV3(person.getName());
    }
}
