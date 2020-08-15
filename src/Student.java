import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person implements Serializable {
    private String registrationNumber;
    private double fine = 0;
    private ArrayList<Book> issuedBooks = new ArrayList<>();

    public Student() {

    }

    public Student(Student student) {
        this.name = student.name;
        this.username = student.username;
        this.password = student.password;
        this.contact = student.contact;
        this.registrationNumber = student.registrationNumber;
        this.cnic = student.cnic;
    }

    public Student(String name, String contact, String username, String password, String registrationNumber, int bookLimit, String cnic) {
        super(name, contact, username, password, cnic);
        this.registrationNumber = registrationNumber;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
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
            if (this.issuedBooks.get(i)!=null){
                count++;
            }
        }
        return count;
    }

    public void removeBook(Book book){
        for (int i = 0 ; i < this.issuedBooks.size() ; i++){
            if (this.issuedBooks.get(i).getName().equals(book.getName())){
                this.issuedBooks.remove(i);
                break;
            }
        }
    }

    public void addBook(Book book){
        this.issuedBooks.add(book);
    }
}
