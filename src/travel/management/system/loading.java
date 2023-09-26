package travel.management.system;

import javax.swing.*;
import java.awt.*;


public class loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;  //----
    
    public void run(){
        try{
        for(int i=1;i<=101;i++){
            int max= bar.getMaximum();
            int value = bar.getValue();
            
            if(value<max){
                bar.setValue(bar.getValue()+1);
            } else{
                setVisible(false);
                new dashboard(username);
            }
            Thread.sleep(50); //Loading speed
        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    loading(String username){  //----
        this.username = username;
        t = new Thread(this);
        setBounds(500,200,600,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel ("Airline Management System");
        text.setBounds(50,20,600,50);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway",Font.PLAIN,35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading,Please wait...");
        loading.setBounds(230,130,150,35);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.PLAIN,14));
        add(loading);
        
        
        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblusername);
        
        t.start();
        setVisible(true);
        
    }
   
    public static void main(String[] args){
        new loading("");
    }
}
