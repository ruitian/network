package lib.Dao;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import lib.Model.Company;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by baron on 15-9-14.
 */
public class CompanyDao {
    public String companylist() throws SQLException {
        Statement stmt = null;
        SqlCon sqlcon = new SqlCon();
        Connection con = null;
        ResultSet rs = null;
        String str = "<div class=\"col-md-8 col-md-offset-2\"><table class=\"table table-bordered\"><tr><td>公司名称</td><td>公司简介</td></tr>";
        try {
            con = sqlcon.getCon();
            stmt = con.createStatement();

            String sql = "select * from company" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr><td>" + rs.getString("com_name")+ "</td><td>" +
                        rs.getString("com_desc") + "</td></tr>";
            }
            return str + "</table></div>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public Company addcompany(Connection con, Company com) throws SQLException {
        PreparedStatement pst = null;

        try {
            String sql = "insert into company (company_id, com_name, com_desc) values (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,com.getDataid());
            pst.setString(2, com.getCom_name());
            pst.setString(3, com.getCom_desc());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCompany() throws SQLException {
        Statement stmt = null;
        SqlCon sqlcon = new SqlCon();
        Connection con = null;
        ResultSet rs = null;
        String str = "<div class=\"col-md-8 col-md-offset-2\"><table class=\"table table-bordered\"><tr><td>公司名称</td><td>公司简介</td></tr>";

        try {
            con = sqlcon.getCon();
            stmt = con.createStatement();
            String sql = "select * from company" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr><td>" + rs.getString("com_name")+ "</td><td>" +
                        rs.getString("com_desc") + "</td><td>" +
                        "<form action=\"../sendresume\" method=\"post\">" +
                         "<input name=\"company_id\" type=\"hidden\" value=\"" + rs.getString("company_id")+"\"/>" +
                        "<input id=\"user_id\" name=\"user_id\" type=\"hidden\" value=\"\">" +
                        "<button class=\"btn btn-default\" type=\"submit\" onclick=\"getid()\">投递</button>"
                        + "</form></td></tr>";
            }
            return str + "</table></div>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
