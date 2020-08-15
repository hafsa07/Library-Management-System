import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class signupStudent extends JFrame {
    JLabel username, password, contact, cnic, regno, name;
    JTextField usernameTextField, passwordTextField, contactTextField, cnicTextField, regnoTextField, nameTextField;
    JButton okButton;

    public signupStudent() {
        getContentPane().setBackground(Color.black);
        setSize(400, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        username = new JLabel("USERNAME");
        name = new JLabel("NAME");
        password = new JLabel("PASSWORD");
        contact = new JLabel("CONTACT");
        cnic = new JLabel("CNIC");
        regno = new JLabel("REG. NUMBER");
        usernameTextField = new JTextField(12);
        passwordTextField = new JTextField(12);
        contactTextField = new JTextField(12);
        cnicTextField = new JTextField(12);
        regnoTextField = new JTextField(12);
        nameTextField = new JTextField(12);
        username.setForeground(Color.white);
        name.setForeground(Color.white);
        password.setForeground(Color.white);
        contact.setForeground(Color.white);
        cnic.setForeground(Color.white);
        regno.setForeground(Color.white);
        okButton = new JButton("OK");
        okButton.setBackground(Color.black);
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
        add(regno);
        add(regnoTextField);
        add(okButton);
        setVisible(true);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilingStudent filingStudent = new FilingStudent();

                String name = nameTextField.getText();
                String username = usernameTextField.getText();
                String regNo = regnoTextField.getText();
                String contact = contactTextField.getText();
                String cnic = cnicTextField.getText();
                String pass = passwordTextField.getText();

                if (filingText.searchText(usernameTextField.getText(), "usernameData.txt")) {
                    JOptionPane.showMessageDialog(null, "Username exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (filingText.searchText(regnoTextField.getText(), "regNoData.txt")) {
                    JOptionPane.showMessageDialog(null, "Reg no exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (!name.equals("") && !username.equals("") && !regNo.equals("") && !cnic.equals("") && !contact.equals("")) {

                        Student student = new Student(name, contact, username, pass, regNo, 4, cnic);
                        filingStudent.add(student, "Students.ser");
                        JOptionPane.showMessageDialog(null,"DONE","Message",JOptionPane.INFORMATION_MESSAGE);
                        filingText.addText(username,"usernameData.txt");
                        filingText.addText(regNo,"regNoData.txt");
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

        regnoTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!check.isString(e.getKeyChar()) && !check.isInteger(e.getKeyChar()) && e.getKeyChar()!='-') e.consume();
                if (regnoTextField.getText().length()>=12) e.consume();
            }
        });
    }
}
