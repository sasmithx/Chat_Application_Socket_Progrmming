package lk.ijse.chat_app.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ClientController implements Initializable {
    @FXML
    private VBox emojiBox;

    @FXML
    private VBox imageBox;

    @FXML
    private AnchorPane imgPane;

    @FXML
    private Label labelTime;

    @FXML
    private Label labelTime1;

    @FXML
    private Label lblName;

    @FXML
    private AnchorPane logPane;

    @FXML
    private AnchorPane msgPane;

    @FXML
    private ScrollPane pane;

    @FXML
    private TextField sendText;

    @FXML
    private TextField userTxt;


    @FXML
    void loginOnAction(ActionEvent event) {
        String name = userTxt.getText();
        boolean isValidate = validation(name);

        if(isValidate){
            lblName.setText(name);
            imgPane.setVisible(false);
            logPane.setVisible(false);
            msgPane.setVisible(true);
        }
    }

    boolean validation(String name){
        Pattern idPattern = Pattern.compile("^[A-z\\s]{4,15}$");
        boolean matches = idPattern.matcher(name).matches();
        if(matches){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void emojiSend(MouseEvent event) {

    }

    @FXML
    void imageOnAction(MouseEvent event) {

    }



    @FXML
    void sendOnAction(MouseEvent event) {

    }

    @FXML
    void txtValiName(KeyEvent event) {

    }

    private void Timenow(){
        Thread thread =new Thread(() ->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM,  dd, yyyy");
            while (true){
                try{
                    Thread.sleep(1000);

                }catch (Exception e){
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                String timenow1 = sdf1.format(new Date());

                Platform.runLater(() ->{
                    labelTime.setText(timenow);
                    labelTime.setStyle("-fx-font-size: 25px; -fx-text-fill: white");
                    labelTime1.setText(timenow1);
                    labelTime1.setStyle("-fx-font-size: 15px; -fx-text-fill: white");
                });
            }
        });
        thread.start();
    }


}
