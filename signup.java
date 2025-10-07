package project.pkg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.pkg1.project2.co;

public class signup
{
    public static void main(String args[])
    {
        signup1();
    }
    public static void signup1()
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
                String s1=t1.getText();
                Connection co;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    Statement s=co.createStatement();
                    String stt2="\""+s1+"\"",st1="",st3="";
                    String stt1="Select * from student.studentinfo where studentinfo.Registration_Number="+stt2+";";
                    ResultSet rs=s.executeQuery(stt1);
                    while(rs.next())
                    {
                        st1=rs.getString("Registration_Number");
                        if(st1.equals(s1))
                            st3=st1;
                    }
                    if(s1.isEmpty() || st3.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Error: Please fill the blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(st3.equals(s1))
                    {
                        String st2="",st4="";
                        String stt3="Select * from student.studentinfo,student.password where studentinfo.Registration_Number=password.Registration_Number;";
                        ResultSet rs1=s.executeQuery(stt3);
                        while(rs1.next())
                        {
                            st2=rs1.getString("Registration_Number");
                            if(st2.equals(s1))
                                st4=st1;
                        }
                        //System.out.print(st2+" "+s1);
                        if(!st2.equals(s1))
                        {
                            t1.transferFocus();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Error: ID is already exists", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if(!st3.equals(s1))
                    {
                        JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                char[] s2=t2.getPassword();
                String s3 = new String(s2);
                if(s3.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Error: Please fill the blank", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t2.transferFocus();
                }
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
        JButton b1=new JButton("Signup");
        b1.setBounds(110, 245, 80, 30);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    String s1=t1.getText();
                    char[] s2=t2.getPassword();
                    String s3 = new String(s2);
                    if(s1.isEmpty() || s3.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Error: Please fill the blank", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        PreparedStatement s=co.prepareStatement("Insert into student.password values (?,?)");
                        s.setString(1, s1);
                        s.setString(2, s3);
                        s.execute();
                        s.close();
                        JOptionPane.showMessageDialog(null, "Signup successfully","Alert",JOptionPane.INFORMATION_MESSAGE);
                        login l=new login();
                        l.login1();
                    }
                }
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        JLabel l6=new JLabel("Already have an account?");
        l6.setBounds(40, 300, 150, 20);
        Font font3 = new Font("Times New Roman",Font.BOLD, 10);
        l6.setFont(font3);
        JButton b2=new JButton("login");
        b2.setBounds(165, 295, 75, 30);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                login l=new login();
                l.login1();
            }
        });
        p2.add(l6);
        p2.add(b2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l5);
        p2.add(l4);
        p2.add(b1);
        frame.add(p2);
        frame.setLayout(null);
        frame.setSize(530,400);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}
