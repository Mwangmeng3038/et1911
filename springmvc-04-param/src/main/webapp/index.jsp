<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数传递</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form enctype="application/x-www-form-urlencoded" action="${pageContext.request.contextPath }/complex/array" method="post">
		爱好: 
		<input type="checkbox" name="hobby" value="踢球">踢球
		<input type="checkbox" name="hobby" value="听音乐">听音乐
		<input type="checkbox" name="hobby" value="看书">看书
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="测试数组传参">
	</form>
	
	<form enctype="application/x-www-form-urlencoded" action="${pageContext.request.contextPath }/complex/list" method="post">
		爱好: 
		<input type="checkbox" name="hobbyList" value="踢球">踢球
		<input type="checkbox" name="hobbyList" value="听音乐">听音乐
		<input type="checkbox" name="hobbyList" value="看书">看书
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="测试list传参">
	</form>
	<br>
	<br>
		<button type="testMap">测试Map传参</button>
		<br>
		<br>
		<button onclick="jsonToMap()">测试json转Map传参</button>
		
		<br>
		<br>
		<button onclick="jsonToList()">测试json转List传参</button>
		
		<br>
		<br>
		<button onclick="jsonToBean()">测试json转Bean传参</button>
	
	<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		const path = "${pageContext.request.contextPath}"
		
		$(function(){
			$('#testMap').click(()=>{
				$.ajax({
					url:path+'/complex/map',
					type:'post',
					dataType:'text',
					data:"stuMap['id']=1&stuMap['name']=zhangsan",
					success:function(data){
						alert(data);
					}
				});
			});
		})
		//json转Map
		function jsonToMap(){
			//js对象
			let obj = {id:1,name:"et1911"};
			$.ajax({
				url:path + '/json/jsonToMap',
				type:'post',
				data:JSON.stringify(obj),//将js对象转成json字符串
				dataType:'json',
				contentType:'application/json;charaset=UTF-8',//不写这个默认以form表单的方式去提交
				success:function(data){
					alert(data.msg)
				}
			});	
		}
		
		//json转List
		function jsonToList(){
			let array = [];
			let user = {id: 1, name: "et1911",age: 20}
			array.push(user)
			
			$.ajax({
				url: path + '/json/jsonToList',
				type:'post',
				data: JSON.stringify(array),//将js对象转换成json字符串
				dataType:'json',
				contentType:'application/json;charaset=UTF-8',
				success:function(data){
					alert(data.code + "-" +data.msg)
				}
			})
		}
		
		function jsonToBean(){
			let obj = {id:1, name: "et1911",age:20,hobbyList:['看书','踢球'],stuMap:{id:2,score:200}};
			
			$.ajax({
				url:path + '/json/jsonToBean',
				type:'post',
				data:JSON.stringify(obj),
				dataType:'json',
				contentType:'application/json;charaset=UTF-8',
				success:function(data){
					alert(data.code + ":" + data.msg);
				}
			})
		}
		
	</script>
</body>
</html>