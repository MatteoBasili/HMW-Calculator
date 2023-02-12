module com.application.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.application.calculator to javafx.fxml;
    exports com.application.calculator;
}