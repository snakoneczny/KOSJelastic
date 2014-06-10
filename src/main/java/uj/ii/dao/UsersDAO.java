package uj.ii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import uj.ii.transferobjects.User;

public class UsersDAO {

    private final DataSource ds;

    public UsersDAO(DataSource ds) {
        this.ds = ds;
    }

    public boolean isUserWithLogin(String login) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ds.getConnection();
            String sql = "SELECT * FROM users WHERE login=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();

            return rs.next();
        
        } catch (SQLException e) {
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
            con = ds.getConnection();
            String sql = "SELECT * FROM users WHERE login=? AND passMD5=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getPassMD5());
            ResultSet rs = pst.executeQuery();

            return rs.next();
        
        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }
}
