import java.awt.*;
import java.awt.event.*;

public class MyShapes_24RP00257 extends Frame{
    MyShapes_24RP00257(){
        setTitle("My  shapes");
        setSize(300,300);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        g.fillOval(60,60,100,100);
        g.setColor(Color.black);
        g.drawOval(60,60,100,100);

        g.setColor(Color.black);
        g.fillOval(76,85,20,20);
        g.fillOval(120,85,20,20);

        g.setColor(Color.black);
        g.drawArc(87,100,50,40,0,-190);
    }

    public static void main(String[] args) {
       new MyShapes_24RP00257().setVisible(true);
    }
}
