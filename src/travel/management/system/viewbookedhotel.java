package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class viewbookedhotel extends JFrame implements ActionListener{
    JButton back;
    viewbookedhotel(String username){
        
        setBounds(400,150,1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(30,10,400,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblhotelname = new JLabel("Hotel name");
        lblhotelname.setBounds(30,90,150,25);
        add(lblhotelname);
        
        JLabel labelhotelname = new JLabel();
        labelhotelname.setBounds(220,90,150,25);
        add(labelhotelname);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30,130,150,25);
        add(lblperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
        JLabel lbldays = new JLabel("Total days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,290,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Total price");
        lblprice.setBounds(30,410,150,25);
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);
       
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(150,460,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,500,380);
        add(image);
     
        try{
            conn c= new conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotelname.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelperson.setText(rs.getString("person"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
            }
            
        } catch (Exception e){
        }

        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }


public static void main(String[] args){

     new viewbookedhotel("mahi");
    }
}


