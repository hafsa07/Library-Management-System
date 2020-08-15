import java.io.*;
import java.util.ArrayList;

public class FilingFaculty {

    // adding a faculty to file ----------------------------------------------------------------------------------------
    public void add(Faculty faculty, String filename) {
        try {
            boolean exits = new File(filename).exists();
            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(faculty);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read all faculty -----------------------------------------------------------------------------------------------
    public ArrayList<Faculty> readAll() {
        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
        File f = new File("Faculty.ser");
        if (f.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Faculty.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (fileInputStream.available() > 0) {
                    try {
                        facultyList.add((Faculty) objectInputStream.readObject());
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
            return facultyList;
        } else
            return facultyList;
    }

    // remove a faculty from file --------------------------------------------------------------------------------------
    public boolean remove(String regno) {
        ArrayList<Faculty> facultyList = readAll();
        ArrayList<Faculty> UpdatedList = new ArrayList<Faculty>();
        boolean found = false;
        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getUsername().equals(regno)) {
                found = true;
            } else {
                UpdatedList.add(facultyList.get(i));
            }
        }
        if (found) {
            writeAll(UpdatedList);
            return true;
        } else {
            return false;
        }
    }

    // write faculty list to file --------------------------------------------------------------------------------------
    public void writeAll(ArrayList<Faculty> facultyList) {
        File file = new File("Faculty.ser");
        file.delete();
        try {
            boolean exits = file.exists();
            FileOutputStream fileOutputStream = new FileOutputStream("Faculty.ser", true);
            ObjectOutputStream outputStream = exits ? new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            } : new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < facultyList.size(); i++) {
                outputStream.writeObject(facultyList.get(i));
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // update a list
    public void update(Faculty faculty) {
        ArrayList<Faculty> faculties = readAll();

        for (int i = 0; i < faculties.size(); i++) {
            if (faculty.getUsername().equals(faculties.get(i).getUsername())) {
                faculties.set(i, faculty);
                writeAll(faculties);
                break;
            }
        }
    }
}