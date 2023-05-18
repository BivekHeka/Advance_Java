package EventListener;
import javax.swing.*;
import java.awt.event.*;

public class ActionListen extends JFrame implements ActionListener 
{
 JTextField tf;
 ActionListen(){
    tf=new JTextField();
    tf.setBounds(60,50,170,20);
    JButton b=new JButton("click me");
    b.setBounds(100,120,80,30);
    b.addActionListener(this);
    add(b);
    add(tf);
    setSize(300,300);
    setLayout(null);
    setVisible(true);
 }   
 public void actionPerformed(ActionEvent e){
    tf.setText("welcome");
 }
 public static void main(String[] args) {
    new ActionListen();
 }
}
