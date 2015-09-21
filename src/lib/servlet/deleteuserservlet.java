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
 * Created by baron on 15-9-21.
 */
@WebServlet(urlPatterns = "/deleteuser", name = "deleteuser")
public class deleteuserservlet extends HttpServlet{
    SqlCon sqlCon = new SqlCon();
    Userdao userdao = new Userdao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dataid = new String(req.getParameter("dataid").getBytes("ISO-8859-1"), "UTF-8");

        User user = new User();
        Connection con = null;

        user.setDataid(dataid);

        try {
            con = sqlCon.getCon();
            userdao.deleteuser(con, user);
            resp.sendRedirect("admin/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
