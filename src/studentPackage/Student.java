package studentPackage;

import java.io.Serializable;

public class Student implements Serializable
{
    private Personal personalInfo;
    private Academic academicInfo;
    private Account bankAccount;
    private String username;
    private String password;

    public Personal getPersonalInfo() {
        return personalInfo;
    }

    public Academic getAcademicInfo() {
        return academicInfo;
    }

    public Student(Personal personalInfo, Academic academicInfo, Account bankAccount, String username, String password) {
        this.personalInfo = personalInfo;
        this.academicInfo = academicInfo;
        this.bankAccount = bankAccount;
        this.username = username;
        this.password = password;
    }
}
