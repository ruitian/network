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
            int sum = 0;
            while (rs.next()) {
                sum++;
                str = str + "<tr><td>" + rs.getString("com_name")+ "</td><td>" +
                        rs.getString("com_desc") + "</td></tr>";
            }
            return str + "</table></div>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
