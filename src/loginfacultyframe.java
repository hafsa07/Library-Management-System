import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class loginfacultyframe {

    static JLabel usernameLabel,passwordLabel;
    static JTextField usernameTextField,passwordTextField;
    static JButton loginButton,signupButton;

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
        signupButton = new JButton("Sign up");
        signupButton.setBounds(350, 300, 100, 40);
        signupButton.setBackground(Color.black);
        signupButton.setForeground(Color.white);

        Runner.loginFacultyPanel.add(usernameLabel);
        Runner.loginFacultyPanel.add(usernameTextField);
        Runner.loginFacultyPanel.add(passwordLabel);
        Runner.loginFacultyPanel.add(passwordTextField);
        Runner.loginFacultyPanel.add(loginButton);
        Runner.loginFacultyPanel.add(signupButton);


        Runner.frame.add(Runner.loginFacultyPanel);

        actionClick();
        actionsTextfield();
    }

    private static void actionClick(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;

                FilingFaculty filingFaculty = new FilingFaculty();
                ArrayList<Faculty> faculties = filingFaculty.readAll();

                for (int i = 0; i < faculties.size(); i++) {
                    if (faculties.get(i).getUsername().equals(usernameTextField.getText()) && faculties.get(i).getPassword().equals(passwordTextField.getText())){
                        Runner.faculty = faculties.get(i);
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
                    Runner.studentPanel.setVisible(false);
                    Runner.facultyPanel.setVisible(true);


                } else JOptionPane.showMessageDialog(new JFrame(), "Invalid entries","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupFaculty signupFaculty = new signupFaculty();
            }
        });
    }

    // textfield actions
    private static void actionsTextfield(){
        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()==' ') e.consume();
                if(e.getKeyChar()<='9' && e.getKeyChar()>'0') e.consume();
            }
        });
    }

}

