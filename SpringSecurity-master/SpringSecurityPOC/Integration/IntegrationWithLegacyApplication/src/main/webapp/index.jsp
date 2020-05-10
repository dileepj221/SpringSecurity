<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
    Username: <b><sec:authentication property="principal.username"/></b><br/>
    <br/>
		<a href="admin">Click to enter admin area</a><br/>
    <br/>
    <form action="logout" method="post">
      <input type="submit" value="Logout"/>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>   
    </form>
	</body>
</html>
