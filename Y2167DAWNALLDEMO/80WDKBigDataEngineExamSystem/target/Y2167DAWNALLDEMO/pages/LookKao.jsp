<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/2/3
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看考试成绩</title>
    <script type="text/javascript" src="/pages/script/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function LookScore(){
            var classid=$("#classId").val();
            $.ajax({
                /*/80WDKBigDateEngineExamSystem*/
                url:"/LookKaoServlet",
                type:"post",
                data:{
                    classId:classid,
                    oper:find
                },
                success:function (date) {
                    var html="";
                    html+="<tr><td>学生名字</td><td>学生成绩</td></tr>";
                    var rs=eval("("+date+")");
                    $.each(rs,function (i,dom) {
                        html+="<tr><td>"+i+"</td><td>"+dom+"</td></tr>";
                    });
                    $("#tableall").html(html);
                }
            })
        }
    </script>
</head>
<body>
    <table id="tableall" border="2px solid black" style="margin: 0px auto"></table>
    <p style="text-align: center">请输入你要查看的班级编号<input type="text" id="classId" name="classId"><input type="button" value="查看" onclick="LookScore()"></p>
</body>
</html>
