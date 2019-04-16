package studentPackage;

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
import serverPackage.Serialize_IO;


import java.io.IOException;
import java.util.ArrayList;

public class Certificate
{
    Serialize_IO serialize_io = new Serialize_IO();
    @FXML
    TextField tx1;
    @FXML
    PasswordField tx2;

    public void createCertificate(Student st)
    {
        String content = "I herby certify that Mr. " +st.getPersonalInfo().getName() +",Son of Mr."+st.getPersonalInfo().getfName()+
                "\ngot cgpa "+st.getAcademicInfo().getCgpa()+"\nHis conduct was satisfactory.";

        Test_File test_file = new Test_File();

        test_file.writeToFile_BufferWriter(content);
    }

    @FXML
    public void checkStudent(ActionEvent e) throws IOException
    {
        String username = tx1.getText();
        String password = tx2.getText();
        System.out.println(password);
        boolean chk = false;
        Student st = null;

        ArrayList<Student> students = serialize_io.readDeserializeListObject();

        for(Student student:students)
        {
            if(student.getUsername().equals(username) && student.getPassword().equals(password) &&student.getBankAccount().getBalance()>1000)
            {
                st = student;
                st.getBankAccount().withdraw(1000);
                break;
            }
        }

        if(st!=null) createCertificate(st);



        //return;

    }
}
