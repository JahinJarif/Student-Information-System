package project.pkg1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search
{
    public static void main(String args[])
    {
        search2();
    }
    public static void search2()
    {
        JFrame frame=new JFrame();
        JLabel l1=new JLabel("Search Option:");
        l1.setBounds(65, 23, 100, 50);
        frame.add(l1);
        String search[]={"All","Individual","2019-20","2020-21","2021-22","2022-23"};
        JComboBox cb1=new JComboBox(search);
        cb1.setBounds(155,40,90,20);
        frame.add(cb1);
        JButton b1=new JButton("Search");
        b1.setBounds(120, 95, 80, 30);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=(String)cb1.getSelectedItem();
                if("All".equals(s1))
                {
                    JFrame frame1=new JFrame();
                    JTable table=new JTable(new DefaultTableModel());
                    table.setRowHeight(30);
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    try {
                        String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection co;
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                        Statement s=co.createStatement();
                        model.addColumn("Name");
                        model.addColumn("Roll No.");
                        model.addColumn("Reg. No.");
                        model.addColumn("CGPA");
                        model.addColumn("Session");
                        model.addColumn("Gender");
                        model.addColumn("Religion");
                        model.addColumn("Father's Name");
                        model.addColumn("Mother's Name");
                        model.addColumn("Date of Birth");
                        model.addColumn("Address");
                        model.addColumn("Phone Number");
                        model.addColumn("Email");
                        model.addColumn("Blood Group");
                        ResultSet rs=s.executeQuery("Select * from student.studentinfo");
                        while(rs.next())
                        {
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
                            model.addRow(new Object[]{st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14});
                        }
                        TableColumn column1 = table.getColumnModel().getColumn(0);
                        column1.setPreferredWidth(120);
                        TableColumn column2 = table.getColumnModel().getColumn(1);
                        column2.setPreferredWidth(40);
                        TableColumn column3 = table.getColumnModel().getColumn(2);
                        column3.setPreferredWidth(30);
                        TableColumn column4 = table.getColumnModel().getColumn(3);
                        column4.setPreferredWidth(30);
                        TableColumn column5 = table.getColumnModel().getColumn(4);
                        column5.setPreferredWidth(30);
                        TableColumn column6 = table.getColumnModel().getColumn(5);
                        column6.setPreferredWidth(30);
                        TableColumn column7 = table.getColumnModel().getColumn(6);
                        column7.setPreferredWidth(30);
                        TableColumn column8 = table.getColumnModel().getColumn(7);
                        column8.setPreferredWidth(120);
                        TableColumn column9 = table.getColumnModel().getColumn(8);
                        column9.setPreferredWidth(120);
                        TableColumn column10 = table.getColumnModel().getColumn(9);
                        column10.setPreferredWidth(40);
                        TableColumn column11 = table.getColumnModel().getColumn(10);
                        column11.setPreferredWidth(80);
                        TableColumn column12 = table.getColumnModel().getColumn(11);
                        column12.setPreferredWidth(50);
                        TableColumn column13 = table.getColumnModel().getColumn(12);
                        column13.setPreferredWidth(100);
                        TableColumn column14 = table.getColumnModel().getColumn(13);
                        column14.setPreferredWidth(50);
                        frame1.add(new JScrollPane(table));
                        //frame1.setLayout(null);
                        //frame1.setSize(330,200);
                        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setResizable(false);
                        frame1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("2019-20".equals(s1))
                {
                    JFrame frame1=new JFrame();
                    JTable table=new JTable(new DefaultTableModel());
                    table.setRowHeight(30);
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    try {
                        String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection co;
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                        Statement s=co.createStatement();
                        model.addColumn("Name");
                        model.addColumn("Roll No.");
                        model.addColumn("Reg. No.");
                        model.addColumn("CGPA");
                        model.addColumn("Session");
                        model.addColumn("Gender");
                        model.addColumn("Religion");
                        model.addColumn("Father's Name");
                        model.addColumn("Mother's Name");
                        model.addColumn("Date of Birth");
                        model.addColumn("Address");
                        model.addColumn("Phone Number");
                        model.addColumn("Email");
                        model.addColumn("Blood Group");
                        ResultSet rs=s.executeQuery("Select * from student.studentinfo where Session=s1");
                        while(rs.next())
                        {
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
                            model.addRow(new Object[]{st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14});
                        }
                        TableColumn column1 = table.getColumnModel().getColumn(0);
                        column1.setPreferredWidth(120);
                        TableColumn column2 = table.getColumnModel().getColumn(1);
                        column2.setPreferredWidth(40);
                        TableColumn column3 = table.getColumnModel().getColumn(2);
                        column3.setPreferredWidth(30);
                        TableColumn column4 = table.getColumnModel().getColumn(3);
                        column4.setPreferredWidth(30);
                        TableColumn column5 = table.getColumnModel().getColumn(4);
                        column5.setPreferredWidth(30);
                        TableColumn column6 = table.getColumnModel().getColumn(5);
                        column6.setPreferredWidth(30);
                        TableColumn column7 = table.getColumnModel().getColumn(6);
                        column7.setPreferredWidth(30);
                        TableColumn column8 = table.getColumnModel().getColumn(7);
                        column8.setPreferredWidth(120);
                        TableColumn column9 = table.getColumnModel().getColumn(8);
                        column9.setPreferredWidth(120);
                        TableColumn column10 = table.getColumnModel().getColumn(9);
                        column10.setPreferredWidth(40);
                        TableColumn column11 = table.getColumnModel().getColumn(10);
                        column11.setPreferredWidth(80);
                        TableColumn column12 = table.getColumnModel().getColumn(11);
                        column12.setPreferredWidth(50);
                        TableColumn column13 = table.getColumnModel().getColumn(12);
                        column13.setPreferredWidth(100);
                        TableColumn column14 = table.getColumnModel().getColumn(13);
                        column14.setPreferredWidth(50);
                        frame1.add(new JScrollPane(table));
                        //frame1.setLayout(null);
                        //frame1.setSize(330,200);
                        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setResizable(false);
                        frame1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("2020-21".equals(s1))
                {
                    JFrame frame1=new JFrame();
                    JTable table=new JTable(new DefaultTableModel());
                    table.setRowHeight(30);
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    try {
                        String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection co;
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                        Statement s=co.createStatement();
                        model.addColumn("Name");
                        model.addColumn("Roll No.");
                        model.addColumn("Reg. No.");
                        model.addColumn("CGPA");
                        model.addColumn("Session");
                        model.addColumn("Gender");
                        model.addColumn("Religion");
                        model.addColumn("Father's Name");
                        model.addColumn("Mother's Name");
                        model.addColumn("Date of Birth");
                        model.addColumn("Address");
                        model.addColumn("Phone Number");
                        model.addColumn("Email");
                        model.addColumn("Blood Group");
                        ResultSet rs=s.executeQuery("Select * from student.studentinfo where Session=s1");
                        while(rs.next())
                        {
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
                            model.addRow(new Object[]{st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14});
                        }
                        TableColumn column1 = table.getColumnModel().getColumn(0);
                        column1.setPreferredWidth(120);
                        TableColumn column2 = table.getColumnModel().getColumn(1);
                        column2.setPreferredWidth(40);
                        TableColumn column3 = table.getColumnModel().getColumn(2);
                        column3.setPreferredWidth(30);
                        TableColumn column4 = table.getColumnModel().getColumn(3);
                        column4.setPreferredWidth(30);
                        TableColumn column5 = table.getColumnModel().getColumn(4);
                        column5.setPreferredWidth(30);
                        TableColumn column6 = table.getColumnModel().getColumn(5);
                        column6.setPreferredWidth(30);
                        TableColumn column7 = table.getColumnModel().getColumn(6);
                        column7.setPreferredWidth(30);
                        TableColumn column8 = table.getColumnModel().getColumn(7);
                        column8.setPreferredWidth(120);
                        TableColumn column9 = table.getColumnModel().getColumn(8);
                        column9.setPreferredWidth(120);
                        TableColumn column10 = table.getColumnModel().getColumn(9);
                        column10.setPreferredWidth(40);
                        TableColumn column11 = table.getColumnModel().getColumn(10);
                        column11.setPreferredWidth(80);
                        TableColumn column12 = table.getColumnModel().getColumn(11);
                        column12.setPreferredWidth(50);
                        TableColumn column13 = table.getColumnModel().getColumn(12);
                        column13.setPreferredWidth(100);
                        TableColumn column14 = table.getColumnModel().getColumn(13);
                        column14.setPreferredWidth(50);
                        frame1.add(new JScrollPane(table));
                        //frame1.setLayout(null);
                        //frame1.setSize(330,200);
                        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setResizable(false);
                        frame1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("2021-22".equals(s1))
                {
                    JFrame frame1=new JFrame();
                    JTable table=new JTable(new DefaultTableModel());
                    table.setRowHeight(30);
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    try {
                        String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection co;
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                        Statement s=co.createStatement();
                        model.addColumn("Name");
                        model.addColumn("Roll No.");
                        model.addColumn("Reg. No.");
                        model.addColumn("CGPA");
                        model.addColumn("Session");
                        model.addColumn("Gender");
                        model.addColumn("Religion");
                        model.addColumn("Father's Name");
                        model.addColumn("Mother's Name");
                        model.addColumn("Date of Birth");
                        model.addColumn("Address");
                        model.addColumn("Phone Number");
                        model.addColumn("Email");
                        model.addColumn("Blood Group");
                        ResultSet rs=s.executeQuery("Select * from student.studentinfo where Session=s1");
                        while(rs.next())
                        {
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
                            model.addRow(new Object[]{st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14});
                        }
                        TableColumn column1 = table.getColumnModel().getColumn(0);
                        column1.setPreferredWidth(120);
                        TableColumn column2 = table.getColumnModel().getColumn(1);
                        column2.setPreferredWidth(40);
                        TableColumn column3 = table.getColumnModel().getColumn(2);
                        column3.setPreferredWidth(30);
                        TableColumn column4 = table.getColumnModel().getColumn(3);
                        column4.setPreferredWidth(30);
                        TableColumn column5 = table.getColumnModel().getColumn(4);
                        column5.setPreferredWidth(30);
                        TableColumn column6 = table.getColumnModel().getColumn(5);
                        column6.setPreferredWidth(30);
                        TableColumn column7 = table.getColumnModel().getColumn(6);
                        column7.setPreferredWidth(30);
                        TableColumn column8 = table.getColumnModel().getColumn(7);
                        column8.setPreferredWidth(120);
                        TableColumn column9 = table.getColumnModel().getColumn(8);
                        column9.setPreferredWidth(120);
                        TableColumn column10 = table.getColumnModel().getColumn(9);
                        column10.setPreferredWidth(40);
                        TableColumn column11 = table.getColumnModel().getColumn(10);
                        column11.setPreferredWidth(80);
                        TableColumn column12 = table.getColumnModel().getColumn(11);
                        column12.setPreferredWidth(50);
                        TableColumn column13 = table.getColumnModel().getColumn(12);
                        column13.setPreferredWidth(100);
                        TableColumn column14 = table.getColumnModel().getColumn(13);
                        column14.setPreferredWidth(50);
                        frame1.add(new JScrollPane(table));
                        //frame1.setLayout(null);
                        //frame1.setSize(330,200);
                        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setResizable(false);
                        frame1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("2022-23".equals(s1))
                {
                    JFrame frame1=new JFrame();
                    JTable table=new JTable(new DefaultTableModel());
                    table.setRowHeight(30);
                    DefaultTableModel model=(DefaultTableModel) table.getModel();
                    try {
                        String st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection co;
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                        Statement s=co.createStatement();
                        model.addColumn("Name");
                        model.addColumn("Roll No.");
                        model.addColumn("Reg. No.");
                        model.addColumn("CGPA");
                        model.addColumn("Session");
                        model.addColumn("Gender");
                        model.addColumn("Religion");
                        model.addColumn("Father's Name");
                        model.addColumn("Mother's Name");
                        model.addColumn("Date of Birth");
                        model.addColumn("Address");
                        model.addColumn("Phone Number");
                        model.addColumn("Email");
                        model.addColumn("Blood Group");
                        ResultSet rs=s.executeQuery("Select * from student.studentinfo where Session=s1");
                        while(rs.next())
                        {
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
                            model.addRow(new Object[]{st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14});
                        }
                        TableColumn column1 = table.getColumnModel().getColumn(0);
                        column1.setPreferredWidth(120);
                        TableColumn column2 = table.getColumnModel().getColumn(1);
                        column2.setPreferredWidth(40);
                        TableColumn column3 = table.getColumnModel().getColumn(2);
                        column3.setPreferredWidth(30);
                        TableColumn column4 = table.getColumnModel().getColumn(3);
                        column4.setPreferredWidth(30);
                        TableColumn column5 = table.getColumnModel().getColumn(4);
                        column5.setPreferredWidth(30);
                        TableColumn column6 = table.getColumnModel().getColumn(5);
                        column6.setPreferredWidth(30);
                        TableColumn column7 = table.getColumnModel().getColumn(6);
                        column7.setPreferredWidth(30);
                        TableColumn column8 = table.getColumnModel().getColumn(7);
                        column8.setPreferredWidth(120);
                        TableColumn column9 = table.getColumnModel().getColumn(8);
                        column9.setPreferredWidth(120);
                        TableColumn column10 = table.getColumnModel().getColumn(9);
                        column10.setPreferredWidth(40);
                        TableColumn column11 = table.getColumnModel().getColumn(10);
                        column11.setPreferredWidth(80);
                        TableColumn column12 = table.getColumnModel().getColumn(11);
                        column12.setPreferredWidth(50);
                        TableColumn column13 = table.getColumnModel().getColumn(12);
                        column13.setPreferredWidth(100);
                        TableColumn column14 = table.getColumnModel().getColumn(13);
                        column14.setPreferredWidth(50);
                        frame1.add(new JScrollPane(table));
                        //frame1.setLayout(null);
                        //frame1.setSize(330,200);
                        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setResizable(false);
                        frame1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Search1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if("Individual".equals(s1))
                {
                    String name = JOptionPane.showInputDialog(null,"Enter Registration No.:");
                    try {
                        boolean ok=false;
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
                            t1.setEditable(false);
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
                            t4.setEditable(false);
                            p2.add(t4);
                            //
                            JLabel l5=new JLabel("Session:");
                            l5.setBounds(140, 198, 75, 50);
                            p2.add(l5);
                            JTextField t5=new JTextField();
                            t5.setText(st5);
                            t5.setBounds(200,215,130,20);
                            t5.setEditable(false);
                            p2.add(t5);
                            //
                            JLabel l6=new JLabel("Gender:");
                            l6.setBounds(460, 198, 50, 50);
                            p2.add(l6);
                            JTextField t6=new JTextField();
                            t6.setText(st6);
                            t6.setBounds(510,215,90,20);
                            t6.setEditable(false);
                            p2.add(t6);
                            //
                            JLabel l7=new JLabel("Religion:");
                            l7.setBounds(760, 198, 70, 50);
                            p2.add(l7);
                            JTextField t7=new JTextField();
                            t7.setText(st7);
                            t7.setBounds(820,215,120,20);
                            t7.setEditable(false);
                            p2.add(t7);
                            //
                            JLabel l14=new JLabel("Blood Group:");
                            l14.setBounds(1030, 198, 90, 50);
                            p2.add(l14);
                            JTextField t14=new JTextField();
                            t14.setText(st14);
                            t14.setBounds(1120,215,90,20);
                            t14.setEditable(false);
                            p2.add(t14);
                            //
                            JLabel l8=new JLabel();
                            l8.setText("Father's Name:");
                            l8.setBounds(140, 270, 150, 50);
                            p2.add(l8);
                            JTextField t8=new JTextField();
                            t8.setText(st8);
                            t8.setBounds(250, 281, 290, 30);
                            t8.setEditable(false);
                            p2.add(t8);
                            //
                            JLabel l9=new JLabel();
                            l9.setText("Mother's Name:");
                            l9.setBounds(760, 270, 150, 50);
                            p2.add(l9);
                            JTextField t9=new JTextField();
                            t9.setText(st9);
                            t9.setBounds(875, 281, 290, 30);
                            t9.setEditable(false);
                            p2.add(t9);
                            //
                            JLabel l10=new JLabel();
                            l10.setText("Date of Birth:");
                            l10.setBounds(140, 340, 150, 50);
                            p2.add(l10);
                            JTextField t10=new JTextField();
                            t10.setText(st10);
                            t10.setBounds(235, 351, 200, 30);
                            t10.setEditable(false);
                            p2.add(t10);
                            //
                            JLabel l11=new JLabel();
                            l11.setText("Address:");
                            l11.setBounds(760, 340, 60, 50);
                            p2.add(l11);
                            JTextField t11=new JTextField();
                            t11.setText(st11);
                            t11.setBounds(830, 351, 200, 30);
                            t11.setEditable(false);
                            p2.add(t11);
                            //
                            JLabel l12=new JLabel();
                            l12.setText("Phone Number:");
                            l12.setBounds(140, 410, 800, 50);
                            p2.add(l12);
                            JTextField t12=new JTextField();
                            t12.setText(st12);
                            t12.setBounds(245, 421, 200, 30);
                            t12.setEditable(false);
                            p2.add(t12);
                            //
                            JLabel l13=new JLabel();
                            l13.setText("Email:");
                            l13.setBounds(760, 410, 800, 50);
                            p2.add(l13);
                            JTextField t13=new JTextField();
                            t13.setText(st13);
                            t13.setBounds(800, 421, 200, 30);
                            t13.setEditable(false);
                            p2.add(t13);
                            JButton b4=new JButton("Exit");
                            b4.setBounds(650, 580, 100, 30);
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
                        if(ok==false)
                        {
                            JOptionPane.showMessageDialog(null, "This registration Number is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                        }

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
            }
        });
        frame.add(b1);
        frame.setLayout(null);
        frame.setSize(330,200);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
