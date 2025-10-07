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

import static project.pkg1.project2.co;
public class home2
{
    public static String s85;
    public static void main(String args[])
    {
        home3();
    }
    public home2(String s)
    {
        s85=s;
    }
    public static void home3()
    {
        JFrame frame=new JFrame();
        JPanel p1=new JPanel(null);
        p1.setBounds(0, 0, 360, 1000);
        p1.setBackground(new Color(50, 135, 168));
        ImageIcon imageicon = new ImageIcon("/Users/jahinjarif/Downloads/Project/university.jpg");
        JLabel l1=new JLabel(imageicon);
        l1.setBounds(-100, -79, 1990, 976);
        /*JLabel l2=new JLabel("Student Information System");
        l2.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 50));
        l2.setForeground(Color.white);
        l2.setBounds(550, 0, 800, 200);
        frame.add(l2);*/
        frame.add(l1);
        ImageIcon imageicon3 = new ImageIcon("/Users/jahinjarif/Downloads/Project/Male-user-search-icon (1).png");
        JButton b2=new JButton(imageicon3);
        b2.setBounds(100, 100, 100, 100);
        b2.setToolTipText("Search Information");
        b2.setBackground(new Color(50, 135, 168));
        b2.setBorderPainted(false);
        p1.add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String st="";
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    Statement s=co.createStatement();
                    ResultSet rs=s.executeQuery("Select Session from student.studentinfo where studentinfo.Registration_Number="+"\""+s85+"\""+";");
                    while(rs.next())
                    {
                        st=rs.getString("Session");
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
                    String stt2="\""+st+"\"";
                    String stt1="Select * from student.studentinfo where studentinfo.Session="+stt2+";";
                    ResultSet rs=s.executeQuery(stt1);
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
        });
        ImageIcon imageicon5 = new ImageIcon("/Users/jahinjarif/Downloads/Project/Exit.png");
        JButton b4=new JButton(imageicon5);
        b4.setBounds(100, 470, 100, 100);
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
        b5.setBounds(100, 300, 100, 100);
        b5.setBackground(new Color(50, 135, 168));
        b5.setToolTipText("NoticeBoard");
        b5.setBorderPainted(false);
        p1.add(b5);
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame=new JFrame();
                login l=new login();
                String st="",st1,st2;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    Statement s=co.createStatement();
                    ResultSet rs=s.executeQuery("Select Session from student.studentinfo where studentinfo.Registration_Number="+"\""+s85+"\""+";");
                    while(rs.next())
                    {
                        st=rs.getString("Session");
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
                frame.getContentPane().setBackground(new Color(50, 168, 137));
                JPanel p=new JPanel(null);
                p.setBackground(new Color(3, 169, 252));
                p.setBounds(0,0,1000, 100);
                Border border = BorderFactory.createLineBorder(Color.BLACK,3);
                p.setBorder(border);
                //p3.setBounds(0,0,1500, 100);
                //p3.setBackground(new Color(3, 169, 252));
                JLabel label=new JLabel("Notice Board");
                label.setBounds(400, 20, 650, 60);
                label.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 50));
                ImageIcon imageicon = new ImageIcon("/Users/jahinjarif/Downloads/Project/JKKNIU.png");
                JLabel label1=new JLabel(imageicon);
                label1.setBounds(0,0,150,100);
                p.add(label);
                p.add(label1);
                JTextArea ta1= new JTextArea();
                JScrollPane p2=new JScrollPane(ta1);
                p2.setBounds(0, 100, 1000, 500);
                p2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    Statement s=co.createStatement();
                    ResultSet rs=s.executeQuery("Select * from student.notice_board where notice_board.Session="+"\""+st+"\""+";");
                    while(rs.next())
                    {
                        st1=rs.getString("date");
                        st2=st1+" "+rs.getString("notice");
                        ta1.append(st2);
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
                System.out.println(s85);

                frame.add(p2);
                frame.add(p);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setTitle("Notice Board");
                frame.setSize(1015, 640);
                frame.setResizable(false);
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
