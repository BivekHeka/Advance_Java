package Adapter;
import java.awt.*;
import java.awt.event.*;
public class MouseMotionAdapterExample extends MouseMotionAdapter {
    Frame f;
    MouseMotionAdapterExample(){
        f= new Frame("mouse motion adapter");
        f.addMouseMotionListener(this);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new MouseMotionAdapterExample();
    }
}
