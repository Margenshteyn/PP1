package app.service;

import app.dao.UserDAOImpl;
import app.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService;
    private static UserDAOImpl userDAO;

    private UserServiceImpl(Connection connection) {
        userDAO = new UserDAOImpl(connection);
    }

    public static UserServiceImpl getUserService(Connection connection) {
        if (userService == null) {
            userService = new UserServiceImpl(connection);
        }
        return userService;
    }

    @Override
    public boolean addUser(User user) {
        if (userDAO.getUserByLogin(user.getLogin()) != null) {
            return false;
        }
        userDAO.addUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user, String password) {
        if (userDAO.validateUser(user.getLogin(), password)) {
            userDAO.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(String login) {
        userDAO.deleteUser(login);
    }

    @Override
    public List<User> getUsersList() {
        return userDAO.getAllUsers();
    }
}
