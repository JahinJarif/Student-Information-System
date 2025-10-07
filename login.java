package project.pkg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login
{
    public static String s10;
    public static void main(String args[])
    {
        login1();
    }
    public static void login1()
    {
        JFrame frame=new JFrame();
        JPanel p1=new JPanel(null);
        p1.setBounds(0, 0, 230, 400);
        p1.setBackground(new Color(5, 163, 137));
        ImageIcon imageicon1 = new ImageIcon("/Users/jahinjarif/Downloads/Project/JKKNIU.png");
        JLabel l1=new JLabel(imageicon1);
        l1.setBounds(79, 90, 80, 80);
        JLabel l2=new JLabel("Student Information System");
        l2.setBounds(25, 170, 200, 30);
        Font font = new Font("Times New Roman", Font.BOLD, 16);
        l2.setFont(font);
        p1.add(l1);
        p1.add(l2);
        frame.add(p1);
        JPanel p2=new JPanel(null);
        p2.setBounds(230, 0, 300, 400);
        //p2.setBackground(new Color(190, 196, 195));
        ImageIcon imageicon2 = new ImageIcon("/Users/jahinjarif/Downloads/Project/user.jpg");
        JLabel l3=new JLabel(imageicon2);
        l3.setBounds(130, 40, 48, 60);
        JLabel l4=new JLabel("ID");
        l4.setBounds(35, 130, 40, 20);
        Font font1 = new Font("Times New Roman",Font.BOLD, 12);
        l4.setFont(font1);
        JTextField t1=new JTextField();
        t1.setBounds(60, 125, 200, 30);

        t1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t1.transferFocus();
            }
        });
        JLabel l5=new JLabel("Password");
        l5.setBounds(5, 190, 50, 20);
        Font font2 = new Font("Times New Roman",Font.BOLD, 12);
        l5.setFont(font2);
        JPasswordField t2=new JPasswordField(13);
        t2.setBounds(60, 185, 200, 30);
        t2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t2.transferFocus();
            }
        });
        JCheckBox showPasswordCheckbox = new JCheckBox();
        showPasswordCheckbox.setBounds(260, 189, 20, 20);
        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected())
                {
                    t2.setEchoChar((char) 0);
                }
                else
                {
                    t2.setEchoChar('\u2022');
                }
            }
        });
        p2.add(showPasswordCheckbox);
        JButton b1=new JButton("Login");
        b1.setBounds(110, 245, 80, 30);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t1.getText();
                char[] s2=t2.getPassword();
                String s3 = new String(s2);
                //System.out.print(s1+" "+s3);
                if("csejkkniu".equals(s1) && "deptCSEJKKNIU".equals(s3))
                {
                    home h=new home();
                    h.home1();
                }
                else
                {
                    if(s3.isEmpty() || s1.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Error: Please fill the blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        boolean ok=false;
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            String stt2="\""+s1+"\"",stt3="\""+s3+"\"";
                            String stt1="Select * from student.password where password.Registration_Number="+stt2+"and password.passcode="+stt3+";";
                            Statement s=co.createStatement();
                            ResultSet rs=s.executeQuery(stt1);
                            while(rs.next())
                            {
                                String st1=rs.getString("Registration_Number");
                                String st2=rs.getString("passcode");
                                if(st1.equals(s1) && st2.equals(s3))
                                    ok=true;
                            }
                            if(ok==true)
                            {
                                home2 h=new home2(t1.getText());
                                h.home3();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Error: Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                t2.setText("");
            }
        });
        JLabel l6=new JLabel("Don't have an account?");
        l6.setBounds(40, 300, 150, 20);
        Font font3 = new Font("Times New Roman",Font.BOLD, 12);
        l6.setFont(font3);
        JButton b2=new JButton("Signup");
        b2.setBounds(165, 295, 75, 30);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                signup s=new signup();
                s.signup1();
            }
        });
        p2.add(b2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l5);
        p2.add(l4);
        p2.add(b1);
        p2.add(l6);
        frame.add(p2);
        frame.setLayout(null);
        frame.setSize(530,400);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
