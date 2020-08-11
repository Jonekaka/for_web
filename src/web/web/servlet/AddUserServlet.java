package web.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.domain.User;
import web.service.UserService;
import web.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获得编码
        request.setCharacterEncoding("utf-8");
//        获得所有数据
        Map<String, String[]> parameterMap = request.getParameterMap();
//        封装成对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        调用service存储
        UserService userServiceimpl = new UserServiceimpl();
        userServiceimpl.addUser(user);
//        刷新展示界面数据
//        没有共享数据可以直接重定向
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
