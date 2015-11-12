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
	<c:choose>
		<c:when test='${not empty personage}'>
			<h1>${personage.persName}</h1>
			<table>
				<tr>
					<th class="title">Character Name:</th>
					<td>${personage.persName}</td>
					<th class="title">Nature:</th>
					<td>${personage.nature}</td>
					<th class="title">Clan:</th>
					<td>${personage.clan.clanName}</td>
				</tr>
				<tr>
					<th class="title">Player Name:</th>
					<td>${personage.playerName}</td>
					<th class="title">Demeanor:</th>
					<td>${personage.demeanor}</td>
					<th class="title">Sire:</th>
					<td>${personage.sire }</td>
				</tr>
				<tr>
					<th class="title">Chronicle:</th>
					<td>${personage.chronicle}</td>
					<th class="title">Concept:</th>
					<td>${personage.concept }</td>
					<th class="title">Generation:</th>
					<td>13</td>
				</tr>
				<tr>
					<td colspan="6" />
				</tr>
				<tr>
					<th class="heading" colspan="6">Attributes</th>
				</tr>
				<tr>
					<c:forEach var='attributeColumn' items='${attributeColumns}'>
						<td colspan="2">
							<table class="subtable">
								<tr>
									<th class="subheading" colspan="2">${attributeColumn.attributeColName}</th>
								</tr>
								<tr>
									<c:forEach var='persAttCol' items='${persAttCols}'>
										<c:if test='${persAttCol.attributeColumn == attributeColumn }'>
											<td colspan="2">${persAttCol.attColValue}</td>
										</c:if>
									</c:forEach>
								</tr>
								<c:forEach var='entry' items='${persAttributesByAttribute}'>
									<c:if test='${entry.key.attributeColumn == attributeColumn}'>
										<tr>
											<td>${entry.key.attributeName}</td>
											<td>${entry.value}
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</table>
						</td>
					</c:forEach>
				</tr>
				<tr>
					<th class="heading" colspan="6">Abilities</th>
				</tr>
				<tr>
					<c:forEach var='abilityColumn' items='${abilityColumns}'>
						<td colspan="2">
							<table class="subtable">
								<tr>
									<th class="subheading" colspan="2">${abilityColumn.abilityColName}</th>
								</tr>
								<tr>
									<c:forEach var='persAttCol' items='${persAttCols}'>
										<c:if test='${persAttCol.attributeColumn == attributeColumn }'>
											<td colspan="2">${persAttCol.attColValue}</td>
										</c:if>
									</c:forEach>
								</tr>
								<c:forEach var='entry' items='${persAttributesByAttribute}'>
									<c:if test='${entry.key.attributeColumn == attributeColumn}'>
										<tr>
											<td>${entry.key.attributeName}</td>
											<td>${entry.value}
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</table>
						</td>
					</c:forEach>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
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
		</c:otherwise>
	</c:choose>
</body>
</html>
