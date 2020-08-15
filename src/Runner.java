import javax.swing.*;
import java.awt.*;

public class Runner {
    // frame
    public static JFrame frame = new JFrame("LMS");

    // panels
    public static JLabel main_panel = new JLabel();
    public static JLabel loginStudentPanel = new JLabel();
    public static JLabel loginFacultyPanel = new JLabel();
    public static JLabel loginLibrarianPanel = new JLabel();
    public static JLabel studentPanel = new JLabel();
    public static JLabel facultyPanel = new JLabel();
    public static JLabel librarianPanel = new JLabel();

    // panel color
    public static Color panel_color = new Color(0, 0, 0, 125);

    // objects
    public static Student student = new Student();
    public static Faculty faculty = new Faculty();

    public static void main(String[] args) {

        // creating frame
        frame.setSize(1000, 500);
        frame.setLocation(200, 100);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // creating background label

        ImageIcon img = new ImageIcon((new ImageIcon("background.png")).getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
        main_panel = new JLabel("", img, SwingConstants.CENTER);
        main_panel.setBounds(0, 0, 1000, 500);

        loginStudentPanel = new JLabel("", img, SwingConstants.CENTER);
        loginStudentPanel.setBounds(0, 0, 1000, 500);
        loginStudentPanel.setVisible(false);

        loginFacultyPanel = new JLabel("", img, SwingConstants.CENTER);
        loginFacultyPanel.setBounds(0, 0, 1000, 500);
        loginFacultyPanel.setVisible(false);

        loginLibrarianPanel = new JLabel("", img, SwingConstants.CENTER);
        loginLibrarianPanel.setBounds(0, 0, 1000, 500);
        loginLibrarianPanel.setVisible(false);

        studentPanel = new JLabel("", img, SwingConstants.CENTER);
        studentPanel.setBounds(0, 0, 1000, 500);
        studentPanel.setVisible(false);

        facultyPanel = new JLabel("", img, SwingConstants.CENTER);
        facultyPanel.setBounds(0, 0, 1000, 500);
        facultyPanel.setVisible(false);

        librarianPanel = new JLabel("", img, SwingConstants.CENTER);
        librarianPanel.setBounds(0, 0, 1000, 500);
        librarianPanel.setVisible(false);

        //creating frames
        LibrarianPanel.createFrame();
        FacultyPanel.createFrame();
        loginStudentFrame.create();
        loginfacultyframe.create();
        librarianLoginFrame.create();
        StudentPanel.createFrame();
        MainPanel.createMainFrame();

        frame.add(main_panel);
        frame.setVisible(true);
        MainPanel.createMainFrame();


    }
}