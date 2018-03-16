<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/2/5
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>统计</title>
    <style type="text/css">
        p{
            text-align: center;
        }
        #table1{
            margin: 0px auto;
        }
    </style>
    <script type="text/javascript" src="/pages/script/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        var classid="";
        function LookScore() {
            classid = $("#classId").val();
            var html=[];
            html[0]="<p><input type='button' value='查看最高分' onclick='lookgao()'><span id='span1'></span></p>";
            html[1]="<p><input type='button' value='查看最低分' onclick='lookdi()'><span id='span2'></span></p>";
            html[2]="<p><input type='button' value='查看平均分' onclick='lookping()'><span id='span3'></span></p>";
            html[3]="<p><input type='button' value='查看每道题正确的人数' onclick='looktrue()'></p>";
            html[4]="<p><table border='1px solid'  id='table1'></table></p>";
            $("#div1").html(html);
        }

        function lookgao() {
            $.ajax({
                url:"/StatisticalResultsServlet",
                type:"post",
                data:{
                    oper:"heightScore",
                    classId:classid
                },
                success:function (date) {
                    $("#span1").html(date)
                }
            });
        }

        function lookdi() {
            $.ajax({
                url:"/StatisticalResultsServlet",
                type:"post",
                data:{
                    oper:"shortScore",
                    classId:classid
                },
                success:function (date) {
                    $("#span2").html(date)
                }
            });
        }

        function lookping() {
            $.ajax({
                url:"/StatisticalResultsServlet",
                type:"post",
                data:{
                    oper:"avg",
                    classId:classid
                },
                success:function (date) {
                    $("#span3").html(date)
                }
            });
        }

        function looktrue() {
            $.ajax({
                url:"/StatisticalResultsServlet",
                type:"post",
                data:{
                    oper:"zhengque",
                    classId:classid
                },
                success:function (date) {
                    $("#table1").html(date)

                    var html="";
                    html+="<tr><td>题号</td><td>正确人数</td></tr>";
                    var rs=eval("("+date+")");
                    $.each(rs,function (i,dom) {
                        html+="<tr><td>"+i+"</td><td>"+dom+"</td></tr>";
                    });
                    $("#table1").html(html)
                }
            });
        }
    </script>
</head>
<body>
    <p style="text-align: center">请输入你要查看的班级编号<input type="text" id="classId" name="classId"><input type="button" value="查看" onclick="LookScore()"></p>
    <div id="div1"></div>
</body>
</html>
