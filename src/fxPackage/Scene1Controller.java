package fxPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import serverPackage.Admin;
import serverPackage.Database;

import java.io.IOException;

public class Scene1Controller
{

    @FXML
    TextField tx1;
    @FXML
    PasswordField tx2;

    @FXML TextField tf1;
    @FXML TextField tf2;
    @FXML TextField tf3;
    @FXML TextField tf4;

    @FXML TextField tf5;
    @FXML TextField tf6;
    @FXML TextField tf7;

    @FXML TextField tf8;
    @FXML TextField tf9;
    @FXML TextField tf10;

    @FXML PasswordField tf11;

    Database database = new Database();

    @FXML
    public void logIn(ActionEvent e) throws IOException
    {
        Parent root1b = FXMLLoader.load(getClass().getResource("/scene1b.fxml"));
        Scene scene1b = new Scene(root1b);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene1b);
        window.show();
    }

    @FXML
    public void signUp(javafx.event.ActionEvent e) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("/scene1.fxml"));
        Scene scene1 = new Scene(root1);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    public void checkAdmin(javafx.event.ActionEvent e) throws IOException {
        String username = tx1.getText();
        String password = tx2.getText();
        System.out.println(password);
        boolean chk = false;

        for (Admin admin : database.getAdmins())
        {
            System.out.println(admin.getUsername());

            if (admin.getUsername().equals(username) && admin.getPassword().equals(password))
            {
                database.setHasAdminAccess(true);
                System.out.println("Admin access given");
                chk = true;
                break;
            }

        }

        if(!chk)System.out.println("No such Account found");

        Parent root0 = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        Scene scene0 = new Scene(root0);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene0);
        window.show();

    }

        @FXML
        public void addAdmin(javafx.event.ActionEvent e) throws IOException
        {
            String username = tx1.getText();
            String password = tx2.getText();
            Admin admin = new Admin(username,password);
            database.getAdmins().add(admin);
            System.out.println("Added");

            /*for(Admin admin1:admins)
            {
                System.out.println(admin1.getUsername());
            }*/

            Parent root0 = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
            Scene scene0 = new Scene(root0);

            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
            window.setScene(scene0);
            window.show();
        }
}
