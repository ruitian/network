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
 * Created by baron on 15-9-15.
 */
@WebServlet(urlPatterns = "/admin/edit", name = "edit")
public class Changeservlet extends HttpServlet{

    SqlCon sqlCon = new SqlCon();
    Userdao userdao = new Userdao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dataid = new String(req.getParameter("dataid").getBytes("ISO-8859-1"), "UTF-8");
        String username = new String(req.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        String phone = new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
        String role = new String(req.getParameter("role").getBytes("ISO-8859-1"), "UTF-8");
        System.out.print(dataid);

        User user = new User();
        Connection con = null;

        user.setUsername(username);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(role);
        user.setDataid(dataid);

        try {
            con = sqlCon.getCon();
            userdao.edit(con, user);
            resp.sendRedirect("/admin/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}