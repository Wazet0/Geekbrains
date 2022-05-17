module com.homework.lesson12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.homework.lesson12 to javafx.fxml;
    exports com.homework.lesson12;
}