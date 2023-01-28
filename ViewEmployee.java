
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewEmployee extends JFrame implements ActionListener{
   
    JTable table;
    JButton search,print,update,back;
    Choice cemployeeid;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelsearch = new JLabel("Search by Employee id");
        labelsearch.setBounds(20,20,150,20);
        add(labelsearch);
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(200,20,150,20);
        add(cemployeeid);
        
        search = new JButton("Search");
        search.setBounds(20,60,150,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(190,60,150,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(360,60,150,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(530,60,150,20);
        back.addActionListener(this);
        add(back);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");           
            while(rs.next()){
                cemployeeid.add(rs.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));                    
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
       
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
 
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){                        
            String query = ("select * from employee where employee_id='"+cemployeeid.getSelectedItem()+"' ");
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==print){
            try {
                table.print();
            } catch (PrinterException ex) {
                Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem() );
        
        }else if (ae.getSource()==back){
            setVisible(false);
            new Home();
        }    
    }
    
    public static void main(String args[]){
        new ViewEmployee();
    }

    
}
