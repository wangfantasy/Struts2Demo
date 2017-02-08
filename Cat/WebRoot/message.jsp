<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="viewport" content="width=device-width,initial-scale=1.0">
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body style="padding:50px;background-color:white;" >
	<s:if test="#session.PERMIT==0">
	您可以对<h6 id="Tnum"><s:property value="#parameters.selectedTid"/></h6>号投票进行留言！
	<h6 id="Unum"><s:property value="#session.USER_ID"/></h6>
		<div class="container" style="padding:30px;height:500px">
			<div ng-app="messageApp" >
				<div ng-controller="messageController">
					<table class="table table-striped table-hover">
						<thead><tr><td>留言</td><td>留言者</td></tr></thead>
						<tbody ng-repeat="mes in mess">
							<tr >
								<td>
									<label ng-bind="mes[0]"></label>
								</td>
								<td>
									<label ng-bind="mes[1]"></label>
								</td>
							</tr>
						</tbody>
					</table>
				
				</div>
			
			</div>
			<div class="form-group" >
				
				<input id="usermassage" name="tomessage" type="text" class="form-control" placeholder="请在此留言"/>
				
				<button class="col-md-offset-5 btn btn-info btn-lg" onclick="godo()">提交留言</button>
				
			</div>
		</div>
	</s:if>
</body>

<script type="text/javascript" src="http://apps.bdimg.com/libs/angular.js/1.2.10/angular.js"></script>


<script type="text/javascript">
	var Tnum=document.getElementById("Tnum").innerHTML;
	//alert(Tnum);
	var tnoo=parseInt(Tnum);
	var app = angular.module("messageApp", []);
	app.controller("messageController", function($scope, $http){
	  var url="${pageContext.request.contextPath}/showmessage?tno="+tnoo+"&time="+new Date().getTime();
	   //var url="#";  
	   $http.get(url).success( function(data) {
	            $scope.ths = data;
	            $scope.mess=$scope.ths.messages;
	           //alert($scope.fuck);
	            //alert($scope.ths.theme[0])
	         }).error(function() {
	            alert("fail...");
	        }); 
	});


function godo(){
	var umessage=document.getElementById("usermassage").value;
	
	//alert(Tnum);
	//var usermes=parseInt(umassage);
	var ajax=new XMLHttpRequest();
	
	var url="${pageContext.request.contextPath}/addmessage?usermessage="+umessage+"&tno="+tnoo+"&time="+new Date().getTime();
	var method="GET";
	
	ajax.open(method,url);
	ajax.send(null);
	
	//---------请求中---------
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&&ajax.status==200){
			var javaJSON=ajax.responseText;
			alert("留言成功！");
			window.location.reload(true);
		
		}
			
	}
	
	
}


</script>

</html>