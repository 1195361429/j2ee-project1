<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags"  prefix="s"%>
<link rel="stylesheet" href="img/icon/iconfont.css"/>
<script  src="jquery/jquery-3.3.1.js"></script>
<script src="jquery/md5.js"></script>
<script src="jquery/cookie.js"></script>
<script >
    function submits() {//提交验证，获取得到的表单，如果验证时发现密码是md5值，则直接登录，否则，进行加密，如果remember==1，则存cookie，提交登录表单
        var username = $("#username").val();
        var password = $("#password").val();
        var remember= $("#remember1").is(":checked");
        $.cookie("username", username,{expires:24*7, path:"/"});
        // var remember = document.getElementById("remember").checked;
        if($.cookie("password")!=password){
            if (password.trim().length < 32) {
                password = $.md5(username + $.md5(password));
            }
            if(remember==true) {
                if (confirm("确定要保存密码吗？不推荐在公众场合使用") == true) {
                    $.cookie("password", password, {expires:24*7, path:"/"});
                }
            }
            else{
                $.cookie("password", null);
            }
            $(" #password").val(password);
        }
        $("#form1").submit();

    }


</script>


<html>
<head>
    <title>商店管理系统</title>
    <style type="text/css">
        body{
            margin-bottom:0px;
        }
        .auto-style1 {
            width: 100%;
            height: 541px;
        }
        .auto-style2{
            height: 335px;

        }
        .auto-style3 {
            height: 335px;
            background-color:rgba(255, 255, 255,0.3);
            width: 557px;
        }
        body{
            background-color:lightblue;
        }


        .auto-style4 {
            width: 100%;
            height: 323px;
        }
        .auto-style5 {
            width: 557px;
        }


        .auto-style6 {
            width: 153px;
            height:45px;
            text-align:center
        }
        .auto-style7 {
            height: 103px;
        }
        .auto-style8 {
            width: 557px;
            height: 103px;
        }


        .auto-style9 {
            width: 1413px;
            height: 60px;
        }


        .auto-style10 {
            height: 38px;
            width: 38px;
        }

    </style>
</head>
<body>
<div class="auto-style11">
    <div class="header" style="padding: 0; background-color:rgba(128, 128, 128, 0.3)">
        <h2 style="color: white; line-height: 60px; margin: 0 0 0 30px; padding: 0;" class="auto-style9">商店管理系统</h2>
    </div>
    <form method="POST" action="/Login.action">
        <div>
            <table border="0" class="auto-style1">
                <tr>
                    <td class="auto-style7"></td>
                    <td class="auto-style8"></td>
                    <td class="auto-style7"></td>
                </tr>
                <tr>
                    <td class="auto-style2"></td>
                    <td class="auto-style3">
                        <table class="auto-style4">
                            <tr>
                                <td class="auto-style6"><label class="auto-style10"></label></td>
                                <td colspan="2"><i class="icon Hui-iconfont">&#xe60d;</i><input type="text" ID="username" name="username"  Height="38px" Width="260px"> </input> </td>
                            </tr>
                            <tr>
                                <td class="auto-style6"><label class="auto-style10"></label></td>
                                <td colspan="3"><i class="icon Hui-iconfont">&#xe63f;</i><input type="password"  ID="password" name="password" Height="38" Width="260" TextMode="Password">
                                    <br/><input type="checkbox" name="remember" id="remember1" ><label style="color: #6c757d" value="1">记住密码</label> <s:property value="warning"></s:property>
                                    <br/><br/><br/><button  onclick="submits()"  style="display:flex;justify-content: center;margin-left: 20%; background-color: #1ab7ea">登录</button></td>
                            </tr>
                            <tr>

                                <td colspan="2">

                                </td>
                            </tr>
                        </table>
                    </td>
                    <td class="auto-style2"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td class="auto-style5">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</div>

<script >//登录时验证是否存在cookie,如果存在则直接提交，如果不存在，就执行
var username=$.cookie("username");
var password= $.cookie("password");
if(username!=undefined) {
    $("#username").val(username);
}
if(password!=undefined&&password!="null") {
    $("#password").val(password);

    $("#remember1").prop("checked",true);
}

</script>
</body>
</html>




