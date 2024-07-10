module com.example.banco_central_nlogonia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.banco_central_nlogonia to javafx.fxml;
    exports com.example.banco_central_nlogonia;
}