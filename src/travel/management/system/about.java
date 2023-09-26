package travel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class about extends JFrame implements ActionListener {
    about(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel ("ABOUT");
        text.setBounds(200,10,100,40);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        String s = "About project \nThis project Travel management System";
        
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200,420,80,40);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    
    public static void main(String[] args){
        new about();
    }
}
