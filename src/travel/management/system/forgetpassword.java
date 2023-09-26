
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class forgetpassword extends JFrame implements ActionListener{
    TextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrieve,back;
    
    forgetpassword(){
        setBounds(300,200,700,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,20,400,300);
        p1.setBackground(Color.LIGHT_GRAY);
        add(p1);
        
        JLabel lblusername = new JLabel ("Username");
        lblusername.setBounds(40,20,90,25);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,14));
        p1.add(lblusername);
        
        tfusername = new TextField();
        tfusername.setBounds(130,20,150,25);
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.DARK_GRAY);
        search.setForeground(Color.white);
        search.setBounds(300,20,90,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,60,90,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
        p1.add(lblname);
        
        tfname = new TextField();
        tfname.setBounds(130,60,150,25);
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Security Que:");
        lblquestion.setBounds(40,100,90,25);
        lblquestion.setFont(new Font("Tahoma",Font.PLAIN,14));
        p1.add(lblquestion);
        
        tfquestion = new TextField();
        tfquestion.setBounds(130,100,150,25);
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40,140,90,25);
        lblanswer.setFont(new Font("Tahoma",Font.PLAIN,14));
        p1.add(lblanswer);
        
        tfanswer = new TextField();
        tfanswer.setBounds(130,140,150,25);
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(300,140,90,25);
        retrieve.setBackground(Color.DARK_GRAY);
        retrieve.setForeground(Color.white);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,180,90,25);
        lblpassword.setFont(new Font("Tahoma",Font.PLAIN,14));
        p1.add(lblpassword);
        
        tfpassword = new TextField();
        tfpassword.setBounds(130,180,150,25);
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBounds(150,250,100,25);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                conn c = new conn();
                ResultSet rs = c.s. executeQuery(query);
                while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfquestion.setText(rs.getString("security"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()== retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                conn c = new conn();
                ResultSet rs = c.s. executeQuery(query);
                while(rs.next()){
                tfpassword.setText(rs.getString("password"));
                }
            } catch (Exception e){
               e.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
            new login();
        }
        }
    
    public static void main(String[] args){
       new forgetpassword(); 
    }
}
    

