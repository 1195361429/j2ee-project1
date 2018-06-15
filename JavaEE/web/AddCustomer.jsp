<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>

<s:set var="privilege"  value="#session.privilege"></s:set>
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
<s:form action="AddCustomer" method="POST">
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o"></i> 添加客户
        </div>
        <div class="panel-body">

                <table>
                    <tr>
                        <td>客户名称：</td><td><s:textfield  name="newSPMC" theme="simple"  CssClass="form-control" id="CustomerName"></s:textfield></td>
                        <td> </td>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>联系电话：</td><td><s:textfield name="newSPBH" theme="simple"  CssClass="form-control" id="TeleNum"></s:textfield></td>
                        <td>  </td>

                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>详细地址：</td><td><s:textfield name="text" cssClass="form-control" theme="simple" id="Address"></s:textfield></td>                        <td>  </td>

                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>描述：</td><td><s:textfield name="description"  cssClass="form-control" theme="simple" id="Brand"></s:textfield></td>
                        <td>  </td>

                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td colspan="3"></td>
                        <td colspan="3"><input type="submit" name="Summit"  CssClass="btn btn-success" value="提交"  />  <input type="button"  name="Cancel" CssClass="btn btn-default" value="取消" CausesValidation="false" onclick="window.location.href='CustomerManage.jsp'"/></td>
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
