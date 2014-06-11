package uj.ii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uj.ii.transferobjects.User;

public class UsersDAO {

    private final String URL = "jdbc:mysql://mysql-kos-ii-uj.jelastic.dogado.eu/kos";
    private final String login = "root";
    private final String pass = "pr.dreamteam.pass";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, login, pass);
    }

    public boolean isUserWithLogin(String login) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users WHERE login=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }

    public boolean isUser(User user) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users WHERE login=? AND passMD5=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getPassMD5());
            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }
}
