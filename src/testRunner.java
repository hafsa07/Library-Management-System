import java.util.ArrayList;

public class testRunner {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new Book("SUFISM","JALALUDIN RUMI",1);
        books[1] = new Book("DIGITAL LOGIC DESIGN","MORRIS MANO",10);
        books[2] = new Book("40 RULES OF LOVE","JALALUDDIN RUMI",1);
        books[3] = new Book("DIFFERENTIAL EQUATION","WILLIAMS",2);
        books[4] = new Book("MIDNIGHT SUN","UNKNOWN",4);
        books[5] = new Book("HARRY PORTER","UNKNOWN",1);
        books[6] = new Book("HARRY PORTER","UNKNOWN",2);
        books[7] = new Book("POLITICS","NELSON MANDELA",2);
        books[8] = new Book("FREEDOM","MOTHER TERESA",3);
        books[9] = new Book("TWINKLING STAR","ARSALAN PASHA",3);
        FilingLibrary library = new FilingLibrary();

        for (int i = 0 ; i < books.length ; i++) {
            library.add(books[i], "Library.ser");
        }

    }
}
