package project.pkg1;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Delete
{
    public static void main(String args[]) throws ClassNotFoundException
    {
        delete1();
    }
    public static void delete1() throws ClassNotFoundException
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
            String st1;
            while(rs.next())
            {
                ok=true;
                st1=rs.getString("Registration_Number");
            }
            if(ok==false)
            {
                JOptionPane.showMessageDialog(null, "This registration Number is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    Connection co1;
                    Class.forName("com.mysql.jdbc.Driver");
                    co1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","09102000");
                    PreparedStatement s1=co1.prepareStatement("Delete from student.studentinfo Where Registration_Number=(?)");
                    s1.setString(1, name);
                    s1.execute();
                    s1.close();
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Delete Successfully!","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
