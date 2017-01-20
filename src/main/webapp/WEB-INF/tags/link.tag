<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="href" required="true"%>
<%@attribute name="value" required="true"%>
<c:url value="${href}" var="href"/><a href="${href}">${value}</a>
