import java.io.*;

public class filingText {

    // add text to file ------------------------------------------------------------------------------------------------
    public static void addText(String string, String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            printWriter.println(string);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // remove text from file -------------------------------------------------------------------------------------------
    public static void removeText(String string, String filename) {

        try {
            File data = new File(filename);
            File temp = new File("temp.txt");
            if (!data.exists()) data.createNewFile();
            if (!temp.exists()) temp.createNewFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(data));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(temp)));

            String line = bufferedReader.readLine();

            // Writing on temp
            while (line != null) {
                if (!line.equals(string)) {
                    printWriter.println(line);
                    line = bufferedReader.readLine();
                } else line = bufferedReader.readLine();
            }
            bufferedReader.close();
            printWriter.close();

            // Writing back from temp to dsata
            bufferedReader = new BufferedReader(new FileReader(temp));
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(data)));

            line = bufferedReader.readLine();
            while (line != null) {
                printWriter.println(line);
                line = bufferedReader.readLine();
            }

            printWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // search text
    public static boolean searchText(String search, String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();

            while (line != null) {
                if (line.equals(search)) {
                    bufferedReader.close();
                    return true;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // read text from file
    public static String getText(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) file.createNewFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String string = "";
            String line = bufferedReader.readLine();
            while (line != null) {
                string = string.concat(line + "\n");
                line = bufferedReader.readLine();
            }
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Nothing Found";
    }
}
