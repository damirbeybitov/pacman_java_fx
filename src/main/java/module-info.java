module com.example.summerproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.summerproject to javafx.fxml;
    exports com.example.summerproject;
}