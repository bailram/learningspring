package com.infosys.learning;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.PersonResponse;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import com.infosys.learning.service.LearningService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningServiceTest {

    @Autowired
    private LearningService learningService;

    @MockBean
    @Autowired private UserRepository userRepository;

    @Before
    public void init() {
        Mockito.when(userRepository.findByUserName(anyString())).thenReturn(new User());
        Mockito.when(userRepository.findByUserNameAndPassWord(anyString(), anyString())).thenReturn(new User());
    }

    @Test
    public void getNameMan_shouldSuccess() {
        Assert.assertEquals("John", learningService.getName("man"));
    }

    @Test
    public void getNameMan_shouldFail() {
        Assert.assertEquals("John", learningService.getName("female"));
    }

    @Test
    public void getNameV2_shouldSuccess() {
        Assert.assertEquals("John", learningService.getNameV2("man").getName());
    }

    @Test
    public void getNameV2_shouldFail() {
        Assert.assertEquals("John", learningService.getNameV2("female").getName());
    }

    @Test
    public void getNameV3_shouldSuccess() {
        Assert.assertEquals("John Doe", learningService.getNameV3("John"));
    }

    @Test
    public void getNameV3_shouldSuccess2() {
        Assert.assertEquals("Jane Doe", learningService.getNameV3("Jane"));
    }

    @Test
    public void getNameV3_shouldFail() {
        Assert.assertEquals("Jane Doe", learningService.getNameV3("Dhimas"));
    }

    @Test
    public void getPerson_shouldSuccess() {
        Assert.assertNotNull(learningService.getPerson("Dhimas", 1999));
    }

    @Test
    public void getPerson_shouldFail() {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setName("Dhimas");
        Data data = new Data();
        data.setAge(21);
        personResponse.setData(data);
        Assert.assertEquals(personResponse.getData().getAge() ,learningService.getPerson("Dhimas", 1999).getData().getAge());
    }

    @Test
    public void register_shouldSuccess() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("qweoqwqwe");
        userRequest.setPassword("dhimas");
        Assert.assertEquals("Register Success!",learningService.register(userRequest));
    }

    @Test
    public void register_shouldFail() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("heli");
        userRequest.setPassword("dhimas");
        Assert.assertEquals("Register Success!",learningService.register(userRequest));
    }

    @Test
    public void login_shouldSuccess() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("heli");
        userRequest.setPassword("gukgukguk");
        Assert.assertNotNull(learningService.login(userRequest));
    }
    @Test
    public void login_shouldFail() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("a");
        userRequest.setPassword("b");
        Assert.assertNotNull(learningService.login(userRequest));
    }
}
