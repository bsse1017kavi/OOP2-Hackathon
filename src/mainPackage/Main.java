package mainPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import serverPackage.Database;

import java.util.Scanner;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        //AnchorPane root = new AnchorPane();
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        /*Database db = new Database();
        Scanner sc = new Scanner(System.in);

        String s1,s2;

        s1 = sc.nextLine();
        s2 = sc.nextLine();

        //db.addAdmin(s1,s2);

        s1 = sc.nextLine();
        s2 = sc.nextLine();
        db.checkAdmin(s1,s2);
        db.createStudent();*/
    }
}
