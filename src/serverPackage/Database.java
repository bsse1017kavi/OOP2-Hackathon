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
    private static ArrayList<Admin> admins = new ArrayList<>();

    private static boolean  hasAdminAccess;

    public void addAccount(Student student)
    {
        students.add(student);
        System.out.println("Successfully added");
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void createStudent()
    {
       if(hasAdminAccess)
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
           Serialize_IO serializeIo = new Serialize_IO();
           serializeIo.writeSerializeListObject(students);
           System.out.println("SI");
       }

        System.out.println("OK");
    }

    @FXML
    public void addAdmin(ActionEvent e) throws IOException
    {
        String username = tx1.getText();
        String password = tx2.getText();
        Admin admin = new Admin(username,password);
        admins.add(admin);
        System.out.println("Added");

        for(Admin admin1:admins)
        {
            System.out.println(admin1.getUsername());
        }

        Parent root0 = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        Scene scene0 = new Scene(root0);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene0);
        window.show();
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public boolean HasAdminAccess() {
        return hasAdminAccess;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public void setHasAdminAccess(boolean hasAdminAccess) {
        this.hasAdminAccess = hasAdminAccess;
    }

    @FXML
    public void checkAdmin(ActionEvent e) throws IOException
    {
        String username = tx1.getText();
        String password = tx2.getText();
        System.out.println(password);
        boolean chk = false;

        for(Admin admin:admins)
        {
            System.out.println(admin.getUsername());

            if(admin.getUsername().equals(username) && admin.getPassword().equals(password))
            {
                hasAdminAccess = true;
                System.out.println("Admin access given");
                chk = true;
                break;
            }


        }

        if(!chk)
        {
            hasAdminAccess=false;
            System.out.println("No such Account found");
        }

        Parent root0 = FXMLLoader.load(getClass().getResource("/scene2.fxml"));
        Scene scene0 = new Scene(root0);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene0);
        window.show();

        //return;

    }

    @FXML
    public void signUp(ActionEvent e) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("/scene1.fxml"));
        Scene scene1 = new Scene(root1);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    public void logIn(ActionEvent e) throws IOException
    {
        Parent root1b = FXMLLoader.load(getClass().getResource("/scene1b.fxml"));
        Scene scene1b = new Scene(root1b);

        for(Admin admin1:admins)
        {
            System.out.println(admin1.getUsername());
        }

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene1b);
        window.show();
    }
}
