<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<body data-type="login" class="theme-black">
    <div class="am-g tpl-g">
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                  	 选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-logo"></div>
                <form class="am-form tpl-form-line-form" id="login">
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="user-name" placeholder="请输入账号" name="username">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="user-name" placeholder="请输入密码" name="password">
                    </div>  
                    <div class="am-form-group">
                        <button type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<jsp:include page="../public/footer.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('.tpl-login-btn').click(function(){
		$.ajax({
			url:'./user/ajaxlogin.do',
			type:'post',
			data:$('#login').serialize(),
			success:function(info){
				if (info.error) {
					layer.msg(info.msg, {icon: 2});
				}else{
					layer.msg(info.msg, {icon: 6});
					setTimeout(function() {
						location.href="./user/main.do";
					}, 2000);
				}
			}
		})
	})
})
</script>
	