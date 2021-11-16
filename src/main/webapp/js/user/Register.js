$(function (){

    var regURL="RegisterServlet";
    $('#username').blur(function (){
        var username=$('#username').val();
        var nameExp=/^[a-zA-Z0-9_]{4,15}$/;
        if(nameExp.test(username)==false){
            $("#nameMsg").html("用户名不合法")
            $("#nameMsg").css("color","red");
            return;
        }else{
            $.get(regURL,{username:username,action: "nameConfirm"},function (data){
                if(data.result){
                    $("#nameMsg").html("用户名已被占用")
                    $("#nameMsg").css("color","red");
                }else{
                    $("#nameMsg").html("用户名可用")
                    $("#nameMsg").css("color","green");
                }
            },"json");
        }
    });
    $('#password').blur(function (){
        var password=$('#password').val();
        var pwdExp=/^[A-Za-z0-9]{4,40}$/;
        if (pwdExp.test(password)==false){
            $("#pwdMsg").html("密码不合法");
            $("#pwdMsg").css("color","red");
            return;
        }else{
            $("#pwdMsg").html("密码可用");
            $("#pwdMsg").css("color","green");
            return ;
        }
    });
    $('#email').blur(function (){
        var email=$('#email').val();
        var mailExp=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(mailExp.test(email)==false){
            $("#mailMsg").html("邮箱地址无效");
            $("#mailMsg").css("color","red");

        }else{
            $.get(regURL,{email:email,action:"emailConfirm"},function (data){
                if(data.result){
                    $("#mailMsg").html("邮箱已被占用");
                    $("#mailMsg").css("color","red");
                }else{
                    $("#mailMsg").html("邮箱地址有效");
                    $("#mailMsg").css("color","green");
                }
            },"json");

        }
    });
    $('#repassword').blur(function (){
        var password=$('#password').val();
        var repassword=$('#repassword').val();
        if(Object.is(password,repassword)){
            $("#repwdMsg").html("两次密码输入一致");
            $("#repwdMsg").css("color","green");
        }else{
            $("#repwdMsg").html("请重新输入");
            $("#repwdMsg").css("color","red");
        }
    });
    $('#vercode').blur(function (){
        var ver=$('#vercode').val();
        $.get(regURL,{vercode:ver,action:"codeComfirm"},function (data){
            if (data.result){
                $('#verMsg').html("验证码正确");
                $('#verMsg').css("color","green");
            }else{
                $('#verMsg').html("验证码错误");
                $('#verMsg').css("color","red");
            }
        },"json");
    });
    $('#loginForm').click(function (){
        var username=$('#username').val();
        var password=$('#password').val();
        var email=$('#email').val();
        $.post(regURL,{username:username,password:password,email:email,action:"insertInfo"},function (data){
            if(data.result){
                alert("success")
            }else{
                alert("fail")
            }
        },"json");
    });

});