module bryan.mod5labpt2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens bryan.mod5labpt2 to javafx.fxml;
    exports bryan.mod5labpt2;
}