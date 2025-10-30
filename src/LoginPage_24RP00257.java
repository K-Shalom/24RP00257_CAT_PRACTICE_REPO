import java.awt.*;
import java.awt.event.*;

public class LoginPage_24RP00257 extends Frame {
    private TextField usernameField, passwordField;

    private final String crtUname = "shalom";
    private final String crtUpass = "12345";

    public LoginPage_24RP00257() {
        setTitle("AWT Practice");
        setSize(600, 400);
        setLayout(null);

        Label titleLabel = new Label("SIMPLE JAVA AWT LAYOUT");
        titleLabel.setBounds(150, 50, 300, 30);
        add(titleLabel);

        Label loginLabel = new Label("LOGIN PAGE");
        loginLabel.setBounds(250, 100, 100, 20);
        add(loginLabel);

        Label usernameLabel = new Label("Username");
        usernameLabel.setBounds(150, 150, 100, 20);
        add(usernameLabel);

        usernameField = new TextField();
        usernameField.setBounds(250, 150, 150, 25);
        add(usernameField);

        Label passwordLabel = new Label("Password");
        passwordLabel.setBounds(150, 190, 100, 20);
        add(passwordLabel);

        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(250, 190, 150, 25);
        add(passwordField);

        Button loginButton = new Button("LOGIN");
        loginButton.setBounds(250, 230, 100, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    private void validateLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (user.equals(crtUname) && pass.equals(crtUpass)) {
            showDialog("Login Successful", "Welcome " + user + "!");
            usernameField.setText("");
            passwordField.setText("");
        } else {
            showDialog("Login Failed", "Invalid username or password. Please try again.");
            passwordField.setText("");
        }
    }

    private void showDialog(String title, String message) {
        final Dialog dlg = new Dialog(this, title, true);
        dlg.setLayout(new BorderLayout());
        Label msg = new Label(message);
        msg.setAlignment(Label.CENTER);

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
        dlg.setSize(360, 120);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
    }

    public static void main(String[] args) {
        LoginPage_24RP00257 frame = new LoginPage_24RP00257();
        frame.setVisible(true);
    }
}