package cn.dawn.servlet;

import cn.dawn.entity.TrueAnswerInfo;
import cn.dawn.service.TrueAnswerService;
import cn.dawn.service.impl.TrueAnswerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dawn on 2018/2/1.
 */
@WebServlet(name = "TrueAnswerServlet")
public class TrueAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TrueAnswerService ts=new TrueAnswerServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String stranswer = request.getParameter("answer").trim();
        String classId = request.getParameter("classId").trim();
        if(stranswer!=null&&classId!=null&&!stranswer.equals("")) {
            TrueAnswerInfo trueAnswerInfo=new TrueAnswerInfo();
            trueAnswerInfo.setClassId(classId);
            String[] answer = stranswer.split(",");
            ts.deleteTrueAnswer(classId);
            int i=0;
            for (String item:answer) {
                i++;
                trueAnswerInfo.settID(i);
                trueAnswerInfo.settAnswer(item.trim());
                ts.insertTrueAnswer(trueAnswerInfo);

            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
