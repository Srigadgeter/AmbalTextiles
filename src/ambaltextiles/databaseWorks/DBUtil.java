/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambaltextiles.databaseWorks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sridhar
 */
public class DBUtil {

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sridhar", "srigadgeter");        
        return cn;

    }
}
