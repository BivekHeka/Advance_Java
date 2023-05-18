package Login_Swing;

import javax.swing.*;



import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Login implements ActionListener {
    JTextField tfUser, tfPassword;
    JFrame f = new JFrame("Login");

    public Login() {
        JLabel lUser = new JLabel("Username");
        lUser.setBounds(20, 20, 150, 25);
        f.add(lUser);

        tfUser = new JTextField();
        tfUser.setBounds(180, 20, 150, 25);
        f.add(tfUser);

        JLabel lPassword = new JLabel("Password");
        // lPassword.setText("Password");
        lPassword.setBounds(20, 55, 150, 25);
        f.add(lPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(180, 55, 150, 25);
        f.add(tfPassword);

        JButton login = new JButton();
        login.setText("Login ");
        login.setBounds(180, 90, 150, 25);
        login.addActionListener(this);
        f.add(login);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = tfUser.getText();
        String password = tfPassword.getText();
        // System.out.println(user + password);
        // if (user.equals("admin") && password.equals("admin")) {
        //     JDialog d = new JDialog(f, "Login Success", true);

        //     d.setLocationRelativeTo(d);
        //     d.setSize(200, 100);
        //     d.setVisible(true);
        // }

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","")){
            // Class.forName("com.mysql.jdbc.driver");
            
            Statement set=  con.createStatement();
            ResultSet rs=set.executeQuery("select * from User where username='"+user+"' and password='"+password+"'");
            
            while(rs.next()){
                if (user.equals(rs.getString("username"))&& password.equals(rs.getString("password"))){
                    JDialog dialog = new JDialog(f,"Authenticated",true);
                    dialog.setLocationRelativeTo(dialog);
                    dialog.setSize(100,100);
                    dialog.setVisible(true);
                }
            }
        }
        catch(Exception se){
            System.out.println(se.getMessage());
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}