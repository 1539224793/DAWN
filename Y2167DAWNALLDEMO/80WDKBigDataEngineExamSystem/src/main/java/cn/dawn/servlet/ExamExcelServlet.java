package cn.dawn.servlet;

import cn.dawn.entity.StuAnswerInfo;
import cn.dawn.entity.StuInfo;
import cn.dawn.service.ExamExcelService;
import cn.dawn.service.impl.ExamExcelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Dawn on 2018/1/31.
 */
@WebServlet(name = "ExamExcelServlet")
public class ExamExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ExamExcelService es=new ExamExcelServiceImpl();

        String strhang = request.getParameter("hang");
        String strlie = request.getParameter("lie");
        Object objuserinfo = request.getSession().getAttribute("userinfo");
        if(strhang!=null&&strlie!=null&&objuserinfo!=null){
            int hang = Integer.parseInt(strhang);
            int lie = Integer.parseInt(strlie);
            StuInfo stuInfo=(StuInfo)objuserinfo;
            StuAnswerInfo sai=new StuAnswerInfo();
            sai.setStuName(stuInfo.getStuName());
            sai.setClassId(stuInfo.getClassId());
            sai.setCreateTime(new Date());
            int countAll=hang*lie;
            for (int i=1;i<=countAll;i++) {
                sai.settID(i);
                String a = "";
                String[] tanswer = request.getParameterValues("t"+i);
                if(tanswer!=null) {
                    for (String str : tanswer) {
                        a = a + str;
                    }
                    sai.settAnswer(a);
                    es.insertStuAnswer(sai);
                }
            }

        }else{
            request.getRequestDispatcher("/pages/Kaoshi.jsp").forward(request,response);
        }
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
