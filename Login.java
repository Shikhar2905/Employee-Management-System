
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername,tfpassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,100,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("PASSWORD");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150,70,100,30);
        add(tfpassword);
        
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        loginButton.setBounds(150,150, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or pasword");
            }
        }catch(Exception e){      
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
