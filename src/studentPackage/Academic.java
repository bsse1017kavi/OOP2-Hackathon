package studentPackage;

public class Academic
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
}
