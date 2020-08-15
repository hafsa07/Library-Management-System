import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class signupFaculty extends JFrame {
    JLabel username, password, contact, cnic, department, name;
    JTextField usernameTextField, passwordTextField, contactTextField, cnicTextField, deptTextField, nameTextField;
    JButton okButton;

    public signupFaculty() {
        getContentPane().setBackground(new Color(64,64,64));
        setResizable(false);
        setLayout(new GridLayout(7,2));
        username = new JLabel("USERNAME");
        name = new JLabel("NAME");
        password = new JLabel("PASSWORD");
        contact = new JLabel("CONTACT");
        cnic = new JLabel("CNIC");
        department = new JLabel("DEPARTMENT");
        usernameTextField = new JTextField(12);
        passwordTextField = new JTextField(12);
        contactTextField = new JTextField(12);
        cnicTextField = new JTextField(12);
        deptTextField = new JTextField(12);
        nameTextField = new JTextField(12);
        username.setForeground(Color.white);
        name.setForeground(Color.white);
        password.setForeground(Color.white);
        contact.setForeground(Color.white);
        cnic.setForeground(Color.white);
        department.setForeground(Color.white);
        okButton = new JButton("OK");
        okButton.setBackground(new Color(64,64,64));
        okButton.setFocusPainted(false);
        okButton.setBorderPainted(false);
        okButton.setForeground(Color.white);
        add(name);
        add(nameTextField);
        add(username);
        add(usernameTextField);
        add(password);
        add(passwordTextField);
        add(contact);
        add(contactTextField);
        add(cnic);
        add(cnicTextField);
        add(department);
        add(deptTextField);
        add(okButton);
        pack();
        setVisible(true);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilingFaculty filingFaculty = new FilingFaculty();

                String name = nameTextField.getText();
                String username = usernameTextField.getText();
                String dept = deptTextField.getText();
                String contact = contactTextField.getText();
                String cnic = cnicTextField.getText();

                if (filingText.searchText(usernameTextField.getText(), "usernameData.txt")) {
                    JOptionPane.showMessageDialog(null, "Username exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (!name.equals("") && !username.equals("") && !dept.equals("") && !cnic.equals("") && !contact.equals("")) {

                        Faculty faculty = new Faculty(name, contact, username, "0000", dept, 6, cnic);
                        filingFaculty.add(faculty, "Faculty.ser");
                        JOptionPane.showMessageDialog(null, "DONE", "Message", JOptionPane.INFORMATION_MESSAGE);
                        filingText.addText(username, "usernameData.txt");

                    } else {
                        JOptionPane.showMessageDialog(null, "Empty fields", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                dispose();
            }
        });

        // actions
        nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!check.isString(e.getKeyChar()) && check.isSpace(e.getKeyChar())) e.consume();
            }
        });

        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!check.isString(e.getKeyChar()) && !check.isInteger(e.getKeyChar())) e.consume();
            }
        });

        contactTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!check.isInteger(e.getKeyChar())) e.consume();
                if (contactTextField.getText().length()>=11) e.consume();
            }
        });

        cnicTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!check.isInteger(e.getKeyChar())) e.consume();
                if (cnicTextField.getText().length()>=13) e.consume();
            }
        });

        deptTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!check.isString(e.getKeyChar()) && check.isSpace(e.getKeyChar())) e.consume();
            }
        });
    }
}
