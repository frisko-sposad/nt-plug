package ntplug.ntplug.controller;

import java.sql.*;
import java.util.Vector;

public class DBWorker {
    private final String DB_URL = "jdbc:postgresql://192.168.1.8:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "postgres";
    private static final String USER_SELECT_QUERY = "SELECT * from users where login = ?";
    private static final String USER_SELECT_ALL_QUERY = "SELECT * from users";

    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection makeConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public User getUser(String login) throws Exception {
        Connection c = makeConnection();

        PreparedStatement statement = c.prepareStatement(USER_SELECT_QUERY);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setLogin(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            return user;
        }
        return null;

    }

    public Vector<User> getAllUsers() throws Exception {
        Vector<User> result = new Vector<User>();
        Connection c = makeConnection();

        PreparedStatement statement = c.prepareStatement(USER_SELECT_ALL_QUERY);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setLogin(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            result.add(user);
        }
        return result;

    }


}
