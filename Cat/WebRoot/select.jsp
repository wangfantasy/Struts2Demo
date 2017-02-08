<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="viewport" content="width=device-width,initial-scale=1.0">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>

<title>Insert title here</title>
</head>
<body style="padding:50px;background-color:#cccccc;">
	<s:if test="#session.PERMIT==0">
		<s:if test="#session.IsVoted==0">
			<div class="container" style="padding:30px;background-color:white;height:600px;">
				<s:debug/>
				
				<form action="${pageContext.request.contextPath}/vote" method="post" class="form-horizontal">
					<s:iterator value="#themes" var="var">
		    
		    		<h1><s:property value="#var.value"/></h1>
		  
					
					<s:iterator value="#options" id="entry">
						
						
							
					<div class="form-group">	
						<label class="contol-label"><s:property value="value"/></label>	
						<div class="col-md-offset-5 ">
							<input  type="radio" name="selectedOid" value="<s:property value="key"/>"/>
						</div>
					</div>
					</s:iterator>
						<input type="hidden" name="selectedTid" value="<s:property value="#var.key"/>"/>
					</s:iterator>	
					<div class="form-group">	
						 <div class="col-md-5">
							<button class="btn btn-danger" onclick="this.form.submit()">确认投票</button>
						</div>
						 <div class="col-md-6">
							<button class="btn btn-danger" onclick="window.history.go(-1)">返回</button>	
					</div>	
				</form>
			
			</div>
		</s:if>
		<s:else>
			<div class="container">
				<s:debug/>
				你好！<s:property value="#sesion.PERMIT"/>
				<s:iterator value="#themes" id="entry2">	
					<s:a action="vote" >
						您已投过此票！点击查看结果！
						<s:param name="selectedTid" value="{#entry2.key}"></s:param>
						<s:param name="selectedOid" value="0"></s:param>
					</s:a>
				</s:iterator>	
		</div>
	
		
		</s:else>
	</s:if>	
	<s:else>
		<div class="container">
				<s:debug/>
				你好！<s:property value="#sesion.PERMIT"/>
				<a href="${pageContext.request.contextPath}/result.jsp ">您无此权限！登录可进行投票！</a>
		</div>
	
	</s:else>
</body>
	<script type="text/javascript" src="http://apps.bdimg.com/libs/angular.js/1.2.10/angular.js"></script>
</html>