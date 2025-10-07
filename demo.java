package project.pkg1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.pkg1.project2.co;
public class demo
{
    public static void main(String args[])
    {
        demo2();
    }
    public static void demo2()
    {
        JFrame frame=new JFrame();
        frame.getContentPane().setBackground(new Color(50, 168, 137));
        JPanel p=new JPanel(null);
        p.setBackground(new Color(3, 169, 252));
        p.setBounds(0,0,1000, 100);
        Border border = BorderFactory.createLineBorder(Color.BLACK,3);
        p.setBorder(border);
        //p3.setBounds(0,0,1500, 100);
        //p3.setBackground(new Color(3, 169, 252));
        JLabel label=new JLabel("Student Information System");
        label.setBounds(200, 20, 650, 60);
        label.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 50));
        ImageIcon imageicon = new ImageIcon("/Users/jahinjarif/Downloads/Project/JKKNIU.png");
        JLabel label1=new JLabel(imageicon);
        label1.setBounds(0,0,150,100);
        p.add(label);
        p.add(label1);
        frame.add(p);
        JLabel l2=new JLabel("Notice");
        l2.setBounds(730, 110, 60, 10);
        frame.add(l2);
        JTextArea ta1= new JTextArea();
        JTextArea t1=new JTextArea();
        t1.setEnabled(false);
        JScrollPane p1=new JScrollPane(t1);
        p1.setBounds(11, 150, 480, 80);
        JScrollPane p2=new JScrollPane(ta1);
        p2.setBounds(500, 130, 500, 500);
        String session[]={"2019-20","2020-21","2021-22","2022-23"};
        JComboBox cb1=new JComboBox(session);
        cb1.setBounds(250,245,90,20);
        frame.add(cb1);
        JLabel l3=new JLabel("Session");
        l3.setBounds(190, 249, 60, 10);
        frame.add(l3);
        ArrayList<String>arrlist = new ArrayList<String>();
        p2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
            Statement s=co.createStatement();
            ResultSet rs=s.executeQuery("Select * from student.notice_board;");
            while(rs.next())
            {
                String st=rs.getString("date");
                String st1=st+" "+rs.getString("notice");
                arrlist.add(st1+"\n");
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
        for(int i=0;i<arrlist.size();i++)
        {
            ta1.append(arrlist.get(i)+"\n");
        }
        JButton b1=new JButton("+ADD");
        b1.setBounds(200, 300, 100, 40);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s1=t1.getText();
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTimeString = currentDateTime.format(formatter);
                String s5=(String)cb1.getSelectedItem();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection co;
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    PreparedStatement s=co.prepareStatement("Insert into student.notice_board(date,notice,session) values (?,?,?);");
                    s.setString(1,formattedDateTimeString);
                    s.setString(2, s1);
                    s.setString(3, s5);
                    s.execute();
                    s.close();
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
                }
                s1=formattedDateTimeString+" "+s1;
                arrlist.add(s1+"\n");
                ta1.append(s1+"\n");
                t1.setText("");
                t1.requestFocus();
            }
        });
        frame.add(p1);
        frame.add(p2);
        frame.add(b1);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Notice Board");
        frame.setSize(1015, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
