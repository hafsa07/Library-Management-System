import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

public class Person implements Serializable {
    protected String name,contact,username,password,cnic;

    public Person(){}

    public Person(String name, String contact, String username, String password, String cnic) {
        this.name = name;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.cnic = cnic;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
