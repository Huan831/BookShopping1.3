$(function (){
    var loginURL="LoginServlet";
    $('#email').blur(function (){
        var email=$('#email').val();
        var mailExp=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(mailExp.test(email)==false){
            $("#mailMsg").html("邮箱地址无效");
            $("#mailMsg").css("color","red");
        }else{
            $("#mailMsg").html("邮箱地址有效");
            $("#mailMsg").css("color","green");
        }
    });

    $('#password').blur(function (){
        var password=$('#password').val();
        if (password==""){
            $("#pwdMsg").html("密码不可为空");
            $("#pwdMsg").css("color","red");
            return;
        }
    });

    $('#vercode').blur(function (){
        var ver=$('#vercode').val();
        $.get(loginURL,{vercode:ver,action:"codeComfirm"},function (data){
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
        var email=$('#email').val();
        var password=$('#password').val();
        $.post(loginURL,{email:email,password:password,action: "infoComfirm"},function (data){
            if(data.result){
                alert("yes");
                window.location.href = '/BookShopping1_3_war_exploded/home.html';
            }else{
                alert("noo noo noo");
            }
        },"json");
    });


});