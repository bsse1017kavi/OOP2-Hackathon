package fxPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import serverPackage.Admin;

import java.io.IOException;

public class scene0Controller
{
    @FXML
    Button bt1;
    @FXML Button bt2;

    @FXML
    public void signUp(ActionEvent e) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("/scene1.fxml"));
        Scene scene1 = new Scene(root1);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }



}
