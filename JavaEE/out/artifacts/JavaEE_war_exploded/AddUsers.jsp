<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>
<link rel="stylesheet" href="img/icon/iconfont.css"/>
<script  src="jquery/jquery-3.3.1.js"></script>
<script src="jquery/md5.js"></script>
<script>
    function Vd() {

        // var validator =document.getElementById("Validator").innerHTML;
        if (document.getElementById("userid").value == '') {
            alert("请输入帐号");
            return false;
        }
        if (document.getElementById("Passwd1").value == '') {

            alert("请输入密码");
            return false;
        }

        if (document.getElementById("Passwd2").value == '') {
            alert("请再次输入密码");
            return false;

        }
        if (document.getElementById("username").value == '') {
            alert("请输入用户名");
            return false;

        }
        var a=document.getElementById("Roles");
        var b=a.selectedIndex;
        var c=a.options[b].value;
        if (c==-1) {
            alert("请选择角色")
            return false;
        }
        else {
            var username = $("#username").val();
            var password = $("#Passwd1").val();

            if (password.trim().length < 32) {
                password = $.md5(username + $.md5(password));
            }


            $("#Passwd1").val(password);
            $("#Passwd2").val(password);
            $("#form2").submit();
            // return true;

        }
    }
</script>

<s:set var="privilege" value="#session.privilege"></s:set>
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
            <i class="fa fa-plus fa-plus-square-o">添加角色</i> </div>
        <div class="panel-body">
    <s:form action="AddUsers" method="POST">
                <table>
                    <tr>
    <td>帐号：</td><td><s:textfield name="userID"  theme="simple" CssClass="form-control" id="userid"></s:textfield></td>
                        <td> </td>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>密码：</td><td><s:password name="passwd1" theme="simple"  CssClass="form-control" id="Passwd1"></s:password></td>
                        <td>  </td>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>确认密码：</td><td><s:password name="passwd2" theme="simple" cssClass="form-control" id="Passwd2"></s:password></td>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>用户名：</td><td><s:textfield name="userName"  theme="simple" cssClass="form-control" id="username"></s:textfield></td>
                        <td>  </td>

                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td>权限： </td><td><s:select name="roles" list="{'超级管理员','库存管理员','销售人员'}" headerKey="-1" headerValue="--请选择--"  multiple="false" id="Roles"/></td>>
                    </tr>
                    <tr><td><br /></td></tr>
                    <tr>
                        <td colspan="3"></td>
                        <td colspan="3"> <input type="submit" value="提交" onclick="return Vd()" /> <input type="button"  name="Cancel" CssClass="btn btn-default" value="取消" CausesValidation="false" onclick="window.location.href='UsersManage.jsp'"/></td>
                        <td colspan="3"></td>
                    </tr>
                </table></s:form>
        </div></div></div>

        </div>
    </div>
</div>
</body>
</html>