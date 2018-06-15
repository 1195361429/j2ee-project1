<%--
  Created by IntelliJ IDEA.
  User: 李麒麟
  Date: 2018/6/2
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>
<script>
    function Vd(){
        //alert(123);
        // var validator =document.getElementById("Validator").innerHTML;
        if(document.getElementById("newSPMC").value==''){
            alert("请输入商品名称");
            return false;


        }
        if(document.getElementById("newSPBH").value==''){

            alert("请输入商品编号");
            return false;


        }

        if(document.getElementById("BuyPrice").value=='') {
            alert("请输入进货价格");
            return false;

        }
        if(document.getElementById("SalePrice").value=='') {
            alert("请输入预设售价");
            return false;

        }


    }
</script>

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

<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <i class="fa fa-plus fa-plus-square-o"></i> 添加商品
        </div>
        <div class="panel-body">
  <s:form action="AddGood" method="POST">
            <table>
                <tr>
                    <td>商品名称：</td><td><s:textfield  name="name" theme="simple"  CssClass="form-control" id="newSPMC"></s:textfield></td>
                    <td> </td>
                    <td>商品编号：</td><td><s:textfield name="code" theme="simple" CssClass="form-control" id="newSPBH"></s:textfield></td>
                    <td> </td>
                    <td>进价格货：</td><td><s:textfield  name="inprice" theme="simple" CssClass="form-control" id="BuyPrice"></s:textfield></td>
                    <td> </td>
                </tr>
                <tr><td><br /></td></tr>
                <tr>
                    <td>预设售价：</td><td><s:textfield name="outprice" theme="simple"  CssClass="form-control" id="SalePrice"></s:textfield></td>
                    <td>  </td>

                    <td>类别：</td><td><s:textfield name="type" cssClass="form-control" theme="simple" id="Type"></s:textfield></td>
                    <td>  </td>
                    <td>品牌：</td><td><s:textfield name="grand"  cssClass="form-control" theme="simple" id="Brand"></s:textfield></td>

                    <td> </td>
                </tr>
                <tr><td><br /></td></tr>
                <tr>
                    <td>计量单位：</td><td><s:textfield name="unit" theme="simple" cssClass="form-control" id="Unit"></s:textfield></td>
                    <td>  </td>

                </tr>
                <tr><td><br /></td></tr>
                <tr>
                    <td>商品数量：</td><td><s:textfield name="number"  theme="simple" cssClass="form-control" id="Number"></s:textfield></td>
                    <td>  </td>
                    <td>商品描述：</td><td><s:textarea cssClass="form-control" theme="simple" rows="3" cols="30" name="description" id="Descriptions"></s:textarea></td>
                    <td>  </td>
                </tr>
                <tr><td><br /></td></tr>
                <tr>
                    <td colspan="3"></td>
                    <td colspan="3"><input type="submit" name="Summit"  CssClass="btn btn-success" value="提交"  />  <input type="button"  name="Cancel" CssClass="btn btn-default" value="取消" CausesValidation="false" onclick="window.location.href='GoodsManage.jsp'"/></td>
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