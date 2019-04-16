package studentPackage;

import serverPackage.Serialize_IO;

import java.util.ArrayList;

public class Certificate
{
    Serialize_IO serialize_io = new Serialize_IO();

    public void createCertificate()
    {
        ArrayList<Student> students = serialize_io.readDeserializeListObject();

        for(Student student:students)
        {
            System.out.println(student);
        }
    }
}
