package com.homework.lesson12;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ChatController implements Initializable {
    @FXML
    private VBox mainPanel;
    @FXML
    private TextArea chatArea;
    @FXML
    private ListView<String> contacts;
    @FXML
    private TextField inputField;
    @FXML
    private Button btnSend;


    @FXML
    public void mockAction(ActionEvent actionEvent) {
        System.out.println("mock");
    }

    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        String text = inputField.getText();
        if (text == null || text.isBlank()){
            return;
        }

        MultipleSelectionModel<String> contactsSelectionModel = contacts.getSelectionModel();
        if(!(contactsSelectionModel.getSelectedItems().size() == 0)){
            String name = contactsSelectionModel.getSelectedItems().get(0);
            if(contactsSelectionModel.getSelectedItems().indexOf("BROADCAST") == 0){
                text = "Broadcast: " + text;
            }else {
                text = "[" + name + "]" + ": " + text;
            }
        } else{
            text = "Broadcast: " + text;
        }
        chatArea.appendText(text + System.lineSeparator());
        inputField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> names = List.of("BROADCAST", "Vasya", "Masha", "Valera", "Nastya");
        contacts.setItems(FXCollections.observableList(names));
    }

    @FXML
    public void instructAction(ActionEvent actionEvent) throws IOException {
        Stage helpWindow = new Stage();
        helpWindow.setTitle("Instruction");

        BorderPane layout = new BorderPane();
        Scene helpScene = new Scene(layout, 600, 200);

        Label label = new Label("Инструкция:\n" +
                "    1 - На экране есть всего одна кнопка, эта кнопка чтобы отправить сообщение\n" +
                "    2 - Все сообщения высвечиваются в левой части экрана\n" +
                "    3 - Все пользователи высвечиваются в правой части экрана(на них можно нажимать)\n");
        Button button = new Button("Понял");
        button.setLayoutY(2000);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpWindow.close();
            }
        });
        layout.setCenter(label);
        layout.setBottom(button);
        BorderPane.setMargin(button, new Insets(20,20,20,300));

        helpWindow.setScene(helpScene);

        helpWindow.show();
    }
}