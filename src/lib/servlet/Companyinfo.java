package lib.servlet;

import lib.Dao.CompanyDao;
import lib.Dao.SqlCon;
import lib.Model.Company;

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

@WebServlet(urlPatterns = "/company/companyinfo", name = "companyinfo")
public class Companyinfo extends HttpServlet{
    SqlCon sqlCon = new SqlCon();
    CompanyDao companyDao = new CompanyDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comname = new String(req.getParameter("comname").getBytes("ISO-8859-1"), "UTF-8");
        String dataid = new String(req.getParameter("dataid").getBytes("ISO-8859-1"), "UTF-8");
        String comdesc = new String(req.getParameter("comdesc").getBytes("ISO-8859-1"), "UTF-8");

        Company com = new Company();
        Connection con = null;

        com.setDataid(dataid);
        com.setCom_name(comname);
        com.setCom_desc(comdesc);
        try {
            con = sqlCon.getCon();
            companyDao.addcompany(con, com);
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
