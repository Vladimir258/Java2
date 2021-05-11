package ru.geekbrains;

import javafx.scene.control.Alert;

public class AlertMsg {

    static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    static void showAlert(String title, String contentText) {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
