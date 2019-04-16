package serverPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import studentPackage.Academic;
import studentPackage.Account;
import studentPackage.Personal;
import studentPackage.Student;

import java.io.IOException;
import java.util.ArrayList;

public class Database
{
    @FXML TextField tx1;
    @FXML PasswordField tx2;

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

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    private boolean hasAdminAccess;

    public void addAccount(Student student)
    {
        students.add(student);
        System.out.println("Successfully added");
    }

    public void createStudent()
    {
       if(true)
       {
           //Personal info
           String s1,s2,s3,s4;

           //Scanner sc = new Scanner(System.in);
           s1 = tf1.getText();
           s2 = tf2.getText();
           s3 = tf3.getText();
           s4 = tf4.getText();

           Personal personal = new Personal(s1,s2,s3,s4);

           //Academic info
           double cgpa;

           s1 = tf5.getText();
           s2 = tf6.getText();
           s3 = tf7.getText();
           cgpa = Double.parseDouble(s3);

           Academic academic = new Academic(s1,s2,cgpa);

           //Bank account

           s1 = tf8.getText();
           s2 = tf9.getText();
           double balance = Double.parseDouble(s2);

           Account account = new Account(s1,balance);

           //username and password
           s1 = tf10.getText();
           s2 = tf11.getText();

           Student student = new Student(personal,academic,account,s1,s2);

           addAccount(student);
       }
    }

    public void addAdmin(ActionEvent e) throws IOException
    {
        String username = tx1.getText();
        String password = tx2.getText();
        Admin admin = new Admin(username,password);
        admins.add(admin);
        System.out.println("Added");

        Parent root2 = FXMLLoader.load(getClass().getResource("/scene2.fxml"));
        Scene scene2 = new Scene(root2);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void checkAdmin(String username,String password)
    {
        for(Admin admin:admins)
        {
            if(admin.getUsername().equals(username) && admin.password.equals(password))
            {
                hasAdminAccess = true;
                System.out.println("Admin access given");
                return;
            }
        }

        System.out.println("No such Account found");

        return;
    }
}
