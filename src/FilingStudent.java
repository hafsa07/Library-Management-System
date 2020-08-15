import java.io.*;
import java.util.ArrayList;

public class FilingStudent {

    // adding a student to file ----------------------------------------------------------------------------------------
    public void add(Student student, String filename) {
        try {
            boolean exits = new File(filename).exists();
            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(student);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read all students -----------------------------------------------------------------------------------------------
    public ArrayList<Student> readAll() {
        ArrayList<Student> StudentList = new ArrayList<Student>();
        File f = new File("Students.ser");
        if (f.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Students.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (fileInputStream.available() > 0) {
                    try {
                        StudentList.add((Student) objectInputStream.readObject());
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

    // remove a student from file --------------------------------------------------------------------------------------
    public boolean remove(String regno) {
        ArrayList<Student> StudentList = readAll();
        ArrayList<Student> UpdatedList = new ArrayList<Student>();
        boolean found = false;
        for (int i = 0; i < StudentList.size(); i++) {
            if (StudentList.get(i).getRegistrationNumber().equals(regno)) {
//                filingText.removeText(StudentList.get(i).getUsername(),"username.txt");
                found = true;
            } else {
                UpdatedList.add(StudentList.get(i));
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
    public void writeAll(ArrayList<Student> StudentList) {
        File file = new File("Students.ser");
        file.delete();
        try {
            boolean exits = file.exists();
            FileOutputStream fileOutputStream = new FileOutputStream("Students.ser", true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < StudentList.size(); i++) {
                outputStream.writeObject(StudentList.get(i));
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // update a list
    public void update(Student student) {
        ArrayList<Student> students = readAll();

        for (int i = 0 ; i < students.size() ;i++){
            if (student.getUsername().equals(students.get(i).getUsername())){
                students.set(i, student);
                writeAll(students);
                break;
            }
        }
    }
}