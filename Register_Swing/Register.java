package Register_Swing;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Register implements ActionListener {
    JTextField tfUser, tfPassword;
    JFrame f;
    JButton JSubmit ;

    public Register() {
        f = new JFrame("Register");
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

        JSubmit = new JButton();
        JSubmit.setText("register ");
        JSubmit.setBounds(180, 90, 150, 25);
        JSubmit.addActionListener(this);
        f.add(JSubmit);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = tfUser.getText();
        String password = tfPassword.getText();

        String dburl="jdbc:mysql://localhost:3306/advancejava";
        String dbusername ="root";
        String dbpassword ="";
        // System.out.println(user + password);
        // if (user.equals("admin") && password.equals("admin")) {
        //     JDialog d = new JDialog(f, "Login Success", true);

        //     d.setLocationRelativeTo(d);
        //     d.setSize(200, 100);
        //     d.setVisible(true);
        // }

        try(Connection con = DriverManager.getConnection(dburl, dbusername, dbpassword)){
            // Class.forName("com.mysql.jdbc.driver");
            String query ="INSERT INTO user(Username,Password) VALUES('"+user+"','"+password+"')";
            Statement stmt=  con.createStatement();
            int res =stmt.executeUpdate(query);
                if (res>0){
                    JDialog dialog = new JDialog(f,"User Creation Success",true);
                    dialog.setLocationRelativeTo(dialog);
                    dialog.setSize(400,100);
                    dialog.setVisible(true);
                }
            
        }
        catch(Exception se){
            System.out.println(se.getMessage());
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
