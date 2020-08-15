import java.io.Serializable;
import java.util.ArrayList;

public class Faculty extends Person implements Serializable {
    private String department;
    private double fine = 0;
    private ArrayList<Book> issuedBooks = new ArrayList<>();

    public Faculty() {

    }

    public Faculty(Faculty faculty) {
        this.name = faculty.name;
        this.username = faculty.username;
        this.password = faculty.password;
        this.contact = faculty.contact;
        this.department = faculty.department;
        this.cnic = faculty.cnic;
    }

    public Faculty(String name, String contact, String username, String password, String department, int bookLimit, String cnic) {
        super(name, contact, username, password, cnic);
        this.department = department;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(ArrayList<Book> issedBooks) {
        this.issuedBooks = issedBooks;
    }

    public int getNoOfIssuedBooks() {
        int count = 0;
        for (int i = 0; i < this.issuedBooks.size(); i++) {
            if (this.issuedBooks.get(i) != null) {
                count++;
            }
        }
        return count;
    }

    public void removeBook(Book book) {
        for (int i = 0; i < this.issuedBooks.size(); i++) {
            if (this.issuedBooks.get(i).getName().equals(book.getName())) {
                this.issuedBooks.remove(i);
                break;
            }
        }
    }

    public void addBook(Book book) {
        this.issuedBooks.add(book);
    }
}
