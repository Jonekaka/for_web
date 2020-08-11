package web.web.servlet;

import web.domain.User;
import web.service.UserService;
import web.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//调用UserService完成查询所有用户
        UserService userServiceimpl = new UserServiceimpl();
        List<User> users = userServiceimpl.findAll();
//        将用户信息封装到request域中
        request.setAttribute("users",users);
        System.out.println("执行了"+users.toString());
//        转发到其他处理页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
