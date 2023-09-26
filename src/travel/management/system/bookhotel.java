package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class bookhotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labeltotalprice;
    JButton checkprice,bookpackage,back;
    
    bookhotel(String username){
        this.username= username;
       
        setBounds(350,150,1000,650);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblpackage.setBounds(40,110,100,20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(220,110,150,20);
        add(chotel);
        
        try{
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
            
        } catch(Exception e){
                e.printStackTrace();
            }
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblperson.setBounds(40,150,150,20);
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,150,20);
        add(tfperson);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,14));
        lbldays.setBounds(40,190,150,20);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(220,190,150,20);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblac.setBounds(40,230,150,20);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(220,230,150,20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblfood.setBounds(40,270,150,20);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(220,270,150,20);
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblid.setBounds(40,310,150,20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(220,310,150,20);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblnumber.setBounds(40,350,150,20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,350,150,20);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220,390,150,20);
        add(labelphone);
        
        
        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setFont(new Font("Tahoma",Font.PLAIN,14));
        lbltotalprice.setBounds(40,430,150,20);
        add(lbltotalprice);
        
        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(220,430,150,20);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel (i3);
        i4.setBounds(450,50,500,300);
        add(i4);
        
        add(back);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()==checkprice){
            try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int person = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                
                if(person*days>0){
                    int total =0;
                    total += acselected.equals("AC")? ac:0;
                    total+=foodselected.equals("Yes")? food :0;
                    total+=cost;
                    total=total*person*days;
                    labeltotalprice.setText("Rs "+total);
                } else {
                    JOptionPane.showMessageDialog(null,"Please Enter Valid number"); 
                }
            }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource()== bookpackage){
            
            try{
                conn c= new conn();
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotalprice.getText()+"')");
                
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfullly");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    public static void  main(String[] args){
        
        new bookhotel("mahi");
    }
    
}
