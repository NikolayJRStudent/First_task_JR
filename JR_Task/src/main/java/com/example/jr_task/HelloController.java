package com.example.jr_task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {
    @FXML
    private Label encrypt_text_window;


    @FXML
    private TextField enter_text_window;

    @FXML
    private Label result_decrypt_window;

    @FXML
    void button_decrypt(ActionEvent event) {
        try {
            result_decrypt_window.setText(Decrypt_Class.return_decrypt_message_function());

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    String text_with_field_enter_text_window;

    @FXML
    void button_encrypt(ActionEvent event) throws IOException {
        text_with_field_enter_text_window = enter_text_window.getText();
        try {
            encrypt_text_window.setText(Encrypt_Class.return_encrypt_message_function(text_with_field_enter_text_window));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}