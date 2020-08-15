import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class StudentPanel {

    // Sliding panel
    private static JPanel sliding_panel = new JPanel();
    private static JPanel sliding_button = new JPanel();

    private static JButton profile_button = new JButton("P R O F I L E");
    private static JButton search_button = new JButton("S E A R C H");
    private static JButton return_button = new JButton("R E T U R N");
    private static JButton history_button = new JButton("H I S T O R Y");
    private static JButton logout_button = new JButton("L O G O U T");

    // Boolean page clicks
    private static boolean page_profile = true;
    private static boolean page_search = false;
    private static boolean page_return = false;
    private static boolean page_history = false;
    private static boolean page_logout = false;

    // Profile Panel
    private static JPanel profile_panel = new JPanel();

    private static JTable profileTable = new JTable(5, 2);

    // Search Panel
    private static JPanel search_panel = new JPanel();
    private static JLabel book_name = new JLabel("ENTER BOOK NAME");
    private static JTextField bookTextField = new JTextField(12);
    private static JButton searchbutton = new JButton("SEARCH");

    // Return pane
    private static JPanel return_panel = new JPanel();
    private static DefaultListModel model = new DefaultListModel();
    private static JList return_list = new JList(model);
    private static JButton returnBook_button = new JButton("Return");

    // History panel
    private static JPanel history_panel = new JPanel();
    private static JTextArea historyarea = new JTextArea();
    private static JScrollPane s = new JScrollPane();

    private static void createSlidingPanel() {
        // panel
        sliding_panel.setBounds(1, 0, 125, 470);
        sliding_panel.setLayout(null);
        sliding_panel.setBackground(Runner.panel_color);
        sliding_panel.setVisible(false);

        sliding_button.setBounds(0, 0, 15, 470);
        sliding_button.setBackground(Runner.panel_color);
        sliding_button.setVisible(true);

        // setting up button labels
        profile_button.setForeground(Color.yellow);
        profile_button.setFocusPainted(false);
        profile_button.setBorderPainted(false);
        profile_button.setBackground(new Color(0, 0, 0, 0));
        profile_button.setBounds(1, 130, 120, 25);

        search_button.setForeground(Color.white);
        search_button.setFocusPainted(false);
        search_button.setBorderPainted(false);
        search_button.setBackground(new Color(0, 0, 0, 0));
        search_button.setBounds(1, 180, 120, 25);

        return_button.setForeground(Color.white);
        return_button.setFocusPainted(false);
        return_button.setBorderPainted(false);
        return_button.setBackground(new Color(0, 0, 0, 0));
        return_button.setBounds(1, 230, 120, 25);

        history_button.setForeground(Color.white);
        history_button.setFocusPainted(false);
        history_button.setBorderPainted(false);
        history_button.setBackground(new Color(0, 0, 0, 0));
        history_button.setBounds(1, 280, 120, 25);

        logout_button.setForeground(Color.white);
        logout_button.setFocusPainted(false);
        logout_button.setBorderPainted(false);
        logout_button.setBackground(new Color(0, 0, 0, 0));
        logout_button.setBounds(1, 330, 120, 25);

        // adding buttons to sliding panels
        sliding_panel.add(profile_button);
        sliding_panel.add(search_button);
        sliding_panel.add(return_button);
        sliding_panel.add(history_button);
        sliding_panel.add(logout_button);

        // adding components
        Runner.studentPanel.add(sliding_panel);
        Runner.studentPanel.add(sliding_button);
    }

    private static void createSearchPanel() {
        // panel
        search_panel.setBounds(137, 110, 700, 300);
        search_panel.setBackground(Runner.panel_color);
        search_panel.setLayout(null);
        search_panel.setVisible(false);

        book_name.setBounds(120, 100, 200, 25);
        book_name.setFont(new Font("Calibiri", Font.BOLD, 15));
        book_name.setForeground(Color.WHITE);
        bookTextField.setBounds(300, 100, 150, 25);
        searchbutton.setBounds(480, 100, 100, 30);
        searchbutton.setForeground(Color.white);
        searchbutton.setBackground(Color.black);
        //SEARCH PANEL
        search_panel.add(book_name);
        search_panel.add(bookTextField);
        search_panel.add(searchbutton);

        // adding components
        Runner.studentPanel.add(search_panel);
    }

    private static void createHistoryPanel() {
        // panel
        history_panel.setBounds(137, 110, 700, 300);
        history_panel.setBackground(Runner.panel_color);
        history_panel.setLayout(null);
        history_panel.setVisible(false);

        historyarea.setBounds(200, 50, 300, 200);
        historyarea.setEnabled(false);
        historyarea.setForeground(Color.white);
        historyarea.setBackground(new Color(92, 92, 92));

        history_panel.add(historyarea);

        // adding components
        Runner.studentPanel.add(history_panel);
    }

    private static void createReturnPanel() {
        // panel
        return_panel.setBounds(137, 110, 700, 300);
        return_panel.setBackground(Runner.panel_color);
        return_panel.setLayout(null);
        return_panel.setVisible(false);

        return_list.setBounds(450, 85, 100, 130);
        return_list.setBackground(Color.black);
        return_list.setForeground(Color.white);

        // returnbook_button
        returnBook_button.setBounds(100, 200, 100, 25);
        returnBook_button.setBackground(Color.black);
        returnBook_button.setForeground(Color.white);
        returnBook_button.setFocusPainted(false);

        //adding to return panel
        return_panel.add(return_list);
        return_panel.add(returnBook_button);

        // adding components
        Runner.studentPanel.add(return_panel);
        Runner.studentPanel.add(return_panel);
    }

    public static void createProfilePanel() {
        // panel
        profile_panel.setBounds(137, 110, 700, 300);
        profile_panel.setBackground(Runner.panel_color);
        profile_panel.setLayout(null);

        profile_panel.setVisible(false);

        //PROFILE TABLE
        profileTable.setBounds(210, 80, 280, 250);
        profileTable.setValueAt("NAME", 0, 0);
        profileTable.setValueAt("REG. NUMBER", 1, 0);
        profileTable.setValueAt("CONTACT", 2, 0);
        profileTable.setValueAt("ISSUED BOOKS", 3, 0);
        profileTable.setValueAt("FINE", 4, 0);

        profileTable.setBackground(new Color(0, 0, 0, 0));
        profileTable.setForeground(Color.white);
        profileTable.setEnabled(false);
        profileTable.setRowHeight(30);
        // adding to profile panekl
        profile_panel.add(profileTable);

        // adding component
        Runner.studentPanel.add(profile_panel);
    }

    public static void createFrame() {
        createProfilePanel();
        createSearchPanel();
        createReturnPanel();
        createSlidingPanel();
        createHistoryPanel();
        Runner.frame.add(Runner.studentPanel);
        Runner.frame.setVisible(false);

        actionsHover();
        actionsClicked();
        actionsTextFields();
    }

    // Hover actions
    private static void actionsHover() {
        // sliding button actions
        sliding_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
            }
        });

        // sliding panel actions
        sliding_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
            }
        });

        // Side panel button hover actios
        // Home button
        profile_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                profile_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_profile) profile_button.setForeground(Color.yellow);
                else profile_button.setForeground(Color.white);
            }
        });

        // history button
        history_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                history_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_history) history_button.setForeground(Color.yellow);
                else history_button.setForeground(Color.white);
            }
        });

        // profile button
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                search_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_search) search_button.setForeground(Color.yellow);
                else search_button.setForeground(Color.white);
            }
        });

        // ask button
        return_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                return_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_return) return_button.setForeground(Color.yellow);
                else return_button.setForeground(Color.white);
            }
        });

        // report button

        logout_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                logout_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                logout_button.setForeground(Color.white);
            }
        });
    }

    // Click actions
    private static void actionsClicked() {
        // Home button
        profile_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                profileTable.setValueAt(Runner.student.getName(), 0, 1);
                profileTable.setValueAt(Runner.student.getRegistrationNumber(), 1, 1);
                profileTable.setValueAt(Runner.student.getContact(), 2, 1);
                profileTable.setValueAt(Runner.student.getNoOfIssuedBooks(), 3, 1);
                profileTable.setValueAt(Runner.student.getFine(), 4, 1);


                page_profile = true;
                page_search = false;
                page_return = false;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // search Button
        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_profile = false;
                page_search = true;
                page_return = false;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // profile Button
        return_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.clear();
                return_list.clearSelection();

                // Jlist for issued books
                for (int i = 0; i < Runner.student.getIssuedBooks().size(); i++) {
                    if (Runner.student.getIssuedBooks().get(i) != null) {
                        model.add(i, Runner.student.getIssuedBooks().get(i).getName());
                    }
                }

                page_profile = false;
                page_search = false;
                page_return = true;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // ask Button
        history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                historyarea.setText(null);
                historyarea.append(filingText.getText(Runner.student.username));

                page_profile = false;
                page_search = false;
                page_return = false;
                page_history = true;
                page_logout = false;
                pageReseter();
            }
        });

        // logout Button
        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.studentPanel.setVisible(false);
                Runner.main_panel.setVisible(true);
            }
        });

        // search button in search panel
        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilingLibrary library = new FilingLibrary();
                ArrayList<Book> books = library.readAll();

                boolean found = false;

                for (int i = 0; i < books.size(); i++) {
                    if (bookTextField.getText().equals(books.get(i).getName())) {

                        Book book = books.get(i);

                        Runner.student.addBook(book);
                        books.remove(book);

                        FilingStudent filingStudent = new FilingStudent();
                        ArrayList<Student> students = filingStudent.readAll();
                        for (int j = 0; j < students.size(); j++) {
                            if (Runner.student.getUsername().equals(students.get(j).getUsername())) {
                                students.add(j, Runner.student);
                                break;
                            }
                        }

                        filingStudent.writeAll(students);
                        library.writeAll(books);

                        // Adding History ==============================================================================
                        filingText.addText(Runner.student.getUsername()+"[Student] issued : "+book.getName()+" , "+book.getAuthorName()+" , "+book.getEdition(),"AdminHistory");
                        filingText.addText("Issued : "+book.getName()+" , "+book.getAuthorName()+" , "+book.getEdition(),Runner.student.username);
                        // =============================================================================================


                        JOptionPane.showMessageDialog(null, "Issued");

                        found = true;

                        break;
                    }
                }

                if (!found) JOptionPane.showMessageDialog(null, "Book not found");

                bookTextField.setText("");
            }
        });

        // return button in return panel
        returnBook_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // getting selected item
                String selected = null;

                try {
                    selected = return_list.getSelectedValue().toString();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please select a book from list", "Error", JOptionPane.WARNING_MESSAGE);
                }

                // returning selected item
                FilingStudent filingStudent = new FilingStudent();
                ArrayList<Student> students = filingStudent.readAll();

                FilingLibrary filingLibrary = new FilingLibrary();
                ArrayList<Book> books = filingLibrary.readAll();

                if (selected != null) {

                    // Removing book from student
                    for (int i = 0; i < Runner.student.getIssuedBooks().size(); i++) {
                        if (Runner.student.getIssuedBooks().get(i).getName().equals(selected)) {
                            Book book = Runner.student.getIssuedBooks().get(i);
                            Runner.student.removeBook(book);
                            books.add(book);
                            filingStudent.update(Runner.student);
                            filingLibrary.writeAll(books);

                            // Adding History ==============================================================================
                            filingText.addText(Runner.student.getUsername()+"[Student] returned : "+book.getName()+" , "+book.getAuthorName()+" , "+book.getEdition(),"AdminHistory");
                            filingText.addText("Returned : "+book.getName()+" , "+book.getAuthorName()+" , "+book.getEdition(),Runner.student.username);
                            // =============================================================================================

                            break;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Done");
                }
            }
        });
    }

    // Textfield actions
    private static void actionsTextFields() {
        bookTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (check.isInteger(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
    }

    // Color hover reseter
    private static void pageReseter() {
        if (page_profile) {
            history_button.setForeground(Color.white);
            search_button.setForeground(Color.white);
            return_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(true);
            history_panel.setVisible(false);
            search_panel.setVisible(false);
            return_panel.setVisible(false);
        } else if (page_search) {
            profile_button.setForeground(Color.white);
            return_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            search_panel.setVisible(true);
            return_panel.setVisible(false);
            history_panel.setVisible(false);

        } else if (page_return) {
            profile_button.setForeground(Color.white);
            search_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            search_panel.setVisible(false);
            return_panel.setVisible(true);
            history_panel.setVisible(false);
        } else if (page_history) {
            profile_button.setForeground(Color.white);
            sliding_button.setForeground(Color.white);
            return_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            search_panel.setVisible(false);
            return_panel.setVisible(false);
            history_panel.setVisible(true);
        } else if (page_logout) {
            profile_button.setForeground(Color.white);
            search_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            return_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            search_panel.setVisible(false);
            return_panel.setVisible(false);
            history_panel.setVisible(false);
        }
    }
}
