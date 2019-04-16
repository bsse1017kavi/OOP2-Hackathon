package studentPackage;

import java.io.Serializable;

public class Personal implements Serializable
{
    private String name;
    private String fName;
    private String mName;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Personal(String name, String fName, String mName, String address) {
        this.name = name;
        this.fName = fName;
        this.mName = mName;
        this.address = address;
    }
}
