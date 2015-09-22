package lib.servlet;

import lib.Dao.CustomerDao;
import lib.Dao.SqlCon;
import lib.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-22.
 */


@WebServlet(urlPatterns = "/updateresume", name = "updateresume")
public class updateresume extends HttpServlet{
    SqlCon sqlCon = new SqlCon();
    CustomerDao userdao = new CustomerDao();
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
            User resume = userdao.getResume(con, user);
            System.out.print(resume);
            req.setAttribute("resume", resume);
            req.getRequestDispatcher("customer/index.jsp").forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
