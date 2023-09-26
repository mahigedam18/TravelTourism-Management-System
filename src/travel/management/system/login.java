package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JButton login,signup,password;
    JTextField tfpassword,tfusername;
    login(){
    setSize(900,400);
    setLocation(350,200);
    setLayout(null);
    
    getContentPane().setBackground(Color.white);
    
    JPanel p1 = new JPanel();
    p1.setBackground(Color.pink);
    p1.setBounds(35,30,400,300);
    p1.setLayout(null);
    add(p1);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(100,60,200,200); // this works only when setLayout is null
    p1.add(image);
    
    JPanel p2 = new JPanel();
    p2.setLayout(null);
    p2.setBounds(400,30,450,300);
    add(p2);
    
    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(60,20,100,25);
    lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
    p2.add(lblusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(60,60,300,30);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tfusername);
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(60,110,100,25);
    lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
    p2.add(lblpassword);
    
    tfpassword = new JTextField();
    tfpassword.setBounds(60,150,300,30);
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tfpassword);
    
    login = new JButton("Login");
    login.setBounds(60,200,130,30);
    login.setBackground( Color.pink);
    login.setForeground(Color.white);
    login.setBorder(new LineBorder(Color.pink));
    login.addActionListener(this);
    p2.add(login);
    
    signup = new JButton("Signup");
    signup.setBounds(230,200,130,30);
    signup.setBackground( Color.pink);
    signup.setForeground(Color.white);
    signup.setBorder(new LineBorder(Color.pink));
    signup.addActionListener(this);
    p2.add(signup);
    
    password = new JButton("Forget Password");
    password.setBounds(150,250,130,30);
    password.setBackground( Color.pink);
    password.setForeground(Color.white);
    password.setBorder(new LineBorder(Color.pink));
    password.addActionListener(this);
    p2.add(password);
    
    JLabel text = new JLabel("Trouble Login");
    text.setBounds(60,255,150,20);
    text.setForeground(Color.black);
    p2.add(text);
    
    
    
    setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                String query = "select * from account where username = '" + username + "' AND password = '" +pass+ "'";
                conn c= new conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new loading(username);
                } else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or Password");
                    
                }
              

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == signup){
        setVisible(false);
        new signup();
        
        } else{
            setVisible(false);
            new forgetpassword();
        }
        
    }
    
    public static void main(String[] args){
        new login();
    }
}
