
package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadhar ;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblemployeeid;
    JButton add,back;
    
    AddEmployee(){
        
        JLabel heading = new JLabel("Add Information");                                   // heading
        heading.setBounds(350, 30, 200, 50);
        heading.setFont(new Font("sant_serif",Font.BOLD,25));
        add(heading);
                     
        
        JLabel labelname = new JLabel("Name");                                            //  name
        labelname.setBounds(100,100,150,30);
        labelname.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(270,100,150,30);
        add(tfname);
        
        
        JLabel labelfname = new JLabel("Father's Name");                                  // father's name
        labelfname.setBounds(460,100,150,30);
        labelfname.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(630,100,150,30);
        add(tffname);
        
        
        JLabel labeldob = new JLabel("Date of Birth");                                  // date of birth
        labeldob.setBounds(100,150,150,30);
        labeldob.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(270,150,150,30);
        add(dcdob);
        
        
        JLabel labelsalary = new JLabel("Salary");                                  // salary
        labelsalary.setBounds(460,150,150,30);
        labelsalary.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(630,150,150,30);
        add(tfsalary);
                
        
        JLabel labeladdress = new JLabel("Address");                                            //  address
        labeladdress.setBounds(100,200,150,30);
        labeladdress.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(270,200,150,30);
        add(tfaddress);
        
        
        JLabel labelphone = new JLabel("Phone Number");                                  // phone
        labelphone.setBounds(460,200,150,30);
        labelphone.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(630,200,150,30);
        add(tfphone);
        
        
        JLabel labelemail = new JLabel("Email");                                            //  email
        labelemail.setBounds(100,250,150,30);
        labelemail.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(270,250,150,30);
        add(tfemail);
        
        
        JLabel labeleducation = new JLabel("Highest education");                                  // highest education
        labeleducation.setBounds(460,250,150,30);
        labeleducation.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labeleducation);
        
        String courses[] = { "BBA","BCA","BSC","MCA","MBA" };
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(630,250,150,30);
        add(cbeducation);
        
        
        JLabel labeldesignation = new JLabel("Designation");                                            //  designation
        labeldesignation.setBounds(100,300,150,30);
        labeldesignation.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(270,300,150,30);
        add(tfdesignation);
        
        
        JLabel labelaadhar = new JLabel("Aadhar Number");                                  // aadhar
        labelaadhar.setBounds(460,300,150,30);
        labelaadhar.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(630,300,150,30);
        add(tfaadhar);
        
        
        JLabel labelemployeeid = new JLabel("Employee id");                                            //  employee id
        labelemployeeid.setBounds(100,350,150,30);
        labelemployeeid.setFont(new Font("sant_serif",Font.PLAIN,20));
        add(labelemployeeid);
        
        lblemployeeid = new JLabel(""+number);
        lblemployeeid.setBounds(270,350,150,30);
        add(lblemployeeid);
        
        
        add = new JButton("Add details");                                                    // ADD BUTTON - add infornation
        add.setBounds(250,450,100,50);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("Back");                                                    // ADD BUTTON - back
        back.setBounds(600,450,100,50);
        back.addActionListener(this);
        add(back);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900,700);
        setLocation(300,75);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String employeeid = lblemployeeid.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into employee values( '"+name+"' , '"+fname+"' , '"+dob+"' , '"+salary+"' , '"+address+"' , '"+phone+"' , '"+email+"' , '"+education+"' , '"+designation+"' , '"+aadhar+"' , '"+employeeid+"'   )";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Executed Successfully");
                setVisible(false);
                new Home();
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Home();
        }    
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
    
}
