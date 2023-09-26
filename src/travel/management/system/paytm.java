package travel.management.system;

import javax.swing.*;
import java.awt.event.*;

public class paytm extends JFrame implements ActionListener{
    
    paytm(){
        
        setBounds(500,200,800,600);
        
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false); //this will not allow changes in page
        try{
            pane.setPage("http://paytm.com/rent-payment");
        } catch(Exception e){
            pane.setContentType("text/hyml");
            pane.setText("<html>Could not load,Error 404</html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back = new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new payment();
    }
    
    public static void main(String[] args){
        new paytm();
    }
}
