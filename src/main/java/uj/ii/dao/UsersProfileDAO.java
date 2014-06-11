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
import uj.ii.transferobjects.UserProfile;

public class UsersProfileDAO {

    private final String URL = "jdbc:mysql://mysql-kos-ii-uj.jelastic.dogado.eu/kos";
    private final String login = "root";
    private final String pass = "pr.dreamteam.pass";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, login, pass);
    }

    public List<UserProfile> viewUsers() {
        List<UserProfile> result = new ArrayList();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users_profile";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String login = rs.getString("user");
                result.add(new UserProfile(login, firstName, lastName));
            }
            //rs.close();

        } catch (SQLException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
        
        return result;
    }

    public UserProfile getUserProfile(String login) {
        UserProfile user = null;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM users_profile WHERE user=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){    
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String office = rs.getString("office");
                String phone = rs.getString("phone");
                String officeHours = rs.getString("office_hours");
                String mainInterests = rs.getString("main_interests");
                String cv = rs.getString("cv");
                user = new UserProfile(login, firstName, lastName, email,
                        address, office, phone, officeHours,
                        mainInterests, cv);
            }
            //rs.close();
        } catch (SQLException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            DbTools.closeQuietly(pst, con);
        }
        return user;
    }
    
    public void updateProfile(UserProfile userProfile) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            String sql = "UPDATE users_profile SET email=?, address=?, office=?, phone=?, office_hours=?,"
                    + " main_interests=?, cv=?, first_name=?, last_name=? WHERE user=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, userProfile.getEmail());
            pst.setString(2, userProfile.getAddress());
            pst.setString(3, userProfile.getOffice());
            pst.setString(4, userProfile.getPhone());
            pst.setString(5, userProfile.getOfficeHours());
            pst.setString(6, userProfile.getMainInterests());
            pst.setString(7, userProfile.getCv());
            pst.setString(8, userProfile.getFirstName());
            pst.setString(9, userProfile.getLastName());
            pst.setString(10, userProfile.getLogin());
            pst.executeUpdate();
            //rs.close();
        } catch (SQLException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
        }  catch (ClassNotFoundException e) {
            Logger.getLogger(UsersProfileDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DbTools.closeQuietly(pst, con);
        }
    }
}
