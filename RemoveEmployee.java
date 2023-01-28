
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class RemoveEmployee extends JFrame implements ActionListener{
    
    JLabel lblname , lblphone,  lblemail ;
    Choice cempId;
    JButton remove , back;
    
    RemoveEmployee(){
        
        JLabel labelemployee_id = new JLabel("Employee id");                // Employee id
        labelemployee_id.setBounds(50,50,150,30);
        add(labelemployee_id);
 
        cempId = new Choice();
        cempId.setBounds(250,50,150,30);
        add(cempId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while( rs.next() ){
                cempId.add(rs.getString("employee_id"));
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        JLabel labelname = new JLabel("Name");                              //Name
        labelname.setBounds(50,110,150,30);
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(250,110,150,30);
        add(lblname);
        
        
        JLabel labelphone= new JLabel("Phone");                             //Phone
        labelphone.setBounds(50,170,150,30);
        add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(250,170,150,30);
        add(lblphone);
        
        
        JLabel labelemail = new JLabel("Email");                            //Email
        labelemail.setBounds(50,230,150,30);
        add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(250,230,150,30);
        add(lblemail);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where employee_id='"+cempId.getSelectedItem()+"' " ;
            ResultSet rs = c.s.executeQuery(query);
            while( rs.next() ){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        cempId.addItemListener((ItemEvent ie) -> {
            try {
                Conn c = new Conn();
                String query = "select * from employee where employee_id='"+cempId.getSelectedItem()+"' ";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    lblname.setText(rs.getString("name"));
                    lblphone.setText(rs.getString("phone"));
                    lblemail.setText(rs.getString("email"));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        
        remove = new JButton("Remove details");                                                    // remove BUTTON 
        remove.setBounds(50,290,150,30);
        remove.addActionListener(this);
        add(remove);
        
        
        back = new JButton("Back");                                                    //  BUTTON - back
        back.setBounds(250,290,150,30);
        back.addActionListener(this);
        add(back);
        
         
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==remove){
            
            try {
                Conn c = new Conn();
                String query = "delete from employee where employee_id='"+cempId.getSelectedItem()+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Succesfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Home();
        }
            
        
                
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }

    
}
