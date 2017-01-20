<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="style"%>
<c:if test="${not empty style}"><c:set value=" style=\"${style}\"" var="zzz"/></c:if>
<div class="container"${empty zzz?'':zzz}>
    <jsp:doBody/>
</div>