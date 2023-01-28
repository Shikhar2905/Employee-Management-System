
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    
    JButton add , view , update , remove;
    
    Home(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpeg"));            // ADD IMAGE
        Image i2 = i1.getImage().getScaledInstance(1120, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 650);
        add(image);
        
        JLabel heading  = new JLabel("Employee Management System");                                     // ADD HEADING
        heading.setBounds(65,20,1120,100);
        heading.setFont(new Font("SERRIF",Font.BOLD,25));
        image.add(heading);
        
        add = new JButton("ADD EMPLOYEE");                                                      // ADD BUTTON - add
        add.setBounds(50,140,200,50);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("VIEW EMPLOYEE");                                                    // ADD BUTTON - view
        view.setBounds(260,140,200,50);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("UPDATE EMPLOYEE");                                                // ADD BUTTON - update
        update.setBounds(50,210,200,50);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("REMOVE EMPLOYEE");                                                // ADD BUTTON - remove
        remove.setBounds(260,210,200,50);
        remove.addActionListener(this);
        image.add(remove);
        
        setLayout(null);
        setBounds(200,100,1120,650);
        setSize(1120, 650);
        setVisible(true);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();    
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]){
        new Home();
    }
    
    
}
