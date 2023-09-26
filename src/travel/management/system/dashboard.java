package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class dashboard extends JFrame implements ActionListener{
    String username;
    JButton addpersonaldetails,about,calculator,notepad,payments,viewbookedhotels,destination,viewpersonaldetails,bookhotels,updatepersonaldetails,checkpackage,bookpackage,viewpackage,viewhotels;
    dashboard(String username){
         this.username = username;
         
         setExtendedState(JFrame.MAXIMIZED_BOTH); // to maximize frame when we don't know screen size
         setLayout(null);

         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBackground(new Color(0,0,102));
         p1.setBounds(0,0,1600,65);
         add(p1);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
         Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel icon = new JLabel(i3);
         icon.setBounds(5,0,70,70);
         p1.add(icon);
         
         JLabel heading = new JLabel ("DASHBOARD");
         heading.setBounds(80,10,300,40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Tahoma",Font.BOLD,30));
         p1.add(heading);
         
         JPanel p2 = new JPanel();
         p2.setBounds(0,65,300,900);
         p2.setBackground(new Color(0,0,102));
         add(p2);
         
         addpersonaldetails = new JButton("Add personal details");
         addpersonaldetails.setBounds(0, 0, 300, 50);
         addpersonaldetails.setBackground(new Color(51,153,255));
         addpersonaldetails.setForeground(Color.BLACK);
         addpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
         addpersonaldetails.setMargin(new Insets(0,0,0,60));
         addpersonaldetails.addActionListener(this);
         p2.add(addpersonaldetails);
         
         updatepersonaldetails = new JButton("Update personal details");
         updatepersonaldetails.setBounds(0, 0, 300, 50);
         updatepersonaldetails.setBackground(new Color(51,153,255));
         updatepersonaldetails.setForeground(Color.BLACK);
         updatepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
         updatepersonaldetails.setMargin(new Insets(0,0,0,33));
         updatepersonaldetails.addActionListener(this);
         p2.add(updatepersonaldetails);
         
         viewpersonaldetails = new JButton ("View details");
         viewpersonaldetails.setBounds(0,130,300,50);
         viewpersonaldetails.setBackground(new Color(51,153,255));
         viewpersonaldetails.setForeground(Color.black);
         viewpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewpersonaldetails.setMargin(new Insets(0,0,0,130));
         viewpersonaldetails.addActionListener(this);
         p2.add(viewpersonaldetails);
         
         JButton deletepersonaldetails = new JButton ("Delete personal details");
         deletepersonaldetails.setBounds(0,210,300,50);
         deletepersonaldetails.setBackground(new Color(51,153,255));
         deletepersonaldetails.setForeground(Color.black);
         deletepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
         deletepersonaldetails.setMargin(new Insets(0,0,0,40));
         p2.add(deletepersonaldetails);
         
         checkpackage = new JButton ("Check package");
         checkpackage.setBounds(0,290,300,50);
         checkpackage.setBackground(new Color(51,153,255));
         checkpackage.setForeground(Color.black);
         checkpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
         checkpackage.setMargin(new Insets(0,0,0,115));
         checkpackage.addActionListener(this);
         p2.add(checkpackage);
         
         bookpackage = new JButton ("Book package");
         bookpackage.setBounds(0,370,300,50);
         bookpackage.setBackground(new Color(51,153,255));
         bookpackage.setForeground(Color.black);
         bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
         bookpackage.setMargin(new Insets(0,0,0,125));
         bookpackage.addActionListener(this);
         p2.add(bookpackage);
         
         viewpackage = new JButton ("View Package");
         viewpackage.setBounds(0,450,300,50);
         viewpackage.setBackground(new Color(51,153,255));
         viewpackage.setForeground(Color.black);
         viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewpackage.setMargin(new Insets(0,0,0,130));
         viewpackage.addActionListener(this);
         p2.add(viewpackage);
         
         viewhotels = new JButton ("View Hotels");
         viewhotels.setBounds(0,450,300,50);
         viewhotels.setBackground(new Color(51,153,255));
         viewhotels.setForeground(Color.black);
         viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewhotels.setMargin(new Insets(0,0,0,145));
         viewhotels.addActionListener(this);
         p2.add(viewhotels);
         
         bookhotels = new JButton ("Book Hotels");
         bookhotels.setBounds(0,450,300,50);
         bookhotels.setBackground(new Color(51,153,255));
         bookhotels.setForeground(Color.black);
         bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
         bookhotels.setMargin(new Insets(0,0,0,140));
         bookhotels.addActionListener(this);
         p2.add(bookhotels);
         
         viewbookedhotels = new JButton ("View Booked Hotels");
         viewbookedhotels.setBounds(0,450,300,50);
         viewbookedhotels.setBackground(new Color(51,153,255));
         viewbookedhotels.setForeground(Color.black);
         viewbookedhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
         viewbookedhotels.setMargin(new Insets(0,0,0,70));
         viewbookedhotels.addActionListener(this);
         p2.add(viewbookedhotels);
         
         destination = new JButton ("Destination");
         destination.setBounds(0,530,300,50);
         destination.setBackground(new Color(51,153,255));
         destination.setForeground(Color.black);
         destination.setFont(new Font("Tahoma",Font.PLAIN,20));
         destination.setMargin(new Insets(0,0,0,150));
         destination.addActionListener(this);
         p2.add(destination);
         
         payments = new JButton ("Payments");
         payments.setBounds(0,610,300,50);
         payments.setBackground(new Color(51,153,255));
         payments.setForeground(Color.black);
         payments.setFont(new Font("Tahoma",Font.PLAIN,20));
         payments.setMargin(new Insets(0,0,0,160));
         payments.addActionListener(this);
         p2.add(payments);
         
         calculator = new JButton ("Calculator");
         calculator.setBounds(0,690,300,50);
         calculator.setBackground(new Color(51,153,255));
         calculator.setForeground(Color.black);
         calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
         calculator.setMargin(new Insets(0,0,0,160));
         calculator.addActionListener(this);
         p2.add(calculator);
         
         notepad = new JButton ("NotePad");
         notepad.setBounds(0,770,300,50);
         notepad.setBackground(new Color(51,153,255));
         notepad.setForeground(Color.black);
         notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
         notepad.setMargin(new Insets(0,0,0,175));
         notepad.addActionListener(this);
         p2.add(notepad);
         
         about = new JButton ("About");
         about.setBounds(0,830,300,50);
         about.setBackground(new Color(51,153,255));
         about.setForeground(Color.black);
         about.setFont(new Font("Tahoma",Font.PLAIN,20));
         about.setMargin(new Insets(0,0,0,195));
         about.addActionListener(this);
         p2.add(about);
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         JLabel image = new JLabel(i6);
         image.setBounds(0,0,1650,1000);
         add(image);
         
         JLabel text = new JLabel("Travel Management System ");
         text.setBounds(400,70,1200,70);
         text.setForeground(Color.white);
         text.setFont(new Font("Raleway",Font.BOLD,55));
         image.add(text);
         

         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonaldetails){
            new addcustomer(username);
        } else if (ae.getSource()== viewpersonaldetails){
            new viewcustomer(username);
        } else if(ae.getSource()==updatepersonaldetails){
            new updatecustomer(username);
        } else if (ae.getSource()==checkpackage){
            new checkpackage();
        } else if(ae.getSource()==bookpackage){
            new bookpackage(username);
        } else if(ae.getSource()== viewpackage){
            new viewpackage(username);
        } else if(ae.getSource()==viewhotels){
            new viewhotels();
        } else if(ae.getSource()==destination){
            new destination();
        } else if(ae.getSource()==bookhotels){
            new bookhotel(username);
        } else if(ae.getSource()==viewbookedhotels){
            new viewbookedhotel(username);
        } else if (ae.getSource() == payments){
            new payment();
        } else if (ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){
                e.printStackTrace();
                                 }     
        } else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){
                e.printStackTrace();
                                 } 
            
        } else if(ae.getSource()==about){
            new about();
        }
    }
    
    public static void main(String[] args){
        new dashboard("");
    }
    
}

    
