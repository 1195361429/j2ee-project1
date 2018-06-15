<%--
  Created by IntelliJ IDEA.
  User: 李麒麟
  Date: 2018/6/1
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib  uri="/struts-tags"  prefix="s"%>
<s:set var="privilege" value="privilege" ></s:set>
<s:if test="#privilege==1">
    <jsp:include page="Master.jsp" />
</s:if>
<s:elseif test="#privilege==2"><jsp:include page="Master1.jsp" />
</s:elseif>
<s:else>
    <jsp:include page="Master2.jsp" />
</s:else>
<div class="row">
    <div class="col-lg-12">
        <div class="page-header" style="margin-top:5px">
            <FORM id="12" action="SelectGoods">
            <table>
                <tr>
                    <td>商品名称：</td>
                    <td style="height:28px"><input type="text" name="good"  Height="25px" Width="160px" CssClass="form-control"></input></td>
                    <td style="height:28px">&nbsp; <input type="submit"  value="查询"  name="Select"   Height="25px"   ></input></td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o"></i> 商品管理
            <form action="SelectGood" ></form>
            <div class="pull-right">
                <input type="submit"  name="good" value="增加" CssClass="btn btn-default btn-xs"  onclick="window.location.href='AddGoods.jsp'"  />
            </div></form>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">

                        <s:form method="POST" >
                            <table class="table table-bordered table-hover" cellspacing="0" cellpadding="4" id="PlaceHolder1_Supplier" style="color:#333333;border-collapse:collapse;">
                                <tr style="color:White;background-color:#5D7B9D;font-weight:bold;">
                                    <th scope="col">编号</th>
                                    <th scope="col">名称</th>
                                    <th scope="col">类型</th>
                                    <th scope="col">品牌</th>
                                    <th scope="col">单位</th>
                                    <th scope="col">进价</th>
                                    <th scope="col">售价</th>
                                    <th scope="col">备注</th>
                                    <th scope="col">库存</th>
                                    <th scope="col">操作</th>

                                </tr>
                                <s:iterator  value="list" status="st"  >
                                <tr>
                                    <td><s:property value="gcode"></s:property> </td>
                                    <td><s:property  value="gname"></s:property></td>
                                    <td><s:property value="gtype"></s:property></td>
                                    <td><s:property value="ggrand"></s:property></td>
                                    <td><s:property value="gunit"></s:property></td>
                                    <td><s:property value="ginprice"></s:property></td>
                                    <td><s:property value="goutprice"></s:property></td>
                                    <td><s:property value="gdescription"></s:property></td>
                                    <td><s:property value="gstoreNum"></s:property></td>


                                    <td><s:a href="DelGoods.action?gcode=%{gcode} " onclick="return confirm('你确定要删除该记录吗？');">删除</s:a>
                                        <s:a href="ChangeGoods.action?code=%{gcode} " >修改</s:a></td>
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
