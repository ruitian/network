package lib.servlet;

import lib.Dao.SqlCon;
import lib.Dao.Userdao;
import lib.Model.Customer;
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
        String username = new String(req.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
        String phone = new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");

        //判断输入数据
        if(username.isEmpty() || phone.isEmpty()) {
            if(username.isEmpty()){
                req.setAttribute("error_name", "姓名不能为空");
            }
            if (phone.isEmpty()) {
                req.setAttribute("error_phone", "手机号不能为空");
            }
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        if(phone.length() != 11) {
            req.setAttribute("error_phone", "手机号为11位");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

        User user = new Customer();
        Connection con = null;

        user.setUsername(username);
        ((Customer)user).setSex(sex);
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
