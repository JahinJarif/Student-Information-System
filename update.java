package project.pkg1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class update
{
    public static void main(String args[])
    {
        update1();
    }
    public static void update1()
    {
        boolean ok=false;
        String name = JOptionPane.showInputDialog(null,"Enter Registration No.:");
        String s1="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection co;
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
            Statement s=co.createStatement();
            String q="Select * from student.studentinfo where Registration_Number="+name;
            ResultSet rs=s.executeQuery(q);
            String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
            while(rs.next())
            {
                ok=true;
                st1=rs.getString("Name");
                st2=rs.getString("Roll_No.");
                st3=rs.getString("Registration_Number");
                st4=rs.getString("CGPA");
                st5=rs.getString("Session");
                st6=rs.getString("Gender");
                st7=rs.getString("Religion");
                st8=rs.getString("Father_Name");
                st9=rs.getString("Mother_Name");
                st10=rs.getString("Date_of_Birth");
                st11=rs.getString("Address");
                st12=rs.getString("Phone_Number");
                st13=rs.getString("Email");
                st14=rs.getString("Blood_Group");
                //System.out.print(st1+st2+st3+st4+st5+st6+st7+st8+st9+st10+st11+st12+st13+st14);
                JFrame frame=new JFrame();
                frame.setTitle("Student Information");
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
                ImageIcon imageicon = new ImageIcon("/Users/jahinjarif/Downloads/Project/JKKNIU.png");
                JLabel label1=new JLabel(imageicon);
                label1.setBounds(0,0,150,100);
                p1.add(label);
                p1.add(label1);
                frame.add(p1);
                JLabel l1=new JLabel("Name:");
                JPanel p2=new JPanel(null);
                p2.setBackground(new Color(50, 168, 137));
                p2.setBounds(0,100,1565, 900);
                p2.setBorder(border);
                l1.setBounds(140, 120, 50, 50);
                p2.add(l1);
                JTextField t1=new JTextField();
                t1.setText(st1);
                t1.setBounds(190, 132, 200, 30);
                t1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Name=? WHERE Registration_Number=?;");
                            statement.setString(1, t1.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.transferFocus();
                    }
                });
                //t1.setEditable(false);
                p2.add(t1);
                //
                JLabel l2=new JLabel("Roll No.:");
                l2.setBounds(460, 120, 95, 50);
                p2.add(l2);
                JTextField t2=new JTextField();
                t2.setText(st2);
                t2.setBounds(515, 132, 200, 30);
                t2.setEditable(false);
                p2.add(t2);
                //
                JLabel l3=new JLabel("Reg. No.:");
                l3.setBounds(760, 120, 90, 50);
                p2.add(l3);
                JTextField t3=new JTextField();
                t3.setText(st3);
                t3.setBounds(820, 132, 150, 30);
                t3.setEditable(false);
                p2.add(t3);
                //
                JLabel l4=new JLabel("CGPA:");
                l4.setBounds(1030, 120, 50, 50);
                p2.add(l4);
                JTextField t4=new JTextField();
                t4.setText(st4);
                t4.setBounds(1070, 132, 150, 30);
                t4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET CGPA=? WHERE Registration_Number=?;");
                            float floatValue = Float.parseFloat(t4.getText());
                            statement.setFloat(1, floatValue);
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t4.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t4.setEditable(false);
                p2.add(t4);
                //
                JLabel l5=new JLabel("Session:");
                l5.setBounds(140, 198, 75, 50);
                p2.add(l5);
                JTextField t5=new JTextField();
                t5.setText(st5);
                t5.setBounds(200,215,130,20);
                t5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Session=? WHERE Registration_Number=?;");
                            statement.setString(1, t5.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t5.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t5.setEditable(false);
                p2.add(t5);
                //
                JLabel l6=new JLabel("Gender:");
                l6.setBounds(460, 198, 50, 50);
                p2.add(l6);
                JTextField t6=new JTextField();
                t6.setText(st6);
                t6.setBounds(510,215,90,20);
                t6.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Gender=? WHERE Registration_Number=?;");
                            statement.setString(1, t6.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t6.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t6.setEditable(false);
                p2.add(t6);
                //
                JLabel l7=new JLabel("Religion:");
                l7.setBounds(760, 198, 70, 50);
                p2.add(l7);
                JTextField t7=new JTextField();
                t7.setText(st7);
                t7.setBounds(820,215,120,20);
                t7.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Religion=? WHERE Registration_Number=?;");
                            statement.setString(1, t7.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t7.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t7.setEditable(false);
                p2.add(t7);
                //
                JLabel l14=new JLabel("Blood Group:");
                l14.setBounds(1030, 198, 90, 50);
                p2.add(l14);
                JTextField t14=new JTextField();
                t14.setText(st14);
                t14.setBounds(1120,215,90,20);
                t14.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Blood_Group=? WHERE Registration_Number=?;");
                            statement.setString(1, t14.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t14.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t14.setEditable(false);
                p2.add(t14);
                //
                JLabel l8=new JLabel();
                l8.setText("Father's Name:");
                l8.setBounds(140, 270, 150, 50);
                p2.add(l8);
                JTextField t8=new JTextField();
                t8.setText(st8);
                t8.setBounds(250, 281, 290, 30);
                t8.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Father_Name=? WHERE Registration_Number=?;");
                            statement.setString(1, t8.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t8.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t8.setEditable(false);
                p2.add(t8);
                //
                JLabel l9=new JLabel();
                l9.setText("Mother's Name:");
                l9.setBounds(760, 270, 150, 50);
                p2.add(l9);
                JTextField t9=new JTextField();
                t9.setText(st9);
                t9.setBounds(875, 281, 290, 30);
                //t9.setEditable(false);
                p2.add(t9);
                t9.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Mother_Name=? WHERE Registration_Number=?;");
                            statement.setString(1, t9.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //
                JLabel l10=new JLabel();
                l10.setText("Date of Birth:");
                l10.setBounds(140, 340, 150, 50);
                p2.add(l10);
                JTextField t10=new JTextField();
                t10.setText(st10);
                t10.setBounds(250, 351, 290, 30);
                t10.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Date_of_Birth=? WHERE Registration_Number=?;");
                            statement.setString(1, t10.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t10.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t10.setEditable(false);
                p2.add(t10);
                //
                JLabel l11=new JLabel();
                l11.setText("Address:");
                l11.setBounds(760, 340, 60, 50);
                p2.add(l11);
                JTextField t11=new JTextField();
                t11.setText(st11);
                t11.setBounds(830, 351, 200, 30);
                t11.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Address=? WHERE Registration_Number=?;");
                            statement.setString(1, t11.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t11.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t11.setEditable(false);
                p2.add(t11);
                //
                JLabel l12=new JLabel();
                l12.setText("Phone Number:");
                l12.setBounds(140, 410, 800, 50);
                p2.add(l12);
                JTextField t12=new JTextField();
                t12.setText(st12);
                t12.setBounds(245, 421, 200, 30);
                t12.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Phone_Number=? WHERE Registration_Number=?;");
                            statement.setString(1, t12.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t12.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t12.setEditable(false);
                p2.add(t12);
                //
                JLabel l13=new JLabel();
                l13.setText("Email:");
                l13.setBounds(760, 410, 800, 50);
                p2.add(l13);
                JTextField t13=new JTextField();
                t13.setText(st13);
                t13.setBounds(800, 421, 200, 30);
                t13.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection co1;
                            co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                            PreparedStatement statement = co.prepareStatement("UPDATE student.studentinfo SET Email=? WHERE Registration_Number=?;");
                            statement.setString(1, t13.getText());
                            statement.setString(2, name);
                            statement.execute();
                            statement.close();
                            t13.transferFocus();
                            //JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex)
                        {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //t13.setEditable(false);
                p2.add(t13);
                JButton b5=new JButton("Update");
                b5.setBounds(500, 580, 100, 30);
                b5.setBackground(new Color(66, 78, 245));
                b5.setForeground(Color.BLACK);
                p2.add(b5);
                b5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(null, "Updated successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                JButton b4=new JButton("Exit");
                b4.setBounds(800, 580, 100, 30);
                b4.setBackground(new Color(66, 78, 245));
                b4.setForeground(Color.RED);
                p2.add(b4);
                b4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        System.exit(0);
                    }
                });
                frame.add(p2);
                frame.setBounds(0,0,500, 1000);
                frame.setLayout(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.setVisible(true);
            }

        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ok==false)
        {
            JOptionPane.showMessageDialog(null, "This registration Number is not valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection co;
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
            }
            catch (ClassNotFoundException ex)
            {
                Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
