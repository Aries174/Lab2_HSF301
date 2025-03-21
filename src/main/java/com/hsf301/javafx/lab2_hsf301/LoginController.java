package com.hsf301.javafx.lab2_hsf301;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public Label txerror;
    @FXML
    public TextField txemail;
    @FXML
    public PasswordField txpassword;
    @FXML
    public Button txlogin;
    @FXML
    public Button register;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

    }

    public void handlogin(ActionEvent event) {
        String email = txemail.getText().trim();
        String password = txpassword.getText().trim();
        if (email.isEmpty() || password.isEmpty()) {
            txerror.setText("Bạn phải nhập email và password");
            return;
        }
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = databaseConnection.getDatabaseConnection();
        String verifyLogin = "SELECT COUNT(1) FROM searchDrivers WHERE Email = ? AND password = ?";
        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogin)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) == 1) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/hsf301/javafx/lab2_hsf301/ListAgent.fxml"));
                    Parent login = fxmlLoader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(login));
                    stage.setTitle("Danh sách đại lý");
                    stage.show();
                } else {
                    txerror.setText("Email hoặc mật khẩu không đúng!");
                }
            }
        } catch (Exception e) {
            txerror.setText("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void handleRegister(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Register.fxml"));
        Parent register= fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Đặt giao diện mới vào stage
        stage.setScene(new Scene(register));
        stage.setTitle("Đăng ký");
        stage.show();
    }
}