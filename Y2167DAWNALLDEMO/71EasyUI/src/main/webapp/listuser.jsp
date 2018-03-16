
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            /*$.messager.alert('My Title','Here is a question message!','question');*/
        });

        function disable() {
            $('#dd').datebox('disable');
        }
        function enable() {
            $('#dd').datebox('enable');
        }
        /*
         将Date/String类型,解析为String类型.
         传入String类型,则先解析为Date类型
         不正确的Date,返回 ''
         如果时间部分为0,则忽略,只返回日期部分.
         */
        function formatDate(v) {
            if (v instanceof Date) {
                var y = v.getFullYear();
                var m = v.getMonth() + 1;
                var d = v.getDate();
                var h = v.getHours();
                var i = v.getMinutes();
                var s = v.getSeconds();
                var ms = v.getMilliseconds();
                if (ms > 0)
                    return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' +
                        s
                        + '.' + ms;
                if (h > 0 || i > 0 || s > 0)
                    return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' +
                        s;
                return y + '-' + m + '-' + d;
            }
            return '';
        }

        $( function() {
            $('#dd').datebox( {
                currentText : '今天',
                closeText : '关闭',
                disabled : false,
                required : true,
                missingMessage : '必填',
                formatter : formatDate
            });
        });
    </script>
    </head>


<body>
<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
       data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'itemid',width:80">用户编号</th>
        <th data-options="field:'productid',width:100">产品</th>
        <th data-options="field:'listprice',width:80,align:'right'">价格</th>
        <th data-options="field:'unitcost',width:80,align:'right'">单位价格</th>
        <th data-options="field:'attr1',width:250">操作</th>
        <th data-options="field:'status',width:60,align:'center'">状态</th>
    </tr>
    </thead>
</table>

<h1>DateBox</h1>
<div style="margin-bottom: 10px;">
    <a href="#" onclick=disable();>disable</a>
    <a href="#" onclick=enable();>enable</a>
</div>
<input id="dd"></input>
</body>
</html>
