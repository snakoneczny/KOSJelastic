package uj.ii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uj.ii.transferobjects.Publication;

public class PublicationsDAO {

    private final String URL = "jdbc:mysql://mysql-kos-ii-uj.jelastic.dogado.eu/kos";
    private final String login = "root";
    private final String pass = "pr.dreamteam.pass";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, login, pass);
    }

    public List<Publication> viewPublications(String owner) {
        List<Publication> result = new ArrayList();
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM publications WHERE owner=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, owner);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");

                result.add(new Publication(name, description));

            }
            //rs.close();

        } catch (SQLException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
        return result;
    }

    public List<Publication> viewAllPublications() {
        List<Publication> result = new ArrayList();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "SELECT P.name, P.description, U.first_name, U.last_name FROM publications AS P"
                    + " JOIN users_profile AS U ON P.owner = U.user";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                result.add(new Publication(name, description, firstName, lastName));

            }
            //rs.close();

        } catch (SQLException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
        return result;
    }

    public void addPublication(String name, String description, String owner) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "INSERT INTO publications (name, description, owner) VALUES (?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, owner);
            pst.executeUpdate();
            //rs.close();
        } catch (SQLException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(PublicationsDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }
}
