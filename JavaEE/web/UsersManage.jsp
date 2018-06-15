
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>

<s:set var="privilege"  value="privilege"></s:set>
<s:if test="#privilege==1">
    <jsp:include page="Master.jsp" />
</s:if>
<s:elseif test="#privilege==2"><jsp:include page="Master1.jsp" />
</s:elseif>
<s:else>
    <jsp:include page="Master2.jsp" />
</s:else>
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o"></i> 角色管理
            <div class="pull-right">
                <input type="button"  name="Add" value="增加" CssClass="btn btn-default btn-xs"  onclick="window.location.href='AddUsers.jsp'"  />
            </div>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <s:form method="POST" >
                       <table class="table table-bordered table-hover" cellspacing="0" cellpadding="4" id="PlaceHolder1_Supplier" style="color:#333333;border-collapse:collapse;">
                           <tr style="color:White;background-color:#5D7B9D;font-weight:bold;">
                               <th scope="col">    </th>
                               <th scope="col">账户</th>
                               <th scope="col">姓名</th>
                               <th scope="col">权限</th>
                               <th scope="col">状态</th>
                               <th scope="col">操作</th>
                           </tr>
                           <s:iterator  value="list" status="st"  >
                              <tr>
                                <td><s:property value="#st.count"></s:property> </td>

                               <td><s:property  value="uaccount"></s:property></td>
                                  <td><s:property value="uname"></s:property></td>
                               <td><s:property value="urole"></s:property></td>
                               <td><s:property value="ustate"></s:property></td>

                               <td><s:a href="DelUsers.action?account=%{uaccount} " onclick="return confirm('你确定要删除该记录吗？');">删除</s:a>
                                   <s:a href="ChangeUsers.action?account=%{uaccount} " >修改</s:a></td>
                               <tr>
                           </s:iterator>
                       </table>
                        </s:form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="Footer.jsp"/>
</body>
</html>
