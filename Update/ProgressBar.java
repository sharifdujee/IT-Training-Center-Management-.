/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Asus
 */
public class ProgressBar {
   private JFrame mainFrame;
   private JButton startButton;
   private JProgressBar pb;
   private Task task1;
   
   public ProgressBar (){
       mainFrame = new JFrame("Progress Bar");
       mainFrame.setSize(600, 400);
       mainFrame.setLayout(null);
       mainFrame.setDefaultCloseOperation(3);
       startButton = new JButton("Start");
       startButton.setBounds(50, 50, 100, 50);
       startButton.addActionListener(new ActionListener(){
           
           public void actionPerformed(ActionEvent e){
               task1 = new Task();
               task1.start();
               //JOptionPane.showMessageDialog(null, "Finish");
               
           }
           });
       pb = new JProgressBar(0,100);
       pb.setBounds(50, 150, 500, 50);
       pb.setStringPainted(true);
       mainFrame.add(pb);
       mainFrame.add(startButton);
       mainFrame.setVisible(true);
       
}

    public static void main(String[] args) {
        new ProgressBar();
       
        
    }
    private class  Task extends Thread{
        
        public void run(){
            for(int i = 10; i<=100; i++){
              pb.setValue(i);
              
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
              
                 
              
            }
        }
        
    } 
   
}
