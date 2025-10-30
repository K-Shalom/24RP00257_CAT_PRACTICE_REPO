import java.awt.*;
import java.awt.event.*;

public class Pagemenu_24RP00257 extends Frame {
    private Panel loginPanel;
    private Panel studentPanel;
    private TextField loginUsernameField;
    private TextField loginPasswordField;
    private final String CORRECT_USERNAME = "shalom";
    private final String CORRECT_PASSWORD = "12345";
    
    public Pagemenu_24RP00257() {
        setTitle("AWT MENU Practice");
        setSize(600, 400);
        setLayout(new CardLayout());
        MenuBar menuBar = new MenuBar();
        Menu pagesMenu = new Menu("Pages");
        MenuItem loginItem = new MenuItem("login");
        MenuItem studentItem = new MenuItem("student");
        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);
        menuBar.add(pagesMenu);     
        setMenuBar(menuBar);
        createLoginPanel();
        createStudentPanel();
        add("login", loginPanel);
        add("student", studentPanel);
        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)getLayout()).show(Pagemenu_24RP00257.this, "login");
            }
        });
        studentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)getLayout()).show(Pagemenu_24RP00257.this, "student");
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
    
    private void createLoginPanel() {
        loginPanel = new Panel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.LIGHT_GRAY);
        Label titleLabel = new Label("SIMPLE JAVA AWT LAYOUT");
        titleLabel.setBounds(200, 50, 300, 30);


    Label loginLabel = new Label("LOGIN PAGE");
    loginLabel.setBounds(250, 100, 100, 20);
        
    Label usernameLabel = new Label("Username");
    usernameLabel.setBounds(150, 150, 100, 20);
        
    loginUsernameField = new TextField();
    loginUsernameField.setBounds(250, 150, 150, 25);
        
    Label passwordLabel = new Label("Password");
    passwordLabel.setBounds(150, 190, 100, 20);
        
    loginPasswordField = new TextField();
    loginPasswordField.setEchoChar('*');
    loginPasswordField.setBounds(250, 190, 150, 25);
        
    Button loginButton = new Button("LOGIN");
    loginButton.setBounds(250, 230, 100, 30);
    loginButton.setBackground(Color.DARK_GRAY);
    loginButton.setForeground(Color.WHITE);
        loginPanel.add(titleLabel);
        loginPanel.add(loginLabel);
        loginPanel.add(usernameLabel);
        loginPanel.add(loginUsernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(loginPasswordField);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
    }
    
    private void createStudentPanel() {
        studentPanel = new Panel();
        studentPanel.setBackground(Color.WHITE);
        Label studentInfo = new Label("Student Name: Shalom KUBWIMBABAZI  Reg No: 24RP00257");
        studentPanel.add(studentInfo);
    }

    private void validateLogin() {
        String user = loginUsernameField.getText().trim();
        String pass = loginPasswordField.getText().trim();
        if (user.equals(CORRECT_USERNAME) && pass.equals(CORRECT_PASSWORD)) {
            showDialog("Welcome", "Welcome " + user + "!");
        } else {
            showDialog("Login Failed", "Invalid username or password. Please try again.");
        }
    }

    private void showDialog(String title, String message) {
        final Dialog dlg = new Dialog(this, title, true);
        dlg.setLayout(new BorderLayout());
        Label msg = new Label(message, Label.CENTER);
        dlg.add(msg, BorderLayout.CENTER);
        Panel p = new Panel();
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dlg.setVisible(false);
                dlg.dispose();
            }
        });
        p.add(ok);
        dlg.add(p, BorderLayout.SOUTH);
        dlg.setSize(320, 120);
        dlg.setLocation(getX() + 100, getY() + 80);
        dlg.setVisible(true);
    }
    
    public static void main(String[] args) {
        Pagemenu_24RP00257 frame = new Pagemenu_24RP00257();
        frame.setVisible(true);
    }
}