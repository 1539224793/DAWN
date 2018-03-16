package cn.dawn.servlet;

import cn.dawn.service.RecordScoreService;
import cn.dawn.service.impl.RecordScoreServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Dawn on 2018/2/3.
 */
@WebServlet(name = "LookKaoServlet")
public class LookKaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String classId = request.getParameter("classId");
        if(classId!=null) {
            RecordScoreService rs = new RecordScoreServiceImpl();
            try {
                HashMap<String, Integer> stuScore = rs.rScoreMethod(classId);
                String json = JSON.toJSONString(stuScore);
                PrintWriter pw = response.getWriter();
                pw.write(json);
                pw.flush();
                pw.close();
                //System.out.println(json);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
