import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibrarianPanel {

    // Sliding panel
    private static JPanel sliding_panel = new JPanel();
    private static JPanel sliding_button = new JPanel();

    private static JButton profile_button = new JButton("P R O F I L E");
    private static JButton add_button = new JButton("A D D");
    private static JButton remove_button = new JButton("R E M O V E");
    private static JButton history_button = new JButton("H I S T O R Y");
    private static JButton logout_button = new JButton("L O G O U T");

    // Boolean page clicks
    private static boolean page_profile = true;
    private static boolean page_add = false;
    private static boolean page_remove = false;
    private static boolean page_history = false;
    private static boolean page_logout = false;

    // Profile Panel
    private static JPanel profile_panel = new JPanel();
    private static JTable profileTable = new JTable(2, 2);

    // add Panel
    private static JPanel add_panel = new JPanel();
    private static JLabel book_name = new JLabel("ENTER BOOK NAME");
    private static JLabel author_name = new JLabel("ENTER AUTHOR NAME");
    private static JLabel book_edition = new JLabel("ENTER BOOK EDITION");
    private static JTextField bookTextField = new JTextField(12);
    private static JTextField authorTextField = new JTextField(12);
    private static JTextField editionTextField = new JTextField(12);
    private static JButton addbutton = new JButton("SEARCH");

    // remove pane
    private static JPanel remove_panel = new JPanel();
    private static DefaultListModel model = new DefaultListModel();
    private static JList remove_list = new JList(model);
    private static JScrollPane scrollPane = new JScrollPane(remove_list);
    private static JButton removeBook_button = new JButton("Remove");

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

        add_button.setForeground(Color.white);
        add_button.setFocusPainted(false);
        add_button.setBorderPainted(false);
        add_button.setBackground(new Color(0, 0, 0, 0));
        add_button.setBounds(1, 180, 120, 25);

        remove_button.setForeground(Color.white);
        remove_button.setFocusPainted(false);
        remove_button.setBorderPainted(false);
        remove_button.setBackground(new Color(0, 0, 0, 0));
        remove_button.setBounds(1, 230, 120, 25);

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
        sliding_panel.add(add_button);
        sliding_panel.add(remove_button);
        sliding_panel.add(history_button);
        sliding_panel.add(logout_button);

        // adding components
        Runner.librarianPanel.add(sliding_panel);
        Runner.librarianPanel.add(sliding_button);
    }

    private static void createAddPanel() {
        // panel
        add_panel.setBounds(137, 110, 700, 300);
        add_panel.setBackground(Runner.panel_color);
        add_panel.setLayout(null);
        add_panel.setVisible(false);

        book_name.setBounds(120, 100, 200, 25);
        book_name.setFont(new Font("Calibiri", Font.BOLD, 15));
        book_name.setForeground(Color.WHITE);

        author_name.setBounds(120, 150, 200, 25);
        author_name.setFont(new Font("Calibiri", Font.BOLD, 15));
        author_name.setForeground(Color.WHITE);

        book_edition.setBounds(120, 200, 200, 25);
        book_edition.setFont(new Font("Calibiri", Font.BOLD, 15));
        book_edition.setForeground(Color.WHITE);

        bookTextField.setBounds(300, 100, 150, 25);
        authorTextField.setBounds(300, 150, 150, 25);
        editionTextField.setBounds(300, 200, 150, 25);

        addbutton.setBounds(480, 150, 100, 30);
        addbutton.setForeground(Color.white);
        addbutton.setBackground(Color.black);

        //addingto add PANEL
        add_panel.add(book_name);
        add_panel.add(author_name);
        add_panel.add(book_edition);
        add_panel.add(bookTextField);
        add_panel.add(authorTextField);
        add_panel.add(editionTextField);
        add_panel.add(addbutton);

        // adding components
        Runner.librarianPanel.add(add_panel);
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
        Runner.librarianPanel.add(history_panel);
    }

    private static void createRemovePanel() {
        // panel
        remove_panel.setBounds(137, 110, 700, 300);
        remove_panel.setBackground(Runner.panel_color);
        remove_panel.setLayout(null);
        remove_panel.setVisible(false);

        // Jlist
        String[] strings = new String[]{"ASD", "asjkdas", "wakldnaw"};
        for (int i = 0; i < strings.length; i++) {
            model.add(i, strings[i]);
        }

        scrollPane.setBounds(450, 85, 100, 130);
        scrollPane.setBackground(Color.black);
        scrollPane.setForeground(Color.white);

        // removebook_button
        removeBook_button.setBounds(100, 200, 100, 25);
        removeBook_button.setBackground(Color.black);
        removeBook_button.setForeground(Color.white);
        removeBook_button.setFocusPainted(false);

        //adding to remove panel
        remove_panel.add(scrollPane);
        remove_panel.add(removeBook_button);

        // adding components
        Runner.librarianPanel.add(remove_panel);
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
        profileTable.setValueAt("CONTACT", 1, 0);

        profileTable.setBackground(new Color(0, 0, 0, 0));
        profileTable.setForeground(Color.white);
        profileTable.setEnabled(false);
        profileTable.setRowHeight(30);

        // adding to profile panekl
        profile_panel.add(profileTable);

        // adding component
        Runner.librarianPanel.add(profile_panel);
    }

    public static void createFrame() {
        createProfilePanel();
        createAddPanel();
        createRemovePanel();
        createSlidingPanel();
        createHistoryPanel();
        Runner.frame.add(Runner.librarianPanel);
        Runner.frame.setVisible(false);

        actionsHover();
        actionsClicked();
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
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                add_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_add) add_button.setForeground(Color.yellow);
                else add_button.setForeground(Color.white);
            }
        });

        // ask button
        remove_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sliding_button.setVisible(false);
                sliding_panel.setVisible(true);
                remove_button.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sliding_panel.setVisible(false);
                sliding_button.setVisible(true);
                if (page_remove) remove_button.setForeground(Color.yellow);
                else remove_button.setForeground(Color.white);
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
        // Profile button
        profile_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                profileTable.setValueAt("Hafsah <3", 0, 1);
                profileTable.setValueAt("033333333", 1, 1);

                page_profile = true;
                page_add = false;
                page_remove = false;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // History Button
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page_profile = false;
                page_add = true;
                page_remove = false;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // profile Button
        remove_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.clear();
                remove_list.clearSelection();

                FilingLibrary library = new FilingLibrary();
                ArrayList<Book> books = library.readAll();

                // Jlist for issued books
                for (int i = 0; i < books.size(); i++) {
                    model.add(i, books.get(i).getName());
                }

                page_profile = false;
                page_add = false;
                page_remove = true;
                page_history = false;
                page_logout = false;
                pageReseter();
            }
        });

        // History Button
        history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //writing history
                historyarea.setText("");
                historyarea.append(filingText.getText("AdminHistory"));

                page_profile = false;
                page_add = false;
                page_remove = false;
                page_history = true;
                page_logout = false;
                pageReseter();
            }
        });

        // logout Button
        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.librarianPanel.setVisible(false);
                Runner.main_panel.setVisible(true);
            }
        });

        //add button in add panel
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (book_name.getText().equals("") || author_name.getText().equals("") || editionTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Empty fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = bookTextField.getText();
                    String author = authorTextField.getText();
                    String edition = editionTextField.getText();
                    Book book = new Book(name, author, Integer.parseInt(edition));

                    FilingLibrary filingLibrary = new FilingLibrary();
                    filingLibrary.add(book, "Library.ser");

                    // Done
                    JOptionPane.showMessageDialog(null,"Success");
                    bookTextField.setText("");
                    authorTextField.setText("");
                    editionTextField.setText("");

                    // Writing on history file
                    filingText.addText("Admin added : "+name+" , "+author+" , "+edition,"AdminHistory");
                }
            }
        });

        // remove button in remove panel
        removeBook_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // getting selected item
                String selected = null;

                try {
                    selected = remove_list.getSelectedValue().toString();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please select a book from list", "Error", JOptionPane.WARNING_MESSAGE);
                }

                if (selected != null) {

                    FilingLibrary library = new FilingLibrary();
                    ArrayList<Book> books = library.readAll();

                    for (int i = 0 ; i < books.size() ; i++){
                        if (books.get(i).getName().equals(selected)){

                            // Adding to history
                            filingText.addText("Admin removed : "+books.get(i).getName()+" , "+books.get(i).getAuthorName()+" , "+books.get(i).getEdition(),"AdminHistory");


                            books.remove(i);
                            break;
                        }
                    }

                    library.writeAll(books);

                    //DOne
                    JOptionPane.showMessageDialog(null, "Done");
                }
            }
        });
    }

    // text field actions
    private static void actionsTextFields(){
        // edition field
        editionTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (check.isInteger(e.getKeyChar())){

                }
                else e.consume();
            }
        });
    }

    // Color hover reseter
    private static void pageReseter() {
        if (page_profile) {
            history_button.setForeground(Color.white);
            add_button.setForeground(Color.white);
            remove_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(true);
            history_panel.setVisible(false);
            add_panel.setVisible(false);
            remove_panel.setVisible(false);
        } else if (page_add) {
            profile_button.setForeground(Color.white);
            remove_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            add_panel.setVisible(true);
            remove_panel.setVisible(false);
            history_panel.setVisible(false);

        } else if (page_remove) {
            profile_button.setForeground(Color.white);
            add_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            add_panel.setVisible(false);
            remove_panel.setVisible(true);
            history_panel.setVisible(false);
        } else if (page_history) {
            profile_button.setForeground(Color.white);
            sliding_button.setForeground(Color.white);
            remove_button.setForeground(Color.white);
            logout_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            add_panel.setVisible(false);
            remove_panel.setVisible(false);
            history_panel.setVisible(true);
        } else if (page_logout) {
            profile_button.setForeground(Color.white);
            add_button.setForeground(Color.white);
            history_button.setForeground(Color.white);
            remove_button.setForeground(Color.white);

            profile_panel.setVisible(false);
            add_panel.setVisible(false);
            remove_panel.setVisible(false);
            history_panel.setVisible(false);
        }
    }
}