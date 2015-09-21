
package lib.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by baron on 15-9-15.
 */
public class AdminDao {
    public String getUser() throws SQLException {
        Statement stmt = null;
        SqlCon sqlcon = new SqlCon();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><td>用户姓名</td><td>手机号</td><td>密码</td><td>权限</td></tr>";
        try {
            con = sqlcon.getCon();
            stmt = con.createStatement();
            String sql = "select * from user" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str +
                        "<tr data_id=\"" + rs.getString("id") + "\"><td username=\""+ rs.getString("username") + "\"/>" + rs.getString("username") + "</td><td phone=\"" + rs.getString("phone") + "\"/>" + rs.getString("phone") +
                        "</td><td password=\"" + rs.getString("password") +"\"/>" + rs.getString("password") + "</td><td role=\"" + rs.getString("role") + "\"/>" + rs.getString("role") + "</td><td>" +
                "<button type=\"button\" class=\"btn btn-default\" data-toggle=\"modal\" data-target=\"#exampleModal\">编辑</button>" +
                        "</td><td><form action=\"../deleteuser\" method=\"post\"><input name=\"dataid\" type=\"hidden\" value=\"" + rs.getString("id") + "\"/><button class=\"btn btn-default\">删除</button></form></td></tr>";
            }
            return str + "</table>";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getApply() throws SQLException {
        Statement stmt = null;
        SqlCon sqlcon = new SqlCon();
        Connection con = null;
        ResultSet rs = null;

        String str = "<table class=\"table table-bordered\">" +
                "<tr><td>用户名</td><td>申请信息</td><td>申请权限</td></tr>";
        try {
            con = sqlcon.getCon();
            stmt = con.createStatement();
            String sql = "select * from applymess" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr><td>" + rs.getString("apply_username") + "</td><td>" +
                 rs.getString("apply_mess") + "</td><td>" + rs.getString("role") + "</td><td><form method=\"post\" action=\"../modify\">" +
                        "<input name=\"dataid\" type=\"hidden\" value=\"" + rs.getString("apply_id") + "\"/>" +
                        "<input type=\"hidden\" name=\"role\" value=\"" + rs.getString("role") + "\"/><button type=\"submit\" class=\"btn btn-primary\">通过</form></td></tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

}