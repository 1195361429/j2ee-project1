<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>

<s:set var="privilege" value="privilege"></s:set>
<s:if test="#privilege==1">
    <jsp:include page="Master.jsp" />
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <div class="panel panel-success">
        <div class="panel-heading">
            登录信息
        </div>
        <div class="panel-body">
            <h2>尊敬的<s:label ID="name" runat="server"></s:label></h2>
            <p>您的登录身份类型为超级管理员，拥有所有管理权限！</p>
        </div>
        <div class="panel-footer">

        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
    </body>
    </html>
</s:if>
<s:elseif test="#privilege==2">
    <jsp:include page="Master1.jsp" />
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <div class="panel panel-success">
        <div class="panel-heading">
            登录信息
        </div>
        <div class="panel-body">
            <h2>尊敬的<s:label ID="name" runat="server"></s:label></h2>
            <p>您的登录身份类型为仓库管理员，拥有仓库管理权限！</p>
        </div>
        <div class="panel-footer">

        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
    </body>
    </html>
</s:elseif>
<s:else>
    <jsp:include page="Master2.jsp" />
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <div class="panel panel-success">
        <div class="panel-heading">
            登录信息
        </div>
        <div class="panel-body">
            <h2>尊敬的<s:label ID="name" runat="server"></s:label></h2>
            <p>您的登录身份类型为销售人员，拥有销售管理权限！</p>
        </div>
        <div class="panel-footer">

        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
    </body>
    </html>
</s:else>



