package cn.dawn.servlet;

import cn.dawn.entity.PagerInfo;
import cn.dawn.entity.User;
import cn.dawn.service.IUserService;
import cn.dawn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dawn on 2018/2/25.
 */
@WebServlet(name = "UserServlet",urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService us=new UserServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String oper = request.getParameter("oper");
        System.out.println(oper);
        if(oper!=null) {
            if(oper.equals("login")) {
                String username = request.getParameter("username");

                String password = request.getParameter("password");
                User user = us.loginUser(username, password);
                if(user!=null&&user.getUserName()!=null) {
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("/pages/welcome.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
                }


            }else if (oper.equals("cancel")){
                request.getSession().removeAttribute("user");
                request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
            }else if (oper.equals("updatePassword")){
                User user = (User)request.getSession().getAttribute("user");
                String userCode = user.getUserCode();
                String pwd=user.getUserPassword();
                String oldPassword = request.getParameter("oldPassword");
                String newPassword = request.getParameter("newPassword");
                String reNewPassword = request.getParameter("reNewPassword");
                if (userCode!=null&&oldPassword!=null&&newPassword!=null&&reNewPassword!=null&&pwd.equals(oldPassword)&&newPassword.length()!=0&&newPassword.equals(reNewPassword)){
                    us.updateUserPassword(userCode,reNewPassword);
                    user = us.loginUser(userCode, reNewPassword);
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("/pages/success.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/pages/notsuccess.jsp").forward(request,response);
                }
            }else if (oper.equals("pageUser")){
                String index = request.getParameter("pageindex");
                int index2=index==null?1:Integer.parseInt(index);
                PagerInfo<User> pager = us.findPagerUser(index2, 5);
                request.setAttribute("pager",pager);
                request.getRequestDispatcher("/pages/userList.jsp").forward(request,response);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
