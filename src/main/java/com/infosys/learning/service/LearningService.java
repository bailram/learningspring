package com.infosys.learning.service;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.Person;
import com.infosys.learning.dto.PersonResponse;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LearningService {

    @Autowired
    UserRepository userRepository;

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

    public String register(UserRequest userRequest) {
        User existUser = userRepository.findByUserName(userRequest.getUsername());

        if (existUser != null) {
            return "Registered failed, username is already exists";
        }

        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setPassWord(userRequest.getPassword());
        userRepository.save(user);

        return "Register Success!";
    }

    public User login(UserRequest userRequest) {
        User existUser = userRepository.findByUserNameAndPassWord(
                userRequest.getUsername(), userRequest.getPassword());
        if (existUser == null) {
            return null;
        }
        return existUser;
    }
}
