$(function() {
    let flag = 0;
    $(".password img").click(function() {
        if (flag == 0){
            $(".password .inp").attr("type","text");
            $(this).attr("src","/asserts/image/open.png");
            flag = 1;
        } else {
            $(".password .inp").attr("type","password");
            $(this).attr("src","/asserts/image/close.png");
            flag = 0;
        }
    });
    $(".repassword img").click(function() {
        if (flag == 0){
            $(".repassword .inp").attr("type","text");
            $(this).attr("src","/asserts/image/open.png");
            flag = 1;
        } else {
            $(".repassword .inp").attr("type","password");
            $(this).attr("src","/asserts/image/close.png");
            flag = 0;
        }
    });

    $(".reg_form #username").blur(function() {
        if ($(this).val().length == 0) {
            $(this).siblings("span").attr("class","hint");
            $(this).siblings("span").children("i").attr("class","hint_icon");
            $(this).siblings("span").children("em").text("请输入6位账号");
        } else {
            if ($(this).val().length != 6) {
                $(this).siblings("span").attr("class","error");
                $(this).siblings("span").children("i").attr("class","error_icon");
                $(this).siblings("span").children("em").text("账号格式不正确，请重新输入!");
            } else {
                $(this).siblings("span").attr("class","success");
                $(this).siblings("span").children("i").attr("class","success_icon");
                $(this).siblings("span").children("em").text("账号格式正确!");
            }
        }
    });

    $(".reg_form #password").blur(function() {
        if ($(this).val().length == 0) {
            $(this).siblings("span").attr("class","hint");
            $(this).siblings("span").children("i").attr("class","hint_icon");
            $(this).siblings("span").children("em").text("请输入6~16位密码!");
        } else {
            if ($(this).val().length < 6 || $(this).val().length > 16) {
                $(this).siblings("span").attr("class","error");
                $(this).siblings("span").children("i").attr("class","error_icon");
                $(this).siblings("span").children("em").text("密码格式不正确，请重新输入!");
            } else {
                $(this).siblings("span").attr("class","success");
                $(this).siblings("span").children("i").attr("class","success_icon");
                $(this).siblings("span").children("em").text("密码格式正确!");
            }
        }
    });

    $(".reg_form #repsw").blur(function() {
        if ($(this).val().length == 0) {
            $(this).siblings("span").attr("class","hint");
            $(this).siblings("span").children("i").attr("class","hint_icon");
            $(this).siblings("span").children("em").text("请再次输入密码!");
        } else {
            if ($(this).val() != $(".reg_form #password").val()) {
                $(this).siblings("span").attr("class","error");
                $(this).siblings("span").children("i").attr("class","error_icon");
                $(this).siblings("span").children("em").text("密码前后不一致，请重新输入!");
            } else {
                $(this).siblings("span").attr("class","success");
                $(this).siblings("span").children("i").attr("class","success_icon");
                $(this).siblings("span").children("em").text("密码确认完毕!");
            }
        }
    });

    $("form").submit(function() {
        if ($("#username").val() == '') {
            alert("账号不能为空!");
        }
         else if ($("#password").val() == '') {
            alert("密码不能为空!");
        } else if ($("#repsw").val() == '') {
            alert("确认密码不能为空!");
        }
    });
});