package lib.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by baron on 15-9-10.
 */
public class SqlCon {
    String url = "jdbc:mysql://localhost:3306/network?"
            + "user=root&password=password&useUnicode=true&characterEncoding=UTF8";
    private String jdbcName="com.mysql.jdbc.Driver";

    public Connection getCon() throws Exception{

        Class.forName(jdbcName);
        Connection con= DriverManager.getConnection(url);

        return con;
    }

    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        SqlCon sqlcon = new SqlCon();

        try {
            sqlcon.getCon();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
