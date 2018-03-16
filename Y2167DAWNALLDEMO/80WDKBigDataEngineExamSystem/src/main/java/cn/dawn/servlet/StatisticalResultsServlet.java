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
import java.util.Map;

/**
 * Created by Dawn on 2018/2/5.
 */
@WebServlet(name = "StatisticalResultsServlet")
public class StatisticalResultsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String oper=request.getParameter("oper");
        String classId=request.getParameter("classId");
        RecordScoreService rs=new RecordScoreServiceImpl();


        if(oper!=null&&classId!=null){

            if(oper.equals("heightScore")){
                try {
                    HashMap<String, Integer> rScore = rs.rScoreMethod(classId);
                    Integer heightS=0;
                    String heightN="没有人";
                    for (Map.Entry<String, Integer> entry : rScore.entrySet()) {
                        if (entry.getValue()!=null){
                            if(entry.getValue()>heightS){
                                heightS=entry.getValue();
                                heightN=entry.getKey();
                            }
                        }
                    }
                    String str=heightN+"获得最高分，他的分值是"+heightS;
                    PrintWriter pw = response.getWriter();
                    pw.write(str);
                    pw.flush();
                    pw.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if (oper.equals("shortScore")){
                try {
                    HashMap<String, Integer> rScore = rs.rScoreMethod(classId);
                    Integer shortS=Integer.MAX_VALUE;
                    String shortN="全部";
                    for (Map.Entry<String, Integer> entry : rScore.entrySet()) {
                        if (entry.getValue()!=null){
                            if(entry.getValue()<shortS){
                                shortS=entry.getValue();
                                shortN=entry.getKey();
                            }
                        }
                    }
                    String str="";
                    if (shortS==Integer.MAX_VALUE){
                        str="没有人参加考试，或者全部为0分";
                    }else{
                        str=shortN+"获得最低分，他的分值是"+shortS+"分";
                    }

                    PrintWriter pw = response.getWriter();
                    pw.write(str);
                    pw.flush();
                    pw.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if(oper.equals("avg")){
                try {
                    HashMap<String, Integer> rScore = rs.rScoreMethod(classId);
                    Integer count=0;
                    Integer sum=0;
                    Double avgScore=0.0;

                    for (Map.Entry<String, Integer> entry : rScore.entrySet()) {
                        if (entry.getValue()!=null){
                            count++;
                            sum+=entry.getValue();
                        }
                    }
                    avgScore=1.0*sum/count;
                    String str="有"+count+"名学生参加考试，平均分为"+avgScore+"分";


                    PrintWriter pw = response.getWriter();
                    pw.write(str);
                    pw.flush();
                    pw.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if(oper.equals("zhengque")){
                try {
                    HashMap<Integer, Integer> errorCountJILU = rs.errorCount(classId);
                    String json = JSON.toJSONString(errorCountJILU);
                    PrintWriter pw = response.getWriter();
                    pw.write(json);
                    pw.flush();
                    pw.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
