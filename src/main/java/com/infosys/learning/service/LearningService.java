package com.infosys.learning.service;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.Person;
import com.infosys.learning.dto.PersonResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LearningService {

    public String getName(String gender) {
        Person person = new Person();

        if("man".equals(gender)) {
            person.setName("John");
        } else {
            person.setName("Jane");
        }

        return person.getName();
    }

    public Person getNameV2(String gender) {
        Person person = new Person();

        if("man".equals(gender)) {
            person.setName("John");
        } else {
            person.setName("Jane");
        }

        return person;
    }

    public String getNameV3(String name) {
        String fullname = "not identified";

        if ("John".equals(name)) {
            fullname = "John Doe";
        } else if ("Jane".equals(name)) {
            fullname = "Jane Doe";
        }

        return fullname;
    }

    public PersonResponse getPerson(String name, int yearOfBirth) {
        PersonResponse person = new PersonResponse();
        Data data = new Data();
        int dateNow = LocalDate.now().getYear();

        person.setName("John");
        data.setAge(dateNow-yearOfBirth);
        person.setData(data);

        return person;
    }


//    public Person getPerson(String name, int yearOfBirth) {
//        Person person = new Person(name, yearOfBirth);
//        return person;
//    }
}
