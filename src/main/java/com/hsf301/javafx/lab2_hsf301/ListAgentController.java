package com.hsf301.javafx.lab2_hsf301;

import com.hsf301.javafx.lab2_hsf301.dto.SearchDriversDTO;
import com.hsf301.javafx.lab2_hsf301.entity.SearchDrivers;
import com.hsf301.javafx.lab2_hsf301.service.SearchDriversImpl;
import com.hsf301.javafx.lab2_hsf301.service.SearchDriversService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class ListAgentController  implements Initializable {
    @FXML
    public Label welcomeText1;
    @FXML
    public Label welcomeText11;
    @FXML
    public Label welcomeText12;
    @FXML
    public Label welcomeText;
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
    public void buttonSearch(ActionEvent event) {
        String name=tenDaiLy.getText();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getDatabaseConnection();
        String sql="select * from searchdrivers where Agent_Name='"+name+"'";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            driversList.clear();
            while(resultSet.next()){
                SearchDriversDTO searchDriversDTO = new SearchDriversDTO();
                searchDriversDTO.setAgentID(resultSet.getInt("Agent_ID"));
                searchDriversDTO.setAgentName(resultSet.getString("Agent_Name"));
                searchDriversDTO.setStatus(resultSet.getString("Status"));
                searchDriversDTO.setEmail(resultSet.getString("Email"));
                searchDriversDTO.setAddress(resultSet.getString("Address"));
                searchDriversDTO.setRegisterDate(resultSet.getDate("Register_Date"));
                searchDriversDTO.setAccountBalance(resultSet.getDouble("Account_Balance"));
                searchDriversDTO.setPassword(resultSet.getString("Password"));
                driversList.add(searchDriversDTO);

            }
            tbview.setItems(driversList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private SearchDriversService searchDriversService = new SearchDriversImpl();
    ObservableList<SearchDriversDTO> driversList = FXCollections.observableArrayList();
    public void putDataTableView() {
        driversList.clear();
        driversList.addAll(searchDriversService.getAllSearchDrivers());
        tbview.getColumns().clear();
        tbview.setItems(driversList);
        TableColumn<SearchDriversDTO, Long> agentId = new TableColumn<>("Agent_ID");
        agentId.setCellValueFactory(new PropertyValueFactory<>("agentID"));
        tbview.getColumns().add(agentId);

        TableColumn<SearchDriversDTO, String> agentName = new TableColumn<>("Agent_Name");
        agentName.setCellValueFactory(new PropertyValueFactory<>("agentName"));
        tbview.getColumns().add(agentName);

        TableColumn<SearchDriversDTO, String> agentStatus = new TableColumn<>("Status");
        agentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tbview.getColumns().add(agentStatus);


        TableColumn<SearchDriversDTO, String> agentEmail = new TableColumn<>("Email");
        agentEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbview.getColumns().add(agentEmail);


        TableColumn<SearchDriversDTO, String> agentAddress = new TableColumn<>("Address");
        agentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tbview.getColumns().add(agentAddress);

        TableColumn<SearchDriversDTO, String> agentRegister = new TableColumn<>("Register_Date");
        agentRegister.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        tbview.getColumns().add(agentRegister);

        TableColumn<SearchDriversDTO, Double> agentBalance = new TableColumn<>("Account_Balance");
        agentBalance.setCellValueFactory(new PropertyValueFactory<>("accountBalance"));
        tbview.getColumns().add(agentBalance);

        TableColumn<SearchDriversDTO, String> agentPasswords = new TableColumn<>("Password");
        agentPasswords.setCellValueFactory(new PropertyValueFactory<>("password"));
        tbview.getColumns().add(agentPasswords);
        TableColumn<SearchDriversDTO, Void> detailColumn = new TableColumn<>("Xem Chi Tiet");
        tbview.getColumns().add(detailColumn);
    }
    private  void showAgentDetails(SearchDriversDTO agentDTO){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/hsf301/javafx/lab2_hsf301/AgentDetails.fxml"));
            Stage detailStage = new Stage();
            detailStage.initModality(Modality.APPLICATION_MODAL);

            //lay stage
            Stage agentStage = (Stage)tbview.getScene().getWindow();
            detailStage.initOwner(agentStage);


            detailStage.setTitle("Chi Tiet Dai Ly");
            Scene detailSence = new Scene(fxmlLoader.load(),881,672);
            detailStage.setScene(detailSence);

            //lay controller va truyen du lieu
            AgentDetailController agentDetailController = fxmlLoader.getController();
            agentDetailController.setAgent(agentDTO);




            detailStage.showAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }


}
