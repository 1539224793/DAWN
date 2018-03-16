<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>五道口大数据引擎考试平台</title>
    <link href="${pageContext.request.contextPath}/pages/css/index.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/pages/css/themes/default/easyui.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/pages/css/themes/icon.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/pages/css/demo.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/pages/script/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/pages/script/jquery.easyui.min.js"></script>
    <script>
        $(function () {
            bindEvent();
        });
        function bindEvent() {
            $(".btn_menu").click(function () {
                var title = $(this).text();
                var url = $(this).attr("url");
                var isSelect = $("#container").tabs('exists', title);
                if (isSelect) {
                    $("#container").tabs('select', title);
                    return;
                }
                $("#container").tabs('add', {
                    title: title,
                    content: CreateContent(url),
                    closable: true
                });
            });
        }

        function CreateContent(url) {
            var strHtml = '<iframe src="' + url + '"  frameborder="0" fit="true" style="height:110%;width:100%;min-height:600px; overflow: auto"></iframe>';
            return strHtml;
        }
    </script>    
</head>
<body>
    <div id="layout_div" class="easyui-layout">
        <div data-options="region:'north',border:false" style="overflow:hidden; height:70px;background:#338FCC;padding:10px;padding-left:30px;">
            <div style="float:left; height:70px;">
                <img src="${pageContext.request.contextPath}/pages/images/logo_1.png" height="60" style="margin-top:-10px;" />
            </div>
            <div style="color:#fff  ;font-size:3em; float:left;margin-left:30px;">
                五道口大数据引擎考试平台
            </div>
            <div style="float:right;height:70px; margin-right:50px;">
                <span>您好，${userinfo.stuName}！</span>
                <span><a href="Javascript:void(0)">注销</a></span>
            </div>
        </div>
        <div data-options="region:'west',split:false,title:'菜单',collapsible:false" style="width:170px;">
            <div id="menu" class="easyui-accordion" fit="true">
                <!-- a标签url属性中填写（/控制器名称/视图名称） -->
                <div title="学生考试" data-options="iconCls:'icon-print'" style=" overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/Kaoshi.jsp">录入考试</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/apply.html">申请快递</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/Replace_list.html">代填记录</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/replace_apply.html">代填申请</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/Audit_list.html">申请审批</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/bill_list.html">账单记录</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/service_list.html">服务统计</a></li>
                    </ul>
                </div>
                <div title="发送快递" data-options="iconCls:'icon-redo'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="">填写单号</a></li>
                    </ul>
                </div>
                <div title="教师分类栏" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/TeacherLu.jsp">正确答案录入</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/LookKao.jsp">查看班级成绩</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/StatisticalResults.jsp">详细统计</a></li>
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/DownScore.jsp">下载班级成绩</a></li>

                    </ul>
                </div>
                <div title="部门管理" data-options="iconCls:'icon-tip'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="${pageContext.request.contextPath}/pages/group_list.html">部门管理</a></li>
                    </ul>
                </div>
                <div title="系统配置" data-options="iconCls:'icon-lock'" style="overflow:auto;padding:10px;">
                    <ul class="easyui-tree">
                        <li><a href="javascript:;" class="btn_menu" url="">系统配置</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div data-options="region:'south',border:false" style="height:50px; font-size:15px; color:#fff; background:#338FCC;padding:10px; text-align:center">
            © 2016 - 快递服务申请系统
        </div>
        <div data-options="region:'center'" style="overflow:hidden">
            <div class="easyui-tabs" fit="true" id="container">
                <div title="主页" style="padding:10px">
                    欢迎使用快递申请服务系统
                    <!--<iframe src="/list.html" scrolling="no" frameborder="0" height="1000" width="1100" style="overflow:hidden; margin-bottom:10px;"></iframe>-->
                </div>
            </div>

        </div>
    </div>
</body>

</html>
