<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="viewport" content="width=device-width,initial-scale=1.0">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>    
	<div class="container">
          <div id="regists">
          <form action="${pageContext.request.contextPath}/user" class="form-horizontal"  method="post">
    		<div class="form-group">
    			<label for="username" class="col-md-2 control-label">用户名:</label>
    			<div class="col-md-8">
    				<input type="text" name="username" id="username"  />
    			</div>	
    		</div>      
    		<div class="form-group">
    			<label for="password" class="col-md-2 control-label">密码:</label>
    			<div class="col-md-8">
    				<input type="password" name="password" id="password" />
    			</div>	
    		</div> 
    		<div class="form-group">
    			<label for="sex" class="col-md-2 control-label">性别:</label>
    			<div class="col-md-8">
    				<input type="text" name="sex" id="sex"  />
    			</div>	
    		</div>         
              <div class="form-group">
    			<label for="email" class="col-md-2 control-label">邮箱:</label>
    			<div class="col-md-8">
    				<input type="text" name="email" id="email"  />
    			</div>	
    		</div>  
              
        
                <div class="form-group">
          			<button  class="col-md-1 col-md-offset-3 btn btn-danger" onclick="this.form.submit()">确认</button>
          		</div>
           </form>
          </div>
    </div>    
</body>
</html>