package travel.management.system;


import javax.swing.*;
import java.awt.*;

public class destination extends JFrame implements Runnable{
    
    Thread t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] label = new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    JLabel caption;
    JPanel panel;
    
    public void run(){
        String[] text=new String[]{"Hilton Worldwide"," Accor S.A.","Kimpton Hotels & Restaurants","Hyatt Hotels & Resorts","Marriott International","Four Seasons Hotels & Resorts","Wyndham Hotels & Resorts","IHG Hotels and Resorts","Best Western International"};
        try{
            for(int i=0;i<9;i++){
                label[i].setVisible(true);
                
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    destination(){
        setBounds(350,150,800,600);
        
        caption = new JLabel();
        caption.setBounds(50,500,1000,50);
        caption.setFont(new Font("Tahoma",Font.BOLD,20));
        caption.setForeground(Color.white);
        add(caption);
       
        
        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];
        
        for(int i=0;i<9;i++){
        image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
        jimage[i] = image[i].getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        kimage[i] = new ImageIcon(jimage[i]);
        label[i]=new JLabel(kimage[i]);
        label[i].setBounds(0,0,800,600);
        add(label[i]);
        }
        
        t1 = new Thread(this);
        t1.start();  //calls run method
        
        setVisible(true);
    
}
    
    public static void main(String[] args){
        new destination();
    
}
}
