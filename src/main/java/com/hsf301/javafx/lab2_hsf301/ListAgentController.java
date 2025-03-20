package com.hsf301.javafx.lab2_hsf301;

import com.hsf301.javafx.lab2_hsf301.dto.SearchDriversDTO;
import com.hsf301.javafx.lab2_hsf301.entity.SearchDrivers;
import com.hsf301.javafx.lab2_hsf301.service.SearchDriversImpl;
import com.hsf301.javafx.lab2_hsf301.service.SearchDriversService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListAgentController  implements Initializable {
    @FXML
    private SearchDriversService searchDriversService;
    @FXML
    public TextField taikhoan;
    @FXML
    public TextField trangThai;
    @FXML
    public TextField tenDaiLy;
    @FXML
    public Button search;
    @FXML
    public TableView<SearchDriversDTO> tbview;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        putDataTableView();
    }
    ObservableList<SearchDriversDTO> driversList = FXCollections.observableArrayList();
    public void putDataTableView(){
        driversList.clear();
        driversList.addAll(searchDriversService.getAllSearchDrivers());
        tbview.getColumns().clear();
        tbview.setItems(driversList);
        TableColumn<SearchDriversDTO,Long> agentId = new TableColumn<>("Agent_ID");
        agentId.setCellValueFactory(new PropertyValueFactory<>("agentID"));
        tbview.getColumns().add(agentId);

        TableColumn<SearchDriversDTO,String> agentName = new TableColumn<>("Agent_Name");
        agentName.setCellValueFactory(new PropertyValueFactory<>("agentName"));
        tbview.getColumns().add(agentName);

        TableColumn<SearchDriversDTO,String> agentStatus = new TableColumn<>("Status");
        agentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tbview.getColumns().add(agentStatus);


        TableColumn<SearchDriversDTO,String> agentEmail = new TableColumn<>("Email");
        agentEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbview.getColumns().add(agentEmail);


        TableColumn<SearchDriversDTO,String> agentAddress = new TableColumn<>("Address");
        agentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tbview.getColumns().add(agentAddress);

        TableColumn<SearchDriversDTO,String> agentRegister = new TableColumn<>("Register_Date");
        agentRegister.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        tbview.getColumns().add(agentRegister);

        TableColumn<SearchDriversDTO,Double> agentBalance = new TableColumn<>("Account_Balance");
        agentBalance.setCellValueFactory(new PropertyValueFactory<>("accountBalance"));
        tbview.getColumns().add(agentBalance);

        TableColumn<SearchDriversDTO,String> agentPasswords = new TableColumn<>("Password");
        agentPasswords.setCellValueFactory(new PropertyValueFactory<>("password"));
        tbview.getColumns().add(agentPasswords);
    }
}
