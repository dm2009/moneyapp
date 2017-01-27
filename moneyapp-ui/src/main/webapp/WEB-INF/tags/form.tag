<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@attribute name="method"%>
<%@attribute name="model" required="true"%>
<%@attribute name="type"%>
<c:if test="${not empty type}"><c:set value="form-${type}" var="css"/></c:if>
<form:form method="${empty method?'POST':method}" modelAttribute="${model}" class="${css}">
<jsp:doBody />
</form:form>
