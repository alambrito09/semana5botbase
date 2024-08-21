package umg.principal.Bottelegram.service;

import umg.principal.Bottelegram.dao.UserDao;
import umg.principal.Bottelegram.db.DatabaseConnection;
import umg.principal.Bottelegram.db.TransactionManager;
import umg.principal.Bottelegram.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();

    public void deleteUserByEmail(String email) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                userDao.deleteUserByEmail(email);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }



    public void createUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                userDao.insertUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }

    public void updateUser(User user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TransactionManager tm = new TransactionManager(connection);
            tm.beginTransaction();
            try {
                userDao.updateUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }


    public User getUserByTelegramId(long telegramid) throws SQLException {
        return userDao.getUserByTelegramId(telegramid);
    }

    public User getUserByEmail(String Email) throws SQLException {
        return userDao.getUserByEmail(Email);
    }
    public User getUserBycarne(String carne) throws SQLException {
        return userDao.getUserBycarne(carne);
    }
    public User getUserById(int Id) throws SQLException {
        return  userDao.getUserById(Id);
    }

}
