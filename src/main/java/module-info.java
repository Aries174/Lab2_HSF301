module com.hsf301.javafx.lab2_hsf301 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;



    opens com.hsf301.javafx.lab2_hsf301 to javafx.fxml;
    exports com.hsf301.javafx.lab2_hsf301;
    opens com.hsf301.javafx.lab2_hsf301.dto to javafx.fxml;
    exports com.hsf301.javafx.lab2_hsf301.dto;
    opens com.hsf301.javafx.lab2_hsf301.entity to javafx.fxml,org.hibernate.orm.core;
    exports com.hsf301.javafx.lab2_hsf301.entity;

}