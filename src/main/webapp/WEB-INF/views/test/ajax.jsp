<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试页面</title>
</head>
<body>
      <button id="btn">ajax测试</button>
      <p id="show"></p>
</body>
<script language="javascript" type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
jQuery(document).on('click', "#btn", function() {
	var data={
		phone:"18017705581",
		password:"123456"
	}
	alert(JSON.stringify(data));
	jQuery.ajax({
		type: 'POST',
		url: "testHandler",
		 data:data,
		 dataType: 'json',
		 success: function(data) { 
			$("#show").text(data.email);
			},
		
	
		});
 });
</script>
</html>