import java.io.*;

public class check {

    //check for string
    public static boolean isString(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < '9' && string.charAt(i) > '0')
                return false;
        }
        return true;
    }

    //check for string
    public static boolean isString(char string) {
        if ((string <= 'z' && string >= 'a') || (string <= 'Z' && string >= 'A'))
            return true;
        return false;
    }

    //check for integer
    public static boolean isInteger(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > '9' || string.charAt(i) < '0')
                return false;
        }
        return true;
    }

    //check for integer char
    public static boolean isInteger(char c) {
        if (c > '9' || c < '0')
            return false;
        return true;
    }


    //check for phone number
    public static boolean phoneNumber(String string) {
        if (check.isInteger(string)) {
            if (string.length() == 11) return true;
            else return false;
        } else return false;
    }

    //check for space in string
    public static boolean isSpace(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ')
                return false;
        }
        return true;
    }

    //check for space in char
    public static boolean isSpace(char c) {
        if (c == ' ')
            return false;

        return true;
    }

    //check for username equality
    public static boolean usernameMatches(String string) {
        try {
            File file = new File("username.txt");
            if (!file.exists()) file.createNewFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                if (line.equals(string)) {
                    return true;
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //check for lower case
    public static boolean isLowerCase(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        return false;
    }

    //check for Upper case
    public static boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

}