import java.awt.Dimension;
import java.sql.ResultSetMetaData;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
public class Project1 extends JFrame
{
    Connection co;
    void createconnction()
    {
        try
                {
                Class.forName("com.mysql.jdbc.Driver");
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                }
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex)
                {
                    Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    Project1()
    {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        JLabel l1=new JLabel();
        l1.setText("Name:");
        gc.gridx=0;
        gc.gridy=0;
        gc.gridheight=2;
        getContentPane().add(l1,gc);
        JTextField t1=new JTextField();
        gc.gridx=1;
        gc.gridy=0;
        gc.gridheight=2;
        t1.setColumns(15);
        getContentPane().add(t1,gc);
        t1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t1.transferFocus();
            }
        });
        JLabel l2=new JLabel();
        l2.setText("Father's Name: ");
        gc.gridx=0;
        gc.gridy=2;
        gc.gridheight=2;
        getContentPane().add(l2,gc);
        JTextField t2=new JTextField();
        gc.gridx=1;
        gc.gridy=2;
        t2.setColumns(15);
        gc.gridheight=2;
        getContentPane().add(t2,gc);
        t2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t2.transferFocus();
            }
        });
        JLabel l3=new JLabel();
        l3.setText("Mother's Name: ");
        gc.gridx=0;
        gc.gridy=4;
        gc.gridheight=2;
        getContentPane().add(l3,gc);
        JTextField t3=new JTextField();
        gc.gridx=1;
        gc.gridy=4;
        t3.setColumns(15);
        gc.gridheight=2;
        getContentPane().add(t3,gc);
        t3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t3.transferFocus();
            }
        });
        JLabel l4=new JLabel();
        l4.setText("Address: ");
        gc.gridx=0;
        gc.gridy=6;
        gc.gridheight=2;
        getContentPane().add(l4,gc);
        JTextField t4=new JTextField();
        gc.gridx=1;
        gc.gridy=6;
        t4.setColumns(15);
        gc.gridheight=2;
        getContentPane().add(t4,gc);
        t4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t4.transferFocus();
            }
        });
        JLabel l5=new JLabel();
        l5.setText("Phone Number: ");
        gc.gridx=0;
        gc.gridy=8;
        gc.gridheight=2;
        getContentPane().add(l5,gc);
        JTextField t5=new JTextField();
        gc.gridx=1;
        gc.gridy=8;
        t5.setColumns(15);
        gc.gridheight=2;
        getContentPane().add(t5,gc);
        t5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t5.transferFocus();
            }
        });
        JLabel l6=new JLabel();
        l6.setText("Email: ");
        gc.gridx=0;
        gc.gridy=10;
        gc.gridheight=2;
        getContentPane().add(l6,gc);
        JTextField t6=new JTextField();
        gc.gridx=1;
        gc.gridy=10;
        t6.setColumns(15);
        gc.gridheight=2;
        getContentPane().add(t6,gc);
        t5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                t6.transferFocus();
            }
        });
        JButton b1=new JButton("+ADD");
        gc.gridx=0;
        gc.gridy=12;
        getContentPane().add(b1,gc);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try {
                    createconnction();
                    String s1=t1.getText();
                    String s2=t2.getText();
                    String s3=t3.getText();
                    String s4=t4.getText();
                    String s5=t5.getText();
                    String s6=t6.getText();
                    String s7="Insert into studentinfo values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
                    PreparedStatement s=co.prepareStatement("Insert into studentinfo values (?,?,?,?,?,?)");
                    s.setString(1, s1);
                    s.setString(2, s2);
                    s.setString(3, s3);
                    s.setString(4, s4);
                    s.setString(5, s5);
                    s.setString(6, s6);
                    s.execute();
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton b2=new JButton("SHOW");
        gc.gridx=1;
        gc.gridy=12;
        getContentPane().add(b2,gc);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame1=new JFrame();
                frame1.setTitle("Student Information");
                //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JTable table=new JTable(new DefaultTableModel());
                DefaultTableModel model=(DefaultTableModel) table.getModel();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection co;
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    Statement s=co.createStatement();
                    model.addColumn("Name");
                    model.addColumn("Father's Name");
                    model.addColumn("Mother's Name");
                    model.addColumn("Address");
                    model.addColumn("Phone Number");
                    model.addColumn("Email");
                    ResultSet rs=s.executeQuery("Select * from studentinfo");
                    while(rs.next())
                    {
                        String st=rs.getString("Name");
                        String st1=rs.getString("Father's Name");
                        String st2=rs.getString("Mother's Name");
                        String st3=rs.getString("Address");
                        String st4=rs.getString("Phone Number");
                        String st5=rs.getString("Email");
                        model.addRow(new Object[]{st,st1,st2,st3,st4,st5});
                    }
                    table.setEnabled(false);
                    frame1.add(new JScrollPane(table));
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Project1.class.getName()).log(Level.SEVERE, null, ex);
                }
                //frame1.setLayout(null);
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
                frame1.pack();
            }
        });
    }
    public static void main(String[] args)
    {
        Project1 frame=new Project1();
        frame.setTitle("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.pack();
    }
}