package lib.Dao;

import lib.Model.Apply;
import lib.Model.Customer;
import lib.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;// 通过PreparedStatement进行数据库的增删改查
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by baron on 15-9-10.
 */
public class Userdao {
    public User login(Connection con, User user) throws SQLException {
        User resultUser = null;
        PreparedStatement pst = null;
        try {
            String sql = "select * from user where phone=? and password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getPhone());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery(); //向下遍历

            if (rs.next()) {
                resultUser = new Customer();
                resultUser.setDataid(rs.getString("id"));
                resultUser.setUsername(rs.getString("username"));
                resultUser.setPhone(rs.getString("phone"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setRole(rs.getString("role"));
            }
            return resultUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultUser;
    }

    public User register(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;

        try {
            String sql = "insert into user (username, phone, password) values (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPhone());
            pst.setString(3, user.getPassword());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User edit(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "update user set username=?, phone=?, password=?, role=? where id=?" + ";";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPhone());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getDataid());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Apply apply(Connection con, Apply user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "insert into applymess (apply_id, apply_username, apply_mess, role) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getDataid());
            pst.setString(2, user.getApply_username());
            pst.setString(3, user.getApply_mess());
            pst.setString(4, user.getRole());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Apply deleteapply(Connection con, Apply user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "delete from applymess where apply_id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getDataid());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User modify(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "update user set role = ? where id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getRole());
            pst.setString(2, user.getDataid());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User deleteuser(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "delete from user where id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getDataid());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User modifyprofile(Connection con, User user) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "update user set username = ?, password = ? where id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getDataid());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
