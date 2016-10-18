<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- ${pageContext.request.contextPath}/scripts/jquery.js -->
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function(){
			var lastName=$(this).next(":hidden").val();
			var flag=confirm("确定要删除"+lastName+"的信息吗？");
			if(flag){
				var $tr=$(this).parent().parent();
				var url=this.href;
				var args={"time":new Date()};
				$.post(url,args,function(data){
					if(data==1){
						alert("删除成功");
						$tr.remove();
					}
					else{
						alert("删除失败");
					}
				});
			}
			return false;

		});
	})
</script>

</head>

<body>
	<h4>Emplist Page!</h4>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Email</td>
			<td>Birth</td>
			<td>CreateTime</td>
			<td>DEPT</td>
		</tr>
		<s:iterator value="#attr.employees">
			<tr>
				<td>${id }</td>
				<td>${lastName }</td>
				<td>${email }</td>
				<td>
					<s:date name="birth" format="yyyy-MM-dd"/>
				</td>
				<td>
					<s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
				</td>
				<td>${department.departmentName }</td>
				<td>
					<a href="emp-delete?id=${id }" class="delete">Delete</a>
					<input type="hidden" value="${lastName }">
				</td>
				<td>
					<a href="emp-input?id=${id }">Edit</a>
				</td>
			</tr>
		</s:iterator>
	</table>



</body>
</html>
