package com.hsf301.javafx.lab2_hsf301;

import com.hsf301.javafx.lab2_hsf301.dto.SearchDriversDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AgentDetailController implements Initializable {
    @FXML
    public TextField nameDetail;
    @FXML
    public TextField emailDetail;
    @FXML
    public TextField addressDetail;
    @FXML
    public TextField balanceDetail;
    @FXML
    public TextField statusDetail;
    @FXML
    public TextField dateDetail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setAgent(SearchDriversDTO agent) {
        nameDetail.setText("Tên Đại Lý: " + agent.getAgentName());
        statusDetail.setText("Trạng Thái: " + agent.getStatus());
        emailDetail.setText("Email: " + agent.getEmail());
        addressDetail.setText("Địa Chỉ: " + agent.getAddress());
        dateDetail.setText("Ngày Đăng Ký: " + agent.getRegisterDate().toString());
        balanceDetail.setText("Số Dư Tài Khoản: " + agent.getAccountBalance());

    }

    public void onLogoutClick(ActionEvent event) {

    }

    public void onCloseClick(ActionEvent event) {

    }
}
