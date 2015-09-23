package lib.servlet;

import lib.Dao.SqlCon;
import lib.Dao.Userdao;
import lib.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-21.
 */
@WebServlet(urlPatterns = "/modifyprofile", name = "modifyprofile")

public class modifyprofile extends HttpServlet{
    User currentUser = new User();
    SqlCon sqlCon = new SqlCon();
    Userdao userdao = new Userdao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = new String(req.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
        String dataid = new String(req.getParameter("dataid").getBytes("ISO-8859-1"), "UTF-8");
        String phone = new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");

        User user = new User();
        Connection con = null;

        user.setDataid(dataid);
        user.setUsername(name);
        user.setPassword(password);
        user.setPhone(phone);

        try {
            con = sqlCon.getCon();
            userdao.modifyprofile(con, user);
            req.setAttribute("message", "以成功修改,请重新登陆!");
            req.getRequestDispatcher("customer/index.jsp").forward(req, resp);
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
