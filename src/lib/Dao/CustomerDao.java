package lib.Dao;

import lib.Model.Relation;
import lib.Model.User;

import java.sql.*;

/**
 * Created by baron on 15-9-22.
 */
public class CustomerDao {
    public User getResume(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;
        User resume = null;
        ResultSet rs = null;
        try {
            String sql = "select resume from user where id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getDataid());
            rs = pst.executeQuery();
            while (rs.next()) {
                resume = new User();
                resume.setResume(rs.getString("resume"));
            }
            return resume;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resume;
    }

    public Relation sendresume(Connection con, Relation rel) throws SQLException{
        PreparedStatement pst = null;
        try {
            String sql = "insert into user_company (customer_id, company_id) values(?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, rel.getCustomer_id());
            pst.setString(2, rel.getCompany_id());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
