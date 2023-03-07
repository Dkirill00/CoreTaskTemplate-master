package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserService s = new UserServiceImpl();
        s.createUsersTable();
        s.saveUser("Dominik", "Torent", (byte) 12);
        s.saveUser("Dominik1", "Torent4", (byte) 21);
        s.saveUser("Dominik2", "Torent5", (byte) 22);
        s.saveUser("Dominik3", "Torent6", (byte) 23);
        List<User> allUsers = s.getAllUsers();
        for (User user : allUsers
        ) {
            System.out.println(user.toString());
        }
        s.cleanUsersTable();
        s.dropUsersTable();
    }
}
