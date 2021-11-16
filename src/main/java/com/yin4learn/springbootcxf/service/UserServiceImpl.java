package com.yin4learn.springbootcxf.service;

import org.springframework.stereotype.Service;

import com.yin4learn.springbootcxf.model.User;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@WebService(serviceName = "UserService",
        targetNamespace = "http://ws.cxf.yin4learn.org/",
        endpointInterface = "com.yin4learn.springbootcxf.service.UserService"
)
public class UserServiceImpl implements UserService{
    
    private static User user1;
    private static User user2;
    private static User user3;

    private static List<User> userList = new ArrayList<>();
    private static Map<String, User> userMap;

    static {

        user1 = new User("1", "tester", "tester@gmail.com");
        user2 = new User("2", "tester2", "tester2@gmail.com");
        user3 = new User("3", "tester3", "tester3@gmail.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userMap = userList.stream().collect(Collectors.toMap(User::getUserId, Function.identity()));

    }

    @Override
    public String getUserName(String userId) {
        User user = userMap.getOrDefault(userId, new User(userId, "random", "random@gmail.com"));
        return user.getUserName();
    }

    @Override
    public User getUser(String userId) {
        User user = userMap.getOrDefault(userId, new User(userId, "random", "random@gmail.com"));
        return user;
    }

    @Override
    public List<User> getUserList(String userId) {
        return userList;
    }
}