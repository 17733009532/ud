<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html >
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>

<body>
<div style="text-align: center;">
	<form id="addCarousel" action="${pageContext.request.contextPath}/carousel/uploading" class="easyui-form" method="post" enctype="multipart/form-data">
		<div style="margin-top: 70px;">
			<label for="title">名称:</label>
			<input  type="text" name="title" id="title" />
		</div>

		<div style="margin-top: 10px;">
			<label for="title">上传轮播图:</label>
			<input name="addFile" type="file" style="width:140px">
		</div>

		<div style="margin-top: 10px;">
			ON:<input type='radio' name='status' value='ON' checked/>
			OFF:<input type='radio' name='status' value='OFF' />
		</div>
		<input type="submit" value="提交"/>
	</form>
</div>
</body>

</html>


