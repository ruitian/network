package lib.servlet;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lib.Dao.Userdao;
import lib.Model.User;
import lib.Dao.SqlCon;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.concurrent.locks.Condition;

/**
 * Created by baron on 15-9-10.
 */
@WebServlet(urlPatterns = "/login", name = "login")
public class Loginservlet extends HttpServlet{

    SqlCon sqlcon = new SqlCon();
    Userdao userdao = new Userdao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        req.setAttribute("phone", phone);
        req.setAttribute("password", password);

        if (phone.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "用户名或密码为空");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        User user = new User(phone, password);
        Connection con = null;

        try {
            con = sqlcon.getCon();
            User currentUser = userdao.login(con, user);
            if (currentUser == null) {
                req.setAttribute("error", "登陆名或密码错误!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
            else {
                //获取session值
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", currentUser);
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                sqlcon.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

