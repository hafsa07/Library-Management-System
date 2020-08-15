import java.io.Serializable;

public class Librarian extends Person implements Serializable {
    public Librarian(String name, String contact, String username, String password, String cnic) {
        super(name, contact, username, password, cnic);
    }
}