import java.awt.*;
import java.awt.event.*;

public class MultiplicationTable_24RP00257 extends Frame implements ActionListener {
    private TextField numberField;
    private Button displayButton;
    private TextArea outputArea;

    public MultiplicationTable_24RP00257() {
        setTitle("AWT Practice");
        setSize(400, 300);
        setLayout(null);

        numberField = new TextField();
        numberField.setBounds(20, 50, 200, 25);
        add(numberField);

        displayButton = new Button("Display");
        displayButton.setBounds(20, 90, 80, 25);
        add(displayButton);

        outputArea = new TextArea();
        outputArea.setBounds(260, 40, 200, 200);
        outputArea.setEditable(false);
        add(outputArea);

        numberField.addActionListener(this);
        displayButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String input = numberField.getText().trim();
        if (input.equals("")) {
            showMessage("Please enter a number.");
            return;
        }

        try {
            int num = Integer.parseInt(input);
            String result = "";
            for (int i = 1; i <= 10; i++) {
                result += num + " * " + i + " = " + (num * i) + "\n";
            }
            outputArea.setText(result);
        } catch (NumberFormatException ex) {
            showMessage("Invalid input. Enter an integer number.");
            outputArea.setText("");
        }
    }

    private void showMessage(String msg) {
        final Dialog d = new Dialog(this, "Message", true);
        d.setLayout(new BorderLayout());
        Label l = new Label(msg, Label.CENTER);
        d.add(l, BorderLayout.CENTER);
        Panel p = new Panel();
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                d.dispose();
            }
        });
        p.add(ok);
        d.add(p, BorderLayout.SOUTH);
        d.setSize(300, 120);
        d.setLocation(getX() + 150, getY() + 80);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        MultiplicationTable_24RP00257 app = new MultiplicationTable_24RP00257();
        app.setVisible(true);
    }
}
