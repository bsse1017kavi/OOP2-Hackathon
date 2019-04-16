package studentPackage;

import java.io.Serializable;

public class Academic implements Serializable
{
    private String roll;
    private String reg;
    private double cgpa;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Academic{" +
                "roll='" + roll + '\'' +
                ", reg='" + reg + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

    public Academic(String roll, String reg, double cgpa) {
        this.roll = roll;
        this.reg = reg;
        this.cgpa = cgpa;
    }
}
