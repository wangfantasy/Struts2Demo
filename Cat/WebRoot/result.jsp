<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="viewport" content="width=device-width,initial-scale=1.0">
<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
	
	
	<div class="container">
	
		<s:debug/>
		<table class="table table-striped table-hover">
			<thead>
				<tr><td>结果</td><td>票数</td></tr>
			</thead>
			<tbody>
				<s:iterator value="#resdata" id="entry">
					<tr>
						<td>
							<label><s:property value="value[0]"/></label>
						</td>
						<td>
							<h6><s:property value="value[1]"/></h6>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
		<div class="btn-toolbar">
            <div class="col-md-offset-2 btn-group ">
                <button class="btn btn-danger btn-lg">
                                                         选择图表	
                </button>

                <button class="btn btn-danger btn-lg dropdown-toggle" data-toggle="dropdown">
                    <span class="caret" ></span>
                </button>

                <ul class="dropdown-menu" >
                    <li><a onclick="good(0)">柱状图</a></li>
                    <li><a onclick="good(1)">饼状图</a></li>
                    <li class="divider"></li>
                    <li><a onclick="good(2)">区域图</a></li>
                    <li><a onclick="good(3)">点状图</a></li>
                    
                </ul>
            </div>
            <div class="col-md-offset-2">
            	<button id="back" class="btn btn-info btn-lg" onclick="window.history.go(-2)">返回</button>
            </div>
            
        </div>
        <div id="chartContainer" style="height: 300px; width: 100%;"></div>
        <div>
        	<%@ include file="message.jsp"%>
        
        </div>
        
	</div>
	
	
</body>
	<script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script type="text/javascript">	
		var good = function (str) {
			var getType;
			switch (str)
			{
			case 0:
				getType="bar";
			  break;
			case 1:
				getType="pie";
			  break;
			case 2:
				getType="area";
			  break;
			case 3:
				getType="spline";
			  break;
			}
			
			
			var contents=document.getElementsByTagName("label");
			var num=document.getElementsByTagName("h6");
			var numbers=new Array(4);
			numbers[0]=parseInt(num[0].innerHTML);
			numbers[1]=parseInt(num[1].innerHTML);
			numbers[2]=parseInt(num[2].innerHTML);
			numbers[3]=parseInt(num[3].innerHTML);
			var chart = new CanvasJS.Chart("chartContainer", {
				theme: "theme5",//theme1
				title:{
					text: "数据表"              
				},
				animationEnabled: true,   // change to true
				data: [              
				{
					// Change type to "bar", "area", "spline", "pie",etc.
					type: getType,
					dataPoints: [
						{ label: contents[0].innerHTML,  y: numbers[0]},
						{ label: contents[1].innerHTML, y: numbers[1]  },
						{ label: contents[2].innerHTML, y: numbers[2]  },
						{ label: contents[3].innerHTML, y: numbers[3]  },
					]
				}
				]
			});
			chart.render();
		}
	</script>

</html>