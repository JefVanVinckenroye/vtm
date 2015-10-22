<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/new.htm'/>">New</a></li>
		<li><a href="#">Load</a>
		<ul>
				<li><nav>
						<c:forEach var='character' items='${characters}'>
							<c:url value='/load.htm' var='loadURL'>
								<c:param name='idCharacter' value="${character.idCharacter}" />
							</c:url>
							<a
								href="<c:url value='/load.htm?idCharacter=${character.idCharacter}'/>">${character.characterName}</a>
						</c:forEach>
					</nav></li>
			</ul></li>
	</ul>
</nav>
