package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class checkpackage extends JFrame {
    
    checkpackage(){
        
        setBounds(400,150,700,500);
        
        String[] package1 = {"GOLD Package","-> 6 days and 7 nights","-> Airport Assistance","-> Half day City Tour","-> Daily Buffet","-> Welcome Drinks on Arrival","-> Full Day 3 Island Cruise","-> English Speaking Guide","Summer Special Price","Rs:12000","package1.jpg"};
        String[] package2 = {"SILVER Package","3 days and 4 nights","-> Airport Assistance","-> Daily Buffet","-> Welcome Drinks on Arrival","->Tickets half rate",null,null,"Summer Special Price","Rs:8000"};
        String[] package3 = {"BRONZE Package","1 day and 2 nights","->Return airfare","-> Welcome Drinks on Arrival","->Horse riding",null,null,null,"Summer Special Price","Rs:5500"};
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createpackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createpackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createpackage(package3);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        setVisible(true);
        
    }
    
    public JPanel createpackage(String[] pack){
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]); 
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.yellow);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]); 
        l2.setBounds(50,60,300,30);
        l2.setForeground(new Color(0,0,102));
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]); 
        l3.setBounds(50,90,300,30);
        l3.setForeground(new Color(0,0,102));
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]); 
        l4.setBounds(50,120,300,30);
        l4.setForeground(new Color(0,0,102));
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]); 
        l5.setBounds(50,150,300,30);
        l5.setForeground(new Color(0,0,102));
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]); 
        l6.setBounds(50,180,300,30);
        l6.setForeground(new Color(0,0,102));
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]); 
        l7.setBounds(50,210,300,30);
        l7.setForeground(new Color(0,0,102));
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]); 
        l8.setBounds(50,240,300,30);
        l8.setForeground(new Color(0,0,102));
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]); 
        l9.setBounds(100,300,300,50);
        l9.setForeground(Color.magenta);
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]); 
        l10.setBounds(400,300,300,50);
        l10.setForeground(Color.blue);
        l10.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l10);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel (i3);
        i4.setBounds(250,20,500,300);
        p1.add(i4);
        
        
        return p1;
    }
    
    public static void main(String[] args){
        new checkpackage();
    }
    
}


