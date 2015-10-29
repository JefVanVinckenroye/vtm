<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://jef.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Load Character" />
</head>
<body>
	<v:menu />
	<h1>Load Character</h1>
	<nav>
		<c:forEach var='personage' items='${personages}'>
			<c:url value='/characters/load.htm' var='loadURL'>
				<c:param name='persId' value="${personage.persId}" />
			</c:url>
			<a
				href="<c:url value='/characters/load.htm?persId=${personage.persId}'/>">${personage.persName}</a>
		</c:forEach>
	</nav>
	<c:if test='${not empty personage}'>
		<table>
			<tr>
				<th>Character Name</th>
				<th>Player Name</th>
				<th>Chronicle</th>
				<th>Nature</th>
				<th>Demeanor</th>
				<th>Concept</th>
				<th>Clan</th>
				<c:forEach var='attributeColumn' items='${attributeColumns}'>
					<th>${attributeColumn.attributeColName}</th>
				</c:forEach>
			</tr>
			<tr>
				<td>${personage.persName}</td>
				<td>${personage.playerName}</td>
				<td>${personage.chronicle}</td>
				<td>${personage.nature}</td>
				<td>${personage.demeanor}</td>
				<td>${personage.concept }</td>
				<td>${personage.clan.clanName}</td>
				<c:forEach var='persAttCol' items='${persAttCols}'>
				<td>${persAttCol.attColValue}</td>				
				</c:forEach>				
			</tr>
		</table>
	</c:if>
</body>
</html>
