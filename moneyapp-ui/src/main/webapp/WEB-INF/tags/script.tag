<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="src"%>
<c:choose>
<c:when test="${empty src}">
<script type="text/javascript">
<jsp:doBody/>
</script>
</c:when>
<c:otherwise>
<script type="text/javascript" src="${src}"></script>
</c:otherwise>
</c:choose>
