package lib.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by baron on 15-9-15.
 */
public class AdminDao {
    public String getUser() throws SQLException {
        Statement stmt = null;
        SqlCon sqlcon = new SqlCon();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\">" +
                "<tr><td>用户姓名</td><td>手机号</td><td>密码</td><td>角色</td></tr>";
        try {
            con = sqlcon.getCon();
            stmt = con.createStatement();
            String sql = "select * from user" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr><td>" + rs.getString("username") + "</td><td>" + rs.getString("phone") +
                        "</td><td>" + rs.getString("password") + "</td><td>" + rs.getString("level") + "</td></tr>";
            }
            return str + "</table>";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
