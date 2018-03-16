package cn.dawn.service.impl;

import cn.dawn.dao.RecordScoreDao;
import cn.dawn.dao.impl.RecordScoreDaoImpl;
import cn.dawn.service.RecordScoreService;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dawn on 2018/2/2.
 */
public class RecordScoreServiceImpl implements RecordScoreService {
    public String allMethodCalls(String classId,String path){
        String wr=null;
        try {
            HashMap<String, Integer> rscores = rScoreMethod(classId);
            wr = write(rscores, classId,path);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wr;
    }

    public HashMap<String, Integer> rScoreMethod(String classId) throws SQLException {
        //人员名单与成绩
        HashMap<String, Integer> rscotes=null;
        //创建dao层对象
        RecordScoreDao rdao=new RecordScoreDaoImpl();
        //获取当前班级人数
        List<String> examNames = rdao.findExamNames(classId);
        //获取正确答案
        HashMap<Integer, String> trueAnswers = rdao.findTrueAnswers(classId);
        //当都有的情况下
        if(examNames!=null&&trueAnswers!=null){
            //先创建人员名单与成绩对象
            rscotes=new HashMap<String, Integer>();
            //先拿到本班全部人数。循环遍历出每个人的名字
            for (int i=0;i<examNames.size();i++){
                //得到第i个名字
                String name = examNames.get(i);
                //定义他的成绩，每换一个学员从0开始算一次
                Integer score=0;
                //获取当前学生做的答案
                HashMap<Integer, String> stuAnswers = rdao.findStuAnswers(name);
                //判断是否做了
                if(stuAnswers!=null&&stuAnswers.size()!=0) {
                    //根据老师提供的正确答案的数量进行遍历
                    for (int j = 1; j <= trueAnswers.size(); j++) {
                        //获取第j项的正确答案
                        String za=trueAnswers.get(j);
                        //获取第j项的学生的答案
                        String sa=stuAnswers.get(j);
                        //判断是否为空和答案是否正确（利用短路原则使用equals）
                        if (za!=null&&sa!=null&&za.length()!=0&&sa.length()!=0&&za.equals(sa)){
                            //得分+1
                            score++;
                        }
                    }
                }else{
                    score=null;
                }
                //统计完这个学生成绩后，把这个学生成绩加到人员名单与成绩集合中
                rscotes.put(name,score);
            }
        }
        //返回人员成绩和名单
        return rscotes;
    }

    public String write(HashMap<String, Integer> rscores,String classId,String path) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");

        CellStyle cellStyle = workbook.createCellStyle();
        // 设置这些样式
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        Row row = sheet.createRow(0);
        row.createCell(0).setCellStyle(cellStyle);
        row.createCell(0).setCellValue("姓名");

        row.createCell(1).setCellStyle(cellStyle);
        row.createCell(1).setCellValue("成绩");
        workbook.setSheetName(0, "信息");
        int i=0;


        for (Map.Entry<String, Integer> entry : rscores.entrySet()) {
            i++;
            row = sheet.createRow(i);
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue(entry.getKey());

            row.createCell(1).setCellStyle(cellStyle);
            //操作这个value值，当为空时候，写成缺考
            Integer Mvalue = entry.getValue();
            if(Mvalue==null){
                row.createCell(1).setCellValue("缺考");
            }else {
                row.createCell(1).setCellValue(Mvalue);
            }
        }

        Date date=new Date();
        //System.out.println((date.getMonth()+1)+"月"+date.getDate()+"日"+date.getHours()+"时"+date.getMinutes()+"分");

        String filePath=path+"/"+classId+"B"+(date.getMonth()+1)+"M"+date.getDate()+"D"+date.getHours()+"H"+date.getMinutes()+"m"+".xlsx";
        try {
            File  file = new File(filePath);
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;

    }

    public HashMap<Integer, Integer> errorCount(String classId) throws SQLException {
        //人员名单与成绩
        HashMap<Integer, Integer> rscotes=null;
        //创建dao层对象
        RecordScoreDao rdao=new RecordScoreDaoImpl();
        //获取当前班级人数
        List<String> examNames = rdao.findExamNames(classId);
        //获取正确答案
        HashMap<Integer, String> trueAnswers = rdao.findTrueAnswers(classId);

        //当都有的情况下
        if(examNames!=null&&trueAnswers!=null){
            //先创建人员名单与成绩对象
            rscotes=new HashMap<Integer, Integer>();
            for (int i=1;i<=trueAnswers.size();i++){
                rscotes.put(i,0);
            }
            //先拿到本班全部人数。循环遍历出每个人的名字
            for (int i=0;i<examNames.size();i++){
                //得到第i个名字
                String name = examNames.get(i);
                //定义他的成绩，每换一个学员从0开始算一次
                //Integer score=0;
                //获取当前学生做的答案
                HashMap<Integer, String> stuAnswers = rdao.findStuAnswers(name);
                //判断是否做了
                if(stuAnswers!=null&&stuAnswers.size()!=0) {
                    //根据老师提供的正确答案的数量进行遍历
                    for (int j = 1; j <= trueAnswers.size(); j++) {
                        //获取第j项的正确答案
                        String za=trueAnswers.get(j);
                        //获取第j项的学生的答案
                        String sa=stuAnswers.get(j);
                        //判断是否为空和答案是否正确（利用短路原则使用equals）
                        if (za!=null&&sa!=null&&za.length()!=0&&sa.length()!=0&&za.equals(sa)){
                            //得分+1
                            rscotes.put(j,rscotes.get(j)+1);
                        }
                    }
                }else{
                    //score=null;
                }

            }
        }
        //返回人员成绩和名单
        return rscotes;
    }
}
