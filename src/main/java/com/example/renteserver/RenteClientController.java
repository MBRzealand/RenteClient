package com.example.renteserver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RenteClientController {

    static NetworkDetails networkDetails = new NetworkDetails();

    BufferedReader inputStream =null;
    PrintWriter outputStream =null;
    Socket socket =null;

    @FXML
    private TextField interest_editText;

    @FXML
    private TextField years_editText;

    @FXML
    private TextField amount_editText;

    @FXML
    private TextArea infoBox;

    String interestRate;
    String years;
    String amount;

    @FXML
    void submitDetails(ActionEvent event) throws IOException {

        socket = new Socket(networkDetails.getServerIP(), networkDetails.getPORT());
        outputStream = new PrintWriter(socket.getOutputStream());
        inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputString = null;

            interestRate = interest_editText.getText();
            years = years_editText.getText();
            amount = amount_editText.getText();

            outputStream.println("Intrest Rate:" + interestRate);
            outputStream.println("Years:" + years);
            outputStream.println("Amount:" + amount);
            outputStream.flush();
            socket.shutdownOutput();

            infoBox.appendText("Sent following data to server");
            infoBox.appendText("\n" + "Intrest Rate: " + interestRate);
            infoBox.appendText("\n" + "Years: " + years);
            infoBox.appendText("\n" + "Amount:" + amount);

            inputString = inputStream.readLine();
            infoBox.appendText("\n" + inputString);

            socket.shutdownInput();
            socket.close();

    }

}
