import java.io.*;
import java.util.ArrayList;

public class FilingLibrary {

    // adding a student to file ----------------------------------------------------------------------------------------
    public void add(Book book, String filename) {
        try {
            boolean exits = new File(filename).exists();
            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(book);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read all students -----------------------------------------------------------------------------------------------
    public ArrayList<Book> readAll() {
        ArrayList<Book> StudentList = new ArrayList<Book>();
        File f = new File("Library.ser");
        if (f.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Library.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (fileInputStream.available() > 0) {
                    try {
                        StudentList.add((Book) objectInputStream.readObject());
                    } catch (EOFException e) {
                        objectInputStream.close();
                        break;
                    }
                }
                objectInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return StudentList;
        } else
            return StudentList;
    }

    // remove a Book from file --------------------------------------------------------------------------------------
    public boolean remove(String name) {
        ArrayList<Book> books = readAll();
        ArrayList<Book> UpdatedList = new ArrayList<Book>();
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
//                filingText.removeText(StudentList.get(i).getUsername(),"username.txt");
                found = true;
            } else {
                UpdatedList.add(books.get(i));
            }
        }
        if (found) {
            writeAll(UpdatedList);
            return true;
        } else {
            return false;
        }
    }

    // write student list to file --------------------------------------------------------------------------------------
    public void writeAll(ArrayList<Book> books) {
        File file = new File("Library.ser");
        file.delete();
        try {
            boolean exits = file.exists();
            FileOutputStream fileOutputStream = new FileOutputStream("Library.ser", true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < books.size(); i++) {
                outputStream.writeObject(books.get(i));
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}