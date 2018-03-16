package cn.dawn.servlet;

import cn.dawn.entity.News;
import cn.dawn.entity.Talk;
import cn.dawn.service.INewsService;
import cn.dawn.service.impl.INewsServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Dawn on 2018/3/1.
 */
@WebServlet(name = "NewsServlet",urlPatterns = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        INewsService ns=new INewsServiceImpl();
        String oper = request.getParameter("oper");
        if(oper!=null){
            if(oper.equals("pageNews")){
                String index = request.getParameter("pageIndex");
                Integer index2=index==null?1:Integer.parseInt(index);
                List<News> listsNews = ns.findListNews(index2, 3);
                int count = ns.getCount();
                request.getSession().setAttribute("NewsCount",count);
                PrintWriter pw = response.getWriter();
                String json = JSON.toJSONString(listsNews);
                pw.write(json);
                pw.flush();
                pw.close();

            }else if(oper.equals("pageNewsG")){
                String index = request.getParameter("pageIndex");
                Integer index2=index==null?1:Integer.parseInt(index);
                List<News> listsNews = ns.findListNews(index2, 3);
                int count = ns.getCount();
                request.getSession().setAttribute("NewsCount",count);
                request.setAttribute("lists",listsNews);
                request.getRequestDispatcher("/go.jsp").forward(request,response);
            }else if (oper.equals("dian")){
                String newsid1 = request.getParameter("newsid");
                Integer newsid=Integer.parseInt(newsid1);
                ns.updateNewsContent(newsid);
                News news = ns.findNewsByNewsid(newsid);
                request.setAttribute("news",news);
                request.getRequestDispatcher("/ping.jsp").forward(request,response);
            }else if(oper.equals("insertPing")){
                String content = request.getParameter("content");
                Integer nid = Integer.parseInt(request.getParameter("nid"));
                Talk talk=new Talk();
                talk.setContent(content);
                talk.setNid(nid);
                talk.setTalktime(new Date());
                ns.insertTalks(talk);
                request.getRequestDispatcher("/NewsServlet?oper=pageNewsG").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
