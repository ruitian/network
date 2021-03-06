package lib.servlet;

import lib.Dao.SqlCon;
import lib.Dao.Userdao;
import lib.Model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-22.
 */

@WebServlet(urlPatterns = "/resume", name = "resume")
public class Addresumeservlet extends HttpServlet{

    SqlCon sqlCon = new SqlCon();
    Userdao userdao = new Userdao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dataid = new String(req.getParameter("dataid").getBytes("ISO-8859-1"), "UTF-8");
        String resume = new String(req.getParameter("resume").getBytes("ISO-8859-1"), "UTF-8");

        Customer user = new Customer();
        Connection con = null;

        user.setDataid(dataid);
        user.setResume(resume);
        HttpSession session = req.getSession();
        session.setAttribute("resume", resume);
        try {
            con = sqlCon.getCon();
            userdao.resume(con, user);

            resp.sendRedirect("customer/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
