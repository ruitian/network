package lib.servlet;

import lib.Dao.CustomerDao;
import lib.Dao.SqlCon;
import lib.Model.Relation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by baron on 15-9-23.
 */

@WebServlet(urlPatterns = "/sendresume", name = "sendresume")
public class Sendservlet extends HttpServlet{
    SqlCon sqlCon = new SqlCon();
    CustomerDao customerDao = new CustomerDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = new String(req.getParameter("user_id").getBytes("ISO-8859-1"), "UTF-8");
        String company_id = new String(req.getParameter("company_id").getBytes("ISO-8859-1"), "UTF-8");

        Connection con = null;
        Relation rel = new Relation();
        rel.setCustomer_id(user_id);
        rel.setCompany_id(company_id);
        try {
            con = sqlCon.getCon();
            customerDao.sendresume(con, rel);
            resp.sendRedirect("customer/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
