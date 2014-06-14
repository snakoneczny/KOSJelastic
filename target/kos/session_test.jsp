<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

${loginMessage} 
<c:choose> 
	<c:when test="${sessionScope.user == null}"> 
		<nav id="regularMenu" class="menu container">
        	<form action="/login" method="POST">
            	Login:<br/> <input name="login" type="text" value="${loginHelper.login}" size="20"/> <br/>${loginHelper.loginMessage} <br/>
                Password: <br/><input name="pass" type="password" size="20"/><br/>${loginHelper.passMessage}<br/>
                <input type="submit" value="Login"/>
            </form>
        </nav>
 	</c:when> 
 	<c:otherwise>
		<form action="/logout" method="post">
        	<input type="submit" value="Logout">
        </form>	
	</c:otherwise> 
</c:choose>