import java.io.Serializable;

public class Book implements Serializable {
    private String name, authorName;
    private int edition;

    public Book(String name, String authorName, int edition) {
        this.name = name;
        this.authorName = authorName;
        this.edition = edition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
