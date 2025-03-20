package com.hsf301.javafx.lab2_hsf301;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    public TextField emailregister;
    @FXML
    public PasswordField passwordRegister;
    @FXML
    public TextField txnamedaily;
    @FXML
    public TextField addressregister;
    @FXML
    public Button txregister;
    @FXML
    public Button back;
    @FXML
    public Label showalert;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void buttonRegister(ActionEvent event) throws IOException {
        String agent_name=txnamedaily.getText();
        String password=passwordRegister.getText();
        String email=emailregister.getText();
        String address=addressregister.getText();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = databaseConnection.getDatabaseConnection();
        String register = "insert into searchDrivers (Agent_Name,Email,Address,Password,Account_Balance,Register_date,status) values(?,?,?,?,0.0,'2024-03-20 12:30:00','active');";
        String checkEmailQuery="Select count(*) from searchDrivers where Email=?;";
        try{
            PreparedStatement check=connectDB.prepareStatement(checkEmailQuery);
            check.setString(1,email);
            ResultSet rs=check.executeQuery();
            if(rs.next() && rs.getInt(1)>0){
                showalert.setText("Email Already Exist");
            }else {
                PreparedStatement pst = connectDB.prepareStatement(register);
                pst.setString(1, agent_name);
                pst.setString(2, email);
                pst.setString(3, address);
                pst.setString(4, password);
                pst.execute();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
                Parent login = fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(login));
                stage.setTitle("Đăng ký");
                showalert.setText("Bạn đã đăng ký thành công");
                stage.show();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Parent login=fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(login));
        stage.setTitle("Đăng ký");
        stage.show();
    }
}
