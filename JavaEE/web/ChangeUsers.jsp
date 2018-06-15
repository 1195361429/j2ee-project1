<%--
  Created by IntelliJ IDEA.
  User: 李麒麟
  Date: 2018/6/7
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>

<s:set var="privilege" value="privilege"></s:set>
<s:if test="#privilege==1">
    <jsp:include page="Master.jsp" />
</s:if>
<s:elseif test="#privilege==2"><jsp:include page="Master1.jsp" />
</s:elseif>
<s:else>
    <jsp:include page="Master2.jsp" />
</s:else>
<div>
    <br />
</div>
<s:form action="UpdateUsers" method="POST">
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o">添加角色</i> </div>
        <div class="panel-body">

                <table>
                    <tr>
                        <td>帐号：</td><td><s:textfield  name="userID" theme="simple" readonly="true" CssClass="form-control" id="userid" ></s:textfield></td>
                        <td> </td>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>用户名：</td><td><s:textfield name="userName"  theme="simple" cssClass="form-control" id="username"></s:textfield></td>
                        <td>  </td>

                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>权限： </td><td><s:select name="roles" list="{'超级管理员','库存管理员','销售人员'}"  headerValue="%{role}"  multiple="false"/></td>>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>状态： </td><td><s:select name="state" list="{'正常','冻结'}"  headerValue="%{state}"  multiple="false"/></td>>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td colspan="3"></td>
                        <td colspan="3"> <input type="submit" value="更改"/> <input type="button"  name="Cancel" CssClass="btn btn-default" value="取消" CausesValidation="false" onclick="window.location.href='ShowUsers'"/></td>
                        <td colspan="3"></td>
                    </tr>
                </table>
            </s:form>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
