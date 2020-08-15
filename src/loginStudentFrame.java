import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class loginStudentFrame {
    static JLabel usernameLabel, passwordLabel;
    static JTextField usernameTextField, passwordTextField;
    static JButton loginButton, signupButton;


    public static void create() {
        usernameLabel = new JLabel("User Name");
        usernameLabel.setBounds(100, 150, 100, 40);
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        usernameLabel.setForeground(Color.white);
        usernameTextField = new JTextField();
        usernameTextField.setBounds(200, 150, 300, 40);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 200, 100, 40);
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        passwordLabel.setForeground(Color.white);
        passwordTextField = new JTextField();
        passwordTextField.setBounds(200, 200, 300, 40);
        loginButton = new JButton("LOG IN");
        loginButton.setBounds(230, 300, 100, 40);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(350, 300, 100, 40);
        signupButton.setBackground(Color.black);
        signupButton.setForeground(Color.white);
        Runner.loginStudentPanel.add(usernameLabel);
        Runner.loginStudentPanel.add(usernameTextField);
        Runner.loginStudentPanel.add(passwordLabel);
        Runner.loginStudentPanel.add(passwordTextField);
        Runner.loginStudentPanel.add(loginButton);
        Runner.loginStudentPanel.add(signupButton);
        Runner.frame.add(Runner.loginStudentPanel);

        actionClick();
    }


    private static void actionClick() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;

                FilingStudent filingStudent = new FilingStudent();
                ArrayList<Student> students = filingStudent.readAll();

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getUsername().equals(usernameTextField.getText()) && students.get(i).getPassword().equals(passwordTextField.getText())){
                        Runner.student = students.get(i);
                        b= true;
                        break;
                    }
                }

                if (b) {

                    Runner.loginStudentPanel.setVisible(false);
                    Runner.main_panel.setVisible(false);
                    Runner.loginStudentPanel.setVisible(false);
                    Runner.loginFacultyPanel.setVisible(false);
                    Runner.loginLibrarianPanel.setVisible(false);
                    Runner.studentPanel.setVisible(true);


                } else JOptionPane.showMessageDialog(new JFrame(), "Invalid entries","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupStudent signupStudent = new signupStudent();
            }
        });
    }
}
