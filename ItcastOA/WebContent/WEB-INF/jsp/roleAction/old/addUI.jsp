<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>

  </head>
  
  <body>
	<s:form action="role_add">
		<s:textfield name="name"></s:textfield>
		<s:textarea name="description"></s:textarea>
		<s:submit value="提交"></s:submit>
	</s:form>
  </body>
</html>
