package lib.Dao;

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
}
