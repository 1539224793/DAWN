package cn.dawn.servlet;

import cn.dawn.entity.StuInfo;
import cn.dawn.service.StuInfoService;
import cn.dawn.service.impl.StuInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Dawn on 2018/1/30.
 */
public class StuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        StuInfoService ss=new StuInfoServiceImpl();

        String stuName = request.getParameter("stuName");
        String stuPassword = request.getParameter("stuPassword");

        StuInfo stuInfo=new StuInfo();
        stuInfo.setStuName(stuName);
        stuInfo.setStuPassword(stuPassword);

        try {
            StuInfo logininfo = ss.loginFindStuInfo(stuInfo);
            if(logininfo!=null){
                request.getSession().setAttribute("userinfo",logininfo);
                request.getRequestDispatcher("/pages/Index.jsp").forward(request,response);
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
