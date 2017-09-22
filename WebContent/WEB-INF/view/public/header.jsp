<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>"> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统</title>
    <meta name="description" content="后台管理系统">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="./resources/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="./resources/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="./resources/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="./resources/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="./resources/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="./resources/assets/css/app.css">
    <script src="./resources/assets/js/jquery.min.js"></script>
	<script src="./resources/assets/js/theme.js"></script>
	<script src="./resources/layer/layer.js"></script>
</head>