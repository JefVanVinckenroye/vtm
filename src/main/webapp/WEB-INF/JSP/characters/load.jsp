<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://jef.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='${empty character ? "Load Character" : character.characterName}' />
</head>
<body>
	<v:menu />
	<h1>Load Character</h1>
	<form>
		<label>Name:<span>${fouten.characterName}</span> <input name='characterName'
			value='${param.characterName}' required autofocus type='search'></label>
		<input type='submit' value='Zoeken'>
	</form>
	<c:if test='${not empty param and empty fouten and empty character}'>
 Character niet gevonden.
 </c:if>
	<c:if test='${not empty character}'>
		 ${character.characterName} ${character.playerName}
	</c:if>
</body>
</html>
