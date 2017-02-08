<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">


<title>请选择</title>
</head>

<body >
	<s:if test="#session.PERMIT==0">
	
	<div class="container">
		<s:debug/>	
		<div >
			<table class="table table-striped">
				<thead>
					<tr><td>标题</td></tr>
				</thead>
				<tbody >
						<s:iterator value="#themes" id="entry">
							<tr>
								<td><s:property value="key"/></td>
								<td>
									<s:a action="showoption" namespace="/" >
										<s:property value="value"/>
										<s:param name="tid" value="{#entry.key}"/>
									</s:a>
								
								
								</td>
							</tr>
						</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	
	</s:if>
</body>
<script type="text/javascript" src="http://apps.bdimg.com/libs/angular.js/1.2.10/angular.js"></script>

<!--<script type="text/javascript">
var app = angular.module("themeApp", []);
app.controller("themeController", function($scope, $http){
   var url="${pageContext.request.contextPath}/showtheme?time="+new Date().getTime();
    	$http.get(url).success( function(data) {
            $scope.ths = data;
            $scope.fuck=$scope.ths.theme;
           //alert($scope.fuck);
            //alert($scope.ths.theme[0])
         }).error(function() {
            alert("fail...");
        }); 
});
</script>-->


<script type="text/javascript">
	
	
	
	
	
	function go(){
		var ajax=new XMLHttpRequest();
		
		var url="${pageContext.request.contextPath}/showtheme?time="+new Date().getTime();
		var method="GET";
		
		ajax.open(method,url);
		ajax.send(null);
		
		//---------请求中---------
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4&&ajax.status==200){
				var javaJSON=ajax.responseText;
				alert(javaJSON);
				var javascriptJSON=eval("("+javaJSON+")");
				//alert(javascriptJSON);
			
			}
				
		}
		
		
	}


</script>

</html>