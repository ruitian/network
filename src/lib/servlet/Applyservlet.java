package lib.servlet;

import lib.Dao.SqlCon;
import lib.Dao.Userdao;
import lib.Model.Apply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-16.
 */

@WebServlet(urlPatterns = "/apply", name = "apply")
public class Applyservlet extends HttpServlet {
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
        String role = new String(req.getParameter("role").getBytes("ISO-8859-1"), "UTF-8");
        String reason = new String(req.getParameter("reason").getBytes("ISO-8859-1"), "UTF-8");

        Apply apply = new Apply();
        Connection con = null;

        apply.setDataid(dataid);
        apply.setApply_username(username);
        apply.setApply_mess(reason);
        apply.setRole(role);


        try {
            con = sqlCon.getCon();
            userdao.apply(con, apply);
            req.setAttribute("message", "申请成功!");
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
