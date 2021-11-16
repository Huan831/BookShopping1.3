$(function (){
    var QeryURL="QueryInfoServlet";
    $.getJSON(QeryURL,{action:"queryUserInfo"},function (data){
        if (data.result)
        {
            //已登录状态
            $("#login-status").css("display","block");
            $("#logout-status").css("display","none");
            $("#login-name").html(data.user.custNo);
        }else
        {
            $("#login-status").css("display","none");
            $("#logout-status").css("display","block");
        }
    })

    $('#logout').click(function (){
        $.get(QeryURL,{action:"resetSession"},function (data){
            if(data.result){
                window.location.href = '/BookShopping1_3_war_exploded/home.html';
            }
        },"json");
    });

});