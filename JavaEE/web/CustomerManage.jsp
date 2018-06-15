<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>
<form action="SelectCustomer.action">
<s:set var="privilege" value="privilege" ></s:set>
<s:if test="#privilege==1">
    <jsp:include page="Master.jsp" />
</s:if>
<s:elseif test="#role==2"><jsp:include page="Master1.jsp" />
</s:elseif>
<s:else>
    <jsp:include page="Master2.jsp" />
</s:else>
<div class="row">
    <div class="col-lg-12">
        <div class="page-header" style="margin-top:5px">

            <table>
                <tr>
                    <td>客户名称：</td>
                    <td style="height:28px"><input type="text" name="customer" Height="25px" Width="160px" CssClass="form-control"></input></td>
                    <td style="height:28px">&nbsp; <input type="submit"  value="查询"  name="Select"   Height="25px"   ></inputButton>

                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o"></i> 客户管理
            <div class="pull-right">
                <input type="button"  name="Add" value="增加" CssClass="btn btn-default btn-xs"  onclick="window.location.href='AddCustomer.jsp'"  />
            </div>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <s:form method="POST" >
                            <table class="table table-bordered table-hover" cellspacing="0" cellpadding="4" id="PlaceHolder1_Supplier" style="color:#333333;border-collapse:collapse;">
                                <tr style="color:White;background-color:#5D7B9D;font-weight:bold;">
                                    <th scope="col">编号   </th>
                                    <th scope="col">名称</th>
                                    <th scope="col">联系电话</th>
                                    <th scope="col">地址</th>
                                    <th scope="col">备注</th>
                                    <th scope="col">状态</th>
                                    <th scope="col">操作</th>
                                </tr>
                                <s:iterator  value="list" status="st"  >
                                <tr>


                                    <td><s:property  value="ccode"></s:property></td>
                                    <td><s:property value="cname"></s:property></td>
                                    <td><s:property value="clinkphone"></s:property></td>
                                    <td><s:property value="caddress"></s:property></td>
                                    <td><s:property value="cdescription"></s:property> </td>
                                    <td><s:property value="cstate"></s:property></td>
                                    <td><s:a href="DelCustomer.action?ccode=%{ccode} " onclick="return confirm('你确定要删除该记录吗？');">删除</s:a>
                                        <s:a href="ChangeCustomer.action?ccode=%{ccode} " >修改</s:a></td>
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
