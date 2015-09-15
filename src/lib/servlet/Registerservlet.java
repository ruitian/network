package lib.servlet;

import lib.Dao.SqlCon;
import lib.Dao.Userdao;
import lib.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-11.
 */

@WebServlet(urlPatterns = "/register", name = "register")
public class Registerservlet extends HttpServlet{
    SqlCon sqlCon = new SqlCon();
    Userdao userdao = new Userdao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
        String phone = new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");

        User user = new User();
        Connection con = null;

        user.setUsername(username);
        user.setSex(sex);
        user.setPhone(phone);
        user.setPassword(password);

        try {
            con = sqlCon.getCon();
            userdao.register(con, user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
