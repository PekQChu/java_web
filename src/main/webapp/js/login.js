/**
 * login.js
 */
jQuery(document).on('click', "#login_sub", function() {
	var data={
		phone1:"18017705581",
		password1:"123456"
	}
	alert(JSON.stringify(data));
	jQuery.ajax({
		type: 'POST',
		url: "loginHandler",
		 data:data,
		 dataType: 'json',
		 //contentType:'application/json;charset=utf-8',
		 success: function(json) { 
			 alert(json);
			//if(json.status==-1){
				//alert("失败");
			//	}
				//else{
				//	alert("登陆成功");
			//	}
			},
		complete:function(){
			alert("怎么了");
		}	
	
		});
 });