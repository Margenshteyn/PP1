package app.dao;

import app.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public boolean validateUser(String login, String password) throws SQLException;
    public User getUserByLogin(String login) throws SQLException;
    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public void deleteUser(String login) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
}
