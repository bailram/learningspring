package com.infosys.learning.controller;

import com.infosys.learning.dto.Person;
import com.infosys.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return learningService.getPerson(gender);
    }
}