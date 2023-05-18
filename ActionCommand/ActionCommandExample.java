package ActionCommand;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
public class ActionCommandExample extends MouseMotionAdapter {
    Frame f;
    JButton b;
    JButton b2;
    ActionCommandExample(){
        f= new Frame("mouse motion adapter");
        f.addMouseMotionListener(this);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);

        b= new JButton();
        b.setText("login");
        b.setActionCommand("loginBtn");
        b.setBounds(180,90,150,25);
        f.add(b);

        b2= new JButton();
        b2.setText("Register");
        b2.setActionCommand("registerBtn");
        b2.setBounds(180,120,150,25);
        f.add(b2);

        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        if(cmd=="loginBtn"){
            System.out.println("login Btn Pressed");
        }
    }
    public static void main(String[] args) {
        new ActionCommandExample();
    }
}
