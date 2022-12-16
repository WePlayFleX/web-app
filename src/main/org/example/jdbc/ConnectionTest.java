package org.example.jdbc;

import org.example.jdbc.dao.UsersDAO;
import org.example.jdbc.dao.impl.UserDAOImpl;
import org.example.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

public class ConnectionTest {


    public static <user> void main(String[] args) {
        UsersDAO dao = new UserDAOImpl();

//        User user = dao.getUserByEmail("JOHN@gmail.com");
//
//        System.out.println(user);
//
//         User user2 = new User("Bob@gmail.com", "Bob", "321", "some details");
//         dao.createUser(user2);

     //   dao.activateUser("Bob@gmail.com");

        Set<User> users = dao.getAllUser();

        System.out.println(users.size());
    }
}
