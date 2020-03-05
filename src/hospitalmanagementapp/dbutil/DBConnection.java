/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Himanshu raj
 */
public class DBConnection {
    private static Connection conn;//Static block can only access static data members.
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//PRACTICAL:1521/xe","myhms","student");
           JOptionPane.showMessageDialog(null,"connection done successfully","Connected",JOptionPane.PLAIN_MESSAGE);
             
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Cannot load Driver!"+ex);
            ex.printStackTrace();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Problem in DB!"+e);
            e.printStackTrace();
        }
    }
    public static Connection getConnection() //Static because all data members static.
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {   if(conn!=null)//if not written and connection not established conn=null--if cross is clicked NullPointerException is thrown.
             {
             conn.close();
             JOptionPane.showMessageDialog(null,"connection closed successfully","DisConnected",JOptionPane.PLAIN_MESSAGE);
             }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Problem in closing the Connection!"+e);
            e.printStackTrace();
        }
        
    }
    
}
