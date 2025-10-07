package project.pkg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
public class home
{
    public static void main(String args[])
    {
        home1();
    }
    public static void home1()
    {
        JFrame frame=new JFrame();
        JPanel p1=new JPanel(null);
        p1.setBounds(0, 0, 350, 1000);
        p1.setBackground(new Color(50, 135, 168));
        ImageIcon imageicon = new ImageIcon("/Users/jahinjarif/Downloads/Project/university.jpg");
        JLabel l1=new JLabel(imageicon);
        l1.setBounds(50, -29, 1690, 876);
        /*JLabel l2=new JLabel("Student Information System");
        l2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 50));
        l2.setForeground(Color.white);
        l2.setBounds(550, 300, 800, 200);
        frame.add(l2);*/
        frame.add(l1);
        ImageIcon imageicon2 = new ImageIcon("/Users/jahinjarif/Downloads/Project/Male-user-add-icon (1).png");
        JButton b1=new JButton(imageicon2);
        b1.setBounds(100, 35, 100, 100);
        b1.setToolTipText("Add Student Information");
        b1.setBackground(new Color(50, 135, 168));
        b1.setBorderPainted(false);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                project2 pro=new project2();
                pro.project();
            }
        });
        p1.add(b1);
        ImageIcon imageicon3 = new ImageIcon("/Users/jahinjarif/Downloads/Project/Male-user-search-icon (1).png");
        JButton b2=new JButton(imageicon3);
        b2.setBounds(100, 175, 100, 100);
        b2.setToolTipText("Search Information");
        b2.setBackground(new Color(50, 135, 168));
        b2.setBorderPainted(false);
        p1.add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Search1 pro1=new Search1();
                pro1.search2();
            }
        });
        ImageIcon imageicon4 = new ImageIcon("/Users/jahinjarif/Downloads/Project/delete-icon-male (1).png");
        JButton b3=new JButton(imageicon4);
        b3.setBounds(100, 305, 100, 100);
        b3.setToolTipText("Delete Information");
        b3.setBackground(new Color(50, 135, 168));
        b3.setBorderPainted(false);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Delete pro2=new Delete();
                try {
                    pro2.delete1();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        p1.add(b3);
        ImageIcon imageicon5 = new ImageIcon("/Users/jahinjarif/Downloads/Project/Exit.png");
        JButton b4=new JButton(imageicon5);
        b4.setBounds(100, 670, 100, 100);
        b4.setBackground(new Color(50, 135, 168));
        b4.setToolTipText("Exit");
        b4.setBorderPainted(false);
        p1.add(b4);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                System.exit(0);
            }
        });
        ImageIcon imageicon6 = new ImageIcon("/Users/jahinjarif/Downloads/Project/notice-board.png");
        JButton b5=new JButton(imageicon6);
        b5.setBounds(100, 560, 100, 100);
        b5.setBackground(new Color(50, 135, 168));
        b5.setToolTipText("NoticeBoard");
        b5.setBorderPainted(false);
        p1.add(b5);
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                demo d=new demo();
                d.demo2();
            }
        });
        ImageIcon imageicon7 = new ImageIcon("/Users/jahinjarif/Downloads/Project/update.png");
        JButton b6=new JButton(imageicon7);
        b6.setBounds(100, 430, 100, 100);
        b6.setBackground(new Color(50, 135, 168));
        b6.setToolTipText("Update data");
        b6.setBorderPainted(false);
        p1.add(b6);
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                update u=new update();
                u.update1();
            }
        });
        frame.add(p1);
        frame.setTitle("Student Information System");
        frame.setBounds(0,0,1500, 1000);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
