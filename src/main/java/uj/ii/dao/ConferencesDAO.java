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
import uj.ii.transferobjects.Conference;

public class ConferencesDAO {

    private final DataSource ds;

    public ConferencesDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Conference> viewConferences(String owner) {
        List<Conference> result = new ArrayList();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ds.getConnection();
            String sql = "SELECT * FROM conferences WHERE owner=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, owner);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                result.add(new Conference(name, description));

            }
            //rs.close();

        } catch (SQLException e) {
            Logger.getLogger(ConferencesDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
        return result;
    }
    
    public void addConference(String name, String description, String owner) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ds.getConnection();
            String sql = "INSERT INTO conferences(name, description, owner) VALUES (?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, owner);
            pst.executeUpdate();
            //rs.close();
        } catch (SQLException e) {
            Logger.getLogger(ConferencesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }
}
