package studentPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Test_File {

    private String FILENAME = "academic.txt";

    public void  writeToFile_BufferWriter() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = JOptionPane.showInputDialog("Write about BSSE08");

            //open filewriter as write mode
            fw = new FileWriter(FILENAME);

            //open filewriter as append mode
//			fw = new FileWriter(FILENAME, true);


            bw = new BufferedWriter(fw);
            bw.flush();

            bw.write(content);

            System.out.println("Write Done" + content);

            if (bw != null)
                bw.close();

            if (fw != null)
                fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   

    public void listOfDirectory() {
        File file = null;
        String[] paths;

        try {
            // create new file object
            file = new File("download");

            // array of files and directory
            paths = file.list();

            // for each name in the path array
            for(String path:paths) {
                // prints filename and directory name
                System.out.println(path);
            }
        }catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

}

