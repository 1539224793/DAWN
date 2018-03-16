<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<div class="pages">
    <c:if test="${pager.totalPage>=1}">
      <a href="${pager.url}&pageindex=1" class="p_pre">首页</a>
        <c:if test="${pager.pageIndex>1}">
            <a href="${pager.url}&pageindex=${pager.pageIndex-1}" class="p_pre">上一页</a>
        </c:if>
        <c:forEach  var="temp" begin="${pager.pageIndex>3?pager.pageIndex-3:1}" end="${pager.totalPage-pager.pageIndex>3?pager.pageIndex+3:pager.totalPage}" step="1">
            <c:if test="${pager.pageIndex==temp}">
                <a href="${pager.url}&pageindex=${temp}" class="cur">${temp}</a>
            </c:if>
            <c:if test="${pager.pageIndex!=temp}">
                <a href="${pager.url}&pageindex=${temp}">${temp}</a>
            </c:if>
        </c:forEach>
      <c:if test="${pager.pageIndex<pager.totalPage}">
         <a href="${pager.url}&pageindex=${pager.pageIndex+1}" class="p_pre">下一页</a>
      </c:if>
      <a href="${pager.url}&pageindex=${pager.totalPage}" class="p_pre">尾页</a>
    </c:if>
    <c:if test="${pager.totalPage==0}">
        暂无记录
    </c:if>
</div>
