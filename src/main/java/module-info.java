module com.example.javatpnote {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javatpnote to javafx.fxml;
    exports com.example.javatpnote;
}