package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao asd = new UserDaoJDBCImpl();

    public void createUsersTable() {
        asd.createUsersTable();
    }

    public void dropUsersTable() {
        asd.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        asd.saveUser(name, lastName, age);
        System.out.printf("User с именем – %s добавлен в базу данных%n", name);
    }

    public void removeUserById(long id) {
        asd.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return asd.getAllUsers();
    }


    public void cleanUsersTable() {
        asd.cleanUsersTable();
    }
}
