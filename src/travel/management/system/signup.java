package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfusername,tfname,tfpassword,tfanswer;
    Choice security1;
    signup(){
       setBounds(400,200,700,400);
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JPanel p1 = new JPanel();
       p1.setBackground(Color.pink);
       p1.setBounds(0,0,350,400);
       p1.setLayout(null);
       add(p1);
       
       JLabel lblusername = new JLabel("USERNAME");
       lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
       lblusername.setBounds(30,20,100,25);
       p1.add(lblusername);
       
       tfusername= new JTextField();
       tfusername.setBounds(140,20,160,25);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfusername);
       
       JLabel name = new JLabel("NAME");
       name.setFont(new Font("Tahoma",Font.PLAIN,14));
       name.setBounds(30,60,100,25);
       p1.add(name);
       
       tfname= new JTextField();
       tfname.setBounds(140,60,160,25);
       tfname.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfname);
       
       JLabel password = new JLabel("PASSWORD");
       password.setFont(new Font("Tahoma",Font.PLAIN,14));
       password.setBounds(30,100,100,25);
       p1.add(password);
       
       tfpassword= new JTextField();
       tfpassword.setBounds(140,100,160,25);
       tfpassword.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfpassword);
       
       JLabel lblsecurity = new JLabel("SECURITY QUE.");
       lblsecurity.setFont(new Font("Tahoma",Font.PLAIN,14));
       lblsecurity.setBounds(30, 140,130, 25);
       p1.add(lblsecurity);
       
       security1 = new Choice();
       security1.add("Favourite colour");
       security1.add("Fav Movie");
       security1.add("Fav hero");
       security1.setBounds(180,140,120,25);
       p1.add(security1);
       
       JLabel answer = new JLabel("ANSWER");
       answer.setFont(new Font("Tahoma",Font.PLAIN,14));
       answer.setBounds(30,180,160,25);
       p1.add(answer);
       
       tfanswer = new JTextField();
       tfanswer.setBounds(140,180,160,25);
       tfanswer.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfanswer);
       
       create = new JButton("Create");
       create.setBounds(50,250,120,25);
       create.setBackground(Color.white);
       create.setForeground( Color.black);
       create.setFont(new Font("Tahoma",Font.PLAIN,14));
       create.addActionListener(this);
       p1.add(create);
       
       back = new JButton ("Back");
       back.setBounds(200,250,120,25);
       back.setBackground(Color.white);
       back.setForeground(Color.BLACK);
       back.setFont(new Font("Tahoma",Font.PLAIN,14));
       back.addActionListener(this);
       p1.add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Signup11.png"));
       Image i2= i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(450,90,150,150);
       add(image);

       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String security = security1.getSelectedItem();
            String answer = tfanswer.getText();
        
            String query = "insert into account values('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";

            try{
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created successfully");
                
                setVisible(false);
                new login();
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource()== back){
            setVisible(false);
            new login();
        }
    }
    
    public static void main(String [] args){
        new signup();
    }
}
