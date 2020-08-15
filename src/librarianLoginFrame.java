import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.CANCEL_OPTION;

public class librarianLoginFrame {

    static JLabel usernameTextfieldameLabel, passwordLabel;
    static JTextField usernameTextfield, passwordTextfield;
    static JButton loginButton;

    public static void create() {


        usernameTextfieldameLabel = new JLabel("User Name");
        usernameTextfieldameLabel.setBounds(100, 150, 100, 40);
        usernameTextfieldameLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        usernameTextfieldameLabel.setForeground(Color.white);
        usernameTextfield = new JTextField();
        usernameTextfield.setBounds(200, 150, 300, 40);
        passwordLabel = new JLabel("password");
        passwordLabel.setBounds(100, 200, 100, 40);
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        passwordLabel.setForeground(Color.white);
        passwordTextfield = new JTextField();
        passwordTextfield.setBounds(200, 200, 300, 40);
        loginButton = new JButton("LOG IN");
        loginButton.setBounds(230, 300, 100, 40);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);

        Runner.loginLibrarianPanel.add(usernameTextfieldameLabel);
        Runner.loginLibrarianPanel.add(usernameTextfield);
        Runner.loginLibrarianPanel.add(passwordLabel);
        Runner.loginLibrarianPanel.add(passwordTextfield);
        Runner.loginLibrarianPanel.add(loginButton);

        Runner.frame.add(Runner.loginLibrarianPanel);


        actionClick();
    }


    private static void actionClick() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean pass = filingText.searchText(passwordTextfield.getText(), "librarian.txt");

                if (usernameTextfield.getText().equals("hafsa") && pass) {
                    Runner.loginLibrarianPanel.setVisible(false);
                    Runner.librarianPanel.setVisible(true);
                } else JOptionPane.showMessageDialog(null,"invalid entries","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}