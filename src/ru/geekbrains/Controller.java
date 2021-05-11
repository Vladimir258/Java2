package ru.geekbrains;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



import java.util.ArrayList;


public class Controller {

    ArrayList<String> duplicateMsg = new ArrayList<>();
    @FXML
    TextArea dialogArea;
    @FXML
    TextField sendText;

    public void keyEnterSend() {
        sendMessage();
    }

    public void btnOneClickAction(ActionEvent actionEvent) {
        sendMessage();
    }

    void sendMessage() {
        if(sendText.getText().equals("") || sendText.getText().equals(" ")) {
            AlertMsg.showAlert("Ошибка отправки","Для отправки сообщения необходимо ввести текст!");
        }
        else {
            // ArrayList где проверяются 4-е элемента, при вхождение последнего, если тот отличен от предыдущий...
            //      ...все кто перед ним выбрасываются из ArrayList
            duplicateMsg.add(sendText.getText()); // добавляем сообщение в Arraylist
            if(duplicateMsg.size() == 4) {
                if (!duplicateMsg.get(0).equals(duplicateMsg.get(1))) {
                    duplicateMsg.remove(0);
                    dialogArea.appendText(sendText.getText() + "\n"); // послать сообщение из sendText в dialogText
                } else if (!duplicateMsg.get(1).equals(duplicateMsg.get(2))) {
                    duplicateMsg.remove(0);
                    duplicateMsg.remove(1);
                    dialogArea.appendText(sendText.getText() + "\n"); // послать сообщение из sendText в dialogText
                } else if (duplicateMsg.get(2).equals(duplicateMsg.get(3))) {
                    AlertMsg.showAlert("Ошибка дублирование","Попытка отправки одного сообщения более 3-х раз!");
                    duplicateMsg.remove(3);
                } else {
                    duplicateMsg.remove(0);
                    duplicateMsg.remove(1);
                    dialogArea.appendText(sendText.getText() + "\n"); // послать сообщение из sendText в dialogText
                }
            } else {
                dialogArea.appendText(sendText.getText() + "\n"); // послать сообщение из sendText в dialogText
            }
            sendText.setText(""); // стереть текст в поле ввода текста
        }
        sendText.requestFocus(); // фокус на объекте
    }
}
