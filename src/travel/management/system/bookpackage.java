package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class bookpackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labeltotalprice;
    JButton checkprice,bookpackage,back;
    
    bookpackage(String username){
        this.username= username;
       
        setBounds(350,200,850,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(50,10,200,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,14));
        labelusername.setBounds(220,70,100,20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblpackage.setBounds(40,110,100,20);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(220,110,150,20);
        add(cpackage);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblperson.setBounds(40,150,150,20);
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(220,150,150,20);
        add(tfpersons);
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblid.setBounds(40,190,150,20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(220,190,150,20);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblnumber.setBounds(40,230,150,20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,230,150,20);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblphone.setBounds(40,270,150,20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220,270,150,20);
        add(labelphone);
        
        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setFont(new Font("Tahoma",Font.PLAIN,14));
        lbltotalprice.setBounds(40,310,150,20);
        add(lbltotalprice);
        
        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(220,310,150,20);
        add(labeltotalprice);
        
        try{
            conn c= new conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel (i3);
        i4.setBounds(400,50,500,300);
        add(i4);
        
        add(back);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost+=12000;
            } else if(pack.equals("Silver Package")){
                cost+=8000;
            } else {
                cost+=5500;
            }
            
            int person = Integer.parseInt(tfpersons.getText());
            cost*=person;
            labeltotalprice.setText("Rs "+ cost);
        } else if(ae.getSource()== bookpackage){
            
            try{
                conn c= new conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotalprice.getText()+"')");
                
                
                JOptionPane.showMessageDialog(null,"Package Booked Successfullly");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void  main(String[] args){
        
        new bookpackage("mahi");
    }
    
}
