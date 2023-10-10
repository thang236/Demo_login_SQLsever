package com.example.test_project.Controller;

import com.example.test_project.database.DbSqlSever;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDao {
    Connection objCon;

    public EmployeesDao() {
        DbSqlSever db = new DbSqlSever();
        objCon = db.openConnect();//Tạo mới thì mở csdl
    }

    public boolean login(String username, String password) {
        boolean loggedIn = false;
        if (objCon != null) {
            try {
                // Thực hiện truy vấn đăng nhập
                String loginQuery = "SELECT * FROM Employees WHERE Username = ? AND Password = ?";
                PreparedStatement preparedStatement = objCon.prepareStatement(loginQuery);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    loggedIn = true; // Đăng nhập thành công
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loggedIn;
    }


    public boolean checkIfUserExists(String username) {
        boolean userExists = false;
        if (objCon != null) {
            try {
                String checkExistingQuery = "SELECT * FROM Employees WHERE Username = ?";
                PreparedStatement checkExistingStatement = objCon.prepareStatement(checkExistingQuery);
                checkExistingStatement.setString(1, username);

                ResultSet existingResult = checkExistingStatement.executeQuery();

                if (existingResult.next()) {
                    userExists = true; // Tài khoản tồn tại
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userExists;
    }

    public boolean register(String username, String password, String firstName, String lastName, String phone, boolean isAdmin) {
        boolean registered = false;
        if (objCon != null) {
            try {
                if (!checkIfUserExists(username)) {
                    // Nếu tài khoản chưa tồn tại, thực hiện đăng ký
                    String registerQuery = "INSERT INTO Employees (Username, Password, FirstName, LastName, Phone, isAdmin) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement registerStatement = objCon.prepareStatement(registerQuery);
                    registerStatement.setString(1, username);
                    registerStatement.setString(2, password);
                    registerStatement.setString(3, firstName);
                    registerStatement.setString(4, lastName);
                    registerStatement.setString(5, phone);
                    registerStatement.setBoolean(6, isAdmin);

                    int rowsAffected = registerStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        registered = true; // Đăng ký thành công
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registered;
    }

}
