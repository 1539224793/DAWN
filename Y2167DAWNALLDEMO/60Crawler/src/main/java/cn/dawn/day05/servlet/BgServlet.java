package cn.dawn.day05.servlet;

import cn.dawn.day05.entity.Cnblog;
import cn.dawn.day05.service.BgService;
import cn.dawn.day05.service.impl.BgServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Dawn on 2018/3/9.
 */
@WebServlet(name = "BgServlet",urlPatterns = {"/BgServlet"})
public class BgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        BgService bs=new BgServiceImpl();
        String oper = request.getParameter("oper");
        if(oper!=null){
            if(oper.equals("find")){
                Integer pageIndex = request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
                List<Cnblog> lists = bs.findPagesCnblog(pageIndex);
                request.getSession().setAttribute("lists",lists);
                String string = JSON.toJSONString(lists);
                PrintWriter pw = response.getWriter();
                pw.write(string);
                pw.flush();
                pw.close();
            }else if(oper.equals("save")){
                Object lists = request.getSession().getAttribute("lists");
                PrintWriter pw = response.getWriter();


                if (lists!=null){
                    List<Cnblog> bglists=(List<Cnblog>)lists;
                    bs.insertPagesCnblog(bglists);
                    pw.write("成功");
                }else {
                    pw.write("失败");
                }
                pw.flush();
                pw.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
