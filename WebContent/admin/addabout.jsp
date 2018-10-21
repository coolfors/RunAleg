<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8"
	src="uedit/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="uedit/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="uedit/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src=""></script>
<title>${sessionScope.User.userName}</title>
<style type="text/css">
div {
	width: 100%;
}
</style>

<script type="text/javascript">
	{

		var cookie = $.AMUI.utils.cookie;
		var userId = cookie.get("userId");
		if (!userId)
			$("#username").text(userId + "欢迎您！");

	}
</script>
</head>
<body>
	<div>
		<h1>添加帮助</h1>
		<form action="../ArtcleController" method="post">
			内容:
			<script id="editor" type="text/plain"
				style="width:1024px;height:300px;" name="article"></script>
			<br /> 作者:<span id="username">${sessionScope.User.userName}</span> <input type="hidden"
				name="userId" value="${sessionScope.User.userId}"> <br />
			标题:<input type="text" name="title" value="这里填写标题">
			<button>提交问题</button>
		</form>
	</div>
	<script type="text/javascript" charset="utf-8" src="js/editentity.js"></script>
</body>
</body>
</html>