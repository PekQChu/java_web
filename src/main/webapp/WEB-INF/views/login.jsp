<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
		<!--引入头部  -->

<%@ include file="templates/header.jsp"%>

<style type="text/css">
    html,
    body {
        height: 100%;
    }

    body>.layui-main {
        height: 100%;
        width: 100%;
    }
</style>

<body>
    <div class="layui-main">

<div class="x-top x-bg">
    <div class="layui-main"><a href="#"><strong class="x-text-white">物联网云平台</strong></a></div>
</div>

<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
<div>
  <p>登陆页面</p>
  <table>
    <tr>
      <td>用户手机</td>
      <td><input id="phone1" type="text"></td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input id="password1" type="password"></td>
    </tr>
    <tr>
      <td><button id="login_sub" type="submit">提交</button></td>
      
    </tr>
  </table>
</div>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
</div>
</body>
 <script language="javascript" type="text/javascript" src="js/login.js"></script>
</html>