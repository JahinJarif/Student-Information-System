package project.pkg1;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class project2
{
    static Connection co;
    public static void createconnction()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(project2.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(project2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[])
    {
        project();
    }
    public static void project()
    {
        JFrame frame=new JFrame();
        JPanel p1=new JPanel(null);
        p1.setBackground(new Color(3, 169, 252));
        p1.setBounds(0,0,1765, 100);
        Border border = BorderFactory.createLineBorder(Color.BLACK,3);
        p1.setBorder(border);
        //p3.setBounds(0,0,1500, 100);
        //p3.setBackground(new Color(3, 169, 252));
        JLabel label=new JLabel("Student Information System");
        label.setBounds(400, 20, 650, 60);
        label.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 50));
        ImageIcon imageicon = new ImageIcon("//Users//jahinjarif//Downloads//Project//JKKNIU.png");
        JLabel label1=new JLabel(imageicon);
        label1.setBounds(0,0,150,100);
        p1.add(label);
        p1.add(label1);
        //
        JPanel p2=new JPanel(null);
        p2.setBorder(border);
        p2.setBackground(new Color(50, 168, 137));
        p2.setBounds(0,100,1565, 900);
        //
        JLabel l1=new JLabel("Name:");
        l1.setBounds(140, 120, 50, 50);
        p2.add(l1);
        JTextField t1=new JTextField();
        t1.setColumns(15);
        t1.setBounds(190, 132, 200, 30);
        p2.add(t1);
        t1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t1.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t1.transferFocus();
                }
            }
        });
        //
        JLabel l2=new JLabel("Roll No:");
        l2.setBounds(460, 120, 95, 50);
        p2.add(l2);
        JTextField t2=new JTextField();
        t2.setColumns(15);
        t2.setBounds(515, 132, 200, 30);
        p2.add(t2);
        t2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t2.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t2.transferFocus();
                }
            }
        });
        //
        JLabel l3=new JLabel("Reg. No:");
        l3.setBounds(760, 120, 90, 50);
        p2.add(l3);
        JTextField t3=new JTextField();
        t3.setColumns(15);
        t3.setBounds(820, 132, 150, 30);
        p2.add(t3);
        t3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t3.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t3.transferFocus();
                }
            }
        });
        //
        JLabel l4=new JLabel("CGPA:");
        l4.setBounds(1030, 120, 50, 50);
        p2.add(l4);
        JTextField t4=new JTextField();
        t4.setColumns(15);
        t4.setBounds(1070, 132, 150, 30);
        p2.add(t4);
        t4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t4.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t4.transferFocus();
                }
            }
        });
        //
        JLabel l5=new JLabel("Session:");
        l5.setBounds(140, 198, 75, 50);
        p2.add(l5);
        String session[]={"2019-20","2020-21","2021-22","2022-23"};        
        JComboBox cb1=new JComboBox(session); 
        cb1.setBounds(200,215,130,20);
        p2.add(cb1);
        cb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                cb1.transferFocus();
            }
        });
        //
        JLabel l6=new JLabel("Gender:");
        l6.setBounds(460, 198, 50, 50);
        p2.add(l6);
        String gender[]={"Male","Female"};        
        JComboBox cb2=new JComboBox(gender); 
        cb2.setBounds(510,215,90,20);
        p2.add(cb2);
        cb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                cb2.transferFocus();
            }
        });
        //
        JLabel l7=new JLabel("Religion:");
        l7.setBounds(760, 198, 70, 50);
        p2.add(l7);
        String religion[]={"Islam","Hindu","Buddha","Christian"};
        JComboBox cb3=new JComboBox(religion); 
        cb3.setBounds(820,215,120,20);
        p2.add(cb3);
        cb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                cb3.transferFocus();
            }
        });
        //
        JLabel l14=new JLabel("Blood Group:");
        l14.setBounds(1030, 198, 90, 50);
        p2.add(l14);
        String Blood_Group[]={"O+","O-","A+","A-","B+","B-","AB+","AB-"};
        JComboBox cb4=new JComboBox(Blood_Group); 
        cb4.setBounds(1120,215,90,20);
        p2.add(cb4);
        cb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                cb4.transferFocus();
            }
        });
        //
        JLabel l8=new JLabel();       
        l8.setText("Father's Name:");
        l8.setBounds(140, 270, 150, 50);
        p2.add(l8);
        JTextField t8=new JTextField();
        t8.setColumns(15);
        t8.setBounds(250, 281, 290, 30);
        p2.add(t8);
        t8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t8.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t8.transferFocus();
                }
            }
        });
        //
        JLabel l9=new JLabel();
        l9.setText("Mother's Name:");
        l9.setBounds(760, 270, 150, 50);
        p2.add(l9);
        JTextField t9=new JTextField();
        t9.setColumns(15);
        t9.setBounds(875, 281, 290, 30);
        p2.add(t9);
        t9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t9.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t9.transferFocus();
                }
            }
        });
        //
        JLabel l10=new JLabel();
        l10.setText("Date of Birth:");
        l10.setBounds(140, 340, 150, 50);
        p2.add(l10);
        JDateChooser d1=new JDateChooser();
        d1.setBounds(235, 351, 200, 30);
        d1.setDateFormatString("dd/MM/yyyy");
        p2.add(d1);
        
        //
        JLabel l11=new JLabel();
        l11.setText("Address:");
        l11.setBounds(760, 340, 60, 50);
        p2.add(l11);
        JTextField t11=new JTextField();
        t11.setBounds(830, 351, 200, 30);
        t11.setColumns(15);
        p2.add(t11);
        t11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t11.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t11.transferFocus();
                }
            }
        });
        //
        JLabel l12=new JLabel();
        l12.setText("Phone Number:");
        l12.setBounds(140, 410, 800, 50);
        p2.add(l12);
        JTextField t12=new JTextField();
        t12.setBounds(245, 421, 200, 30);
        t12.setColumns(15);
        p2.add(t12);
        t12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t12.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t12.transferFocus();
                }
            }
        });
        //
        JLabel l13=new JLabel();
        l13.setText("Email:");
        l13.setBounds(760, 410, 800, 50);
        p2.add(l13);
        JTextField t13=new JTextField();
        t13.setBounds(800, 421, 200, 30);
        t13.setColumns(15);
        p2.add(t13);
        t13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                
                String s1=t13.getText();
                if(s1.length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Please fill the blank","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t13.transferFocus();
                }
            }
        });
        //
        JButton b1=new JButton("+ADD");
        b1.setBounds(500, 580, 100, 30);
        b1.setBackground(new Color(66, 78, 245));
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try {
                    createconnction();
                    String s1=t1.getText();
                    String s2=t2.getText();
                    String s3=t3.getText();
                    String s4=t4.getText();
                    String s5=(String)cb1.getSelectedItem();
                    String s6=(String)cb2.getSelectedItem();
                    String s7=(String)cb3.getSelectedItem();
                    String s8=t8.getText();
                    String s9=t9.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date s0 = d1.getDate();
                    String s10=dateFormat.format(s0);
                    String s11=t11.getText();
                    String s12=t12.getText();
                    String s13=t13.getText();
                    String s14=(String)cb4.getSelectedItem();
                    System.out.print(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13);
                    String st7=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14;
                    System.out.println(st7);
                    PreparedStatement s=co.prepareStatement("Insert into student.studentinfo values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    s.setString(1, s1);
                    s.setString(2, s2);
                    s.setString(3, s3);
                    s.setString(4, s4);
                    s.setString(5, s5);
                    s.setString(6, s6);
                    s.setString(7, s7);
                    s.setString(8, s8);
                    s.setString(9, s9);
                    s.setString(10, s10);
                    s.setString(11, s11);
                    s.setString(12, s12);
                    s.setString(13, s13);
                    s.setString(14, s14);
                    s.execute();
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(project2.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Added Successfully","Alert",JOptionPane.INFORMATION_MESSAGE); 
            }
        });
        p2.add(b1);
        
        JButton b3=new JButton("CLEAR");
        b3.setBounds(800, 580, 100, 30);
        b3.setBackground(new Color(66, 78, 245));
        b3.setForeground(Color.RED);
        p2.add(b3);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t8.setText("");
                t9.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
            }
        });
        frame.add(p1);
        frame.add(p2);
        frame.setTitle("Student Information System");
        frame.setBounds(0,0,1500, 1000);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
