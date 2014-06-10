
package uj.ii.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbTools {

    public static void closeQuietly(Statement s, Connection c) {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbTools.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
