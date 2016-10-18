<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#lastName").change(function(){
			var $this=$(this);
			var value=$this.val();
			value = $.trim(value);
			if(value!=""){
				$this.next("font").remove();
				var url="emp-validateLastName";
				var args={"lastName":value,"time":new Date()};
				$.post(url,args,function(data){
					if(data==1){
						$this.after("<font color='green'>名字可以使用</font>");
					}
					else{
						$this.after("<font color='red'>名字不能使用</font>");
					}			
				});
			}
			else{
				alert("用户名不能为空！");
				$(this).val("");
				$this.focus();
			}
		});
	})
</script>
</head>

<body>
	<h4>Employee Input Page</h4>
	<s:form action="emp-save" method="post">
		<s:if test="id!=null">
			<s:textfield name="lastName" label="LastName" disabled="true"
				id="lastName"></s:textfield>
			<s:textfield name="id" type="hidden"></s:textfield>
		</s:if>
		<s:else>
			<s:textfield name="lastName" label="LastName" id="lastName"></s:textfield>
		</s:else>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:textfield name="birth" label="Birth"></s:textfield>
		<s:select list="#request.departments" listKey="id"
			listValue="departmentName" name="department.id" label="Department"></s:select>
		<s:submit></s:submit>
	</s:form>


</body>
</html>
