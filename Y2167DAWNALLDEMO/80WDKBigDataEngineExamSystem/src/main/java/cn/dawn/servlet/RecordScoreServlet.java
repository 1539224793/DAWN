package cn.dawn.servlet;

import cn.dawn.service.RecordScoreService;
import cn.dawn.service.impl.RecordScoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Dawn on 2018/2/2.
 */
@WebServlet(name = "RecordScoreServlet")
public class RecordScoreServlet extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String classId = request.getParameter("classId");
        if(classId!=null){
            RecordScoreService rs=new RecordScoreServiceImpl();
            String path=request.getSession().getServletContext().getRealPath("/pages/upload");
            //System.out.println(path);
            final String returnpath = rs.allMethodCalls(classId, path);

            /* 下载*/
            new Thread(new Runnable() {
                public void run() {
                    List<String> fileallname= Arrays.asList(returnpath);
                    OutputStream os= null;
                    try {
                        os = response.getOutputStream();
                        ZipOutputStream zout = new ZipOutputStream(os);
                        response.setHeader("content-disposition", "attachment;filename="+"down.zip");
                        for(String fileName : fileallname){

                            //String realPath=request.getSession().getServletContext().getRealPath("/upload");
                            String txtPath=fileName;
                                    // realPath.concat("\\").concat(fileName);
                            //显示的名字
                            String xianshi=fileName.substring(fileName.lastIndexOf("/")+1);
                            //System.out.println(xianshi);
                            FileInputStream fis=new FileInputStream(txtPath);
                            zout.putNextEntry(new ZipEntry(URLEncoder.encode(xianshi,"utf-8")));


                            byte[] bytes=new byte[1024];
                            int data;
                            while((data=fis.read(bytes))!=-1){
                                zout.write(bytes,0,data);
                            }
                            fis.close();
                        }
                        zout.close();
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            //System.out.println(path);
            request.getRequestDispatcher("/pages/SuccessPage.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
