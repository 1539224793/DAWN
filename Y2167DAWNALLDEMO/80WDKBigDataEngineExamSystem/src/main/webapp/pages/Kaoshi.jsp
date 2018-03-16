<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/1/30
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试页面</title>
    <script type="text/javascript" src="/pages/script/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        var a=0;
        var b=0;
        $(function(){
            $("#createHL").click(function(){
                var html=[];
                a=parseInt($("#hang").val());
                b=parseInt($("#lie").val());
                for(var i=1;i<=a;i++){
                    html[i-1]+="<tr>";
                    for(var j=1;j<=b;j++){
                        var ti=(i+(j-1)*a);
                        html[i-1]+="&nbsp;&nbsp;&nbsp;<td id='tihao'>"+ti+"</td><td id='xuan'>&nbsp;<input type='checkbox' name='t"+ti+"' value='A'>A&nbsp;<input type='checkbox' name='t"+ti+"' value='B'>B&nbsp;<input type='checkbox' name='t"+ti+"' value='C'>C&nbsp;<input type='checkbox' name='t"+ti+"' value='D'>D"+"</td>";
                    }
                    html[i-1]+="</tr>";
                }
                $("#tableall").html(html);
            });
        });
    </script>
    <link rel="stylesheet" href="/pages/css/KaoshiC.css" type="text/css"></link>
</head>
<body>
<h2 id="tit01">晨曦考试系统</h2>
<p id="zhuyi01">使用规则，请先根据您要做的题目数，输入行列，点击生成，填写完成答案后，输入您名字，点击提交</p>
<form action="/ExamExcelServlet" method="post">

    <table id="tableall" border="2px solid black"></table>
    <p id="I1">
        <input type="text" name="hang" id="hang">行
        <input type="text" name="lie" id="lie">列
        <input type="button" id="createHL" value="生成">
        <%--请输入你的姓名<input type="text" name="name">--%>
        <input type="submit" value="提交成绩">
    </p>
</form>
</body>
</html>
