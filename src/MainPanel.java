import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private static void createPanel() {
        JButton admin = new JButton("ADMIN");
        JButton faculty = new JButton("FACULTY");
        JButton student = new JButton("STUDENT");
        admin.setBounds(200, 130, 120, 50);
        admin.setBackground(Color.white);
        faculty.setBounds(200, 210, 120, 50);
        faculty.setBackground(Color.white);
        student.setBounds(200, 290, 120, 50);
        student.setBackground(Color.white);
        Runner.main_panel.add(admin);
        Runner.main_panel.add(faculty);
        Runner.main_panel.add(student);
        Runner.frame.add(Runner.main_panel);


        // Button
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.main_panel.setVisible(false);
                Runner.loginFacultyPanel.setVisible(false);
                Runner.loginStudentPanel.setVisible(false);
                Runner.loginLibrarianPanel.setVisible(true);
            }
        });

        faculty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.main_panel.setVisible(false);
                Runner.loginLibrarianPanel.setVisible(false);
                Runner.loginStudentPanel.setVisible(false);
                Runner.loginFacultyPanel.setVisible(true);
            }
        });

        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.main_panel.setVisible(false);
                Runner.loginLibrarianPanel.setVisible(false);
                Runner.loginFacultyPanel.setVisible(false);
                Runner.loginStudentPanel.setVisible(true);
            }
        });
    }

    public static void createMainFrame() {
        createPanel();

    }
}
