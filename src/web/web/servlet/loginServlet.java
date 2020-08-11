package web.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.domain.User;
import web.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
//        获取数据
//        先获得验证码，校验
//        获得用户传过来的验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
//        获得服务器生成的验证码
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
//        移除验证码，一次请求一次刷新
        session.removeAttribute("CHECKCODE_SERVER");
//        用户可能没填验证码，空没有equal属性
        //        验证码校验
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
//            验证码不相等
            request.setAttribute("login_msg","验证码错误");
//            重新刷新本页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
//            后面不再执行
        }
//        如果验证码校验成功
        //        判断登录是否成功
//        将请求数据引入map中
        Map<String, String[]> parameterMap = request.getParameterMap();
//        map封装为user对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        调用service封装modol模块
        UserServiceimpl userServiceimpl = new UserServiceimpl();
//        调用其中的登录方法
        User login = userServiceimpl.login(user);
//        判断用户是否验证密码与账户成功
        if(login!=null){
//            如果登录成功就将结果放入session
            session.setAttribute("user",login);
//            跳转到索引页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else{
//            登录失败
            request.setAttribute("login_msg","用户名或密码名错误");
//            返回登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
