package serverPackage;

import studentPackage.Academic;
import studentPackage.Account;
import studentPackage.Personal;
import studentPackage.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Database
{
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    private boolean hasAdminAccess;

    public void addAccount(Student student)
    {
        students.add(student);
    }

    public void createStudent()
    {
       if(hasAdminAccess)
       {
           //Personal info
           String s1,s2,s3,s4;

           Scanner sc = new Scanner(System.in);
           s1 = sc.nextLine();
           s2 = sc.nextLine();
           s3 = sc.nextLine();
           s4 = sc.nextLine();

           Personal personal = new Personal(s1,s2,s3,s4);

           //Academic info
           double cgpa;

           s1 = sc.nextLine();
           s2 = sc.nextLine();
           cgpa = sc.nextDouble();

           Academic academic = new Academic(s1,s2,cgpa);

           //Bank account

           s1 = sc.nextLine();
           double balance = sc.nextDouble();

           Account account = new Account(s1,balance);

           //username and password
           s1 = sc.nextLine();
           s2 = sc.nextLine();

           Student student = new Student(personal,academic,account,s1,s2);

           addAccount(student);
       }
    }
}
