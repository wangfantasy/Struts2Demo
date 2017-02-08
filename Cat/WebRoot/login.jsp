<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
  	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
 	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width,initial-scale=1.0 ">
 	
 	
  </head>
  
  <body ng-app="" style="padding:50px;background-color:#cccccc;">
	   	<div class="container" style="padding:30px;background-color:white;height:600px">
	   		<span style="background-color:green">
		   		<form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post">
		   			
		   			<!-- 用户名 -->
		   			<div class="form-group">
		   				<label for="username" class="col-md-2 control-label">用户名:</label>
		   				<div class="col-md-8">
		   					<input id="username" name="username" type="text" class="form-control" placeholder="请输入用户名">
		   				</div>
		   			</div>
		   			<!-- 密码 -->
		   			<div class="form-group">
		   				<label for="password" class="col-md-2 control-label">密    码:</label>
		   				<div class="col-md-8">
		   					<input id="password" name="password" type="password" class="form-control" placeholder="请输入密码">
		   				</div>
		   			</div>
		   			<!-- 按钮 -->
		   			<div class="form-group">
		   				<button id="sub" class="col-md-1 col-md-offset-3 btn btn-danger " onclick="this.form.submit()">提交</button>
		   				
		   				<a href="${pageContext.request.contextPath}/regist.jsp " class="col-md-1 col-md-offset-3 btn btn-danger " role="button">注册</a>
		   			</div>
		   			
		   			
		   		</form>
		   	</span>	
	   		
	   		
	   		
	   	</div>


  </body>
  
  
  	<script type="text/javascript" src="http://apps.bdimg.com/libs/angular.js/1.2.10/angular.js"></script>
	<script type="text/javascript">
		function register(){
			
			
		}
	
	
	</script>
  
  
</html>
