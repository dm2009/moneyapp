<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@attribute name="key" required="true"%>
<c:set value=" © 2016 " var="year"/>
<div id="footer">
<ui:container>
        <c:if test="${not empty key}">
        <p class="text-muted">${year}<fmt:message key="${key}" /></p>
        </c:if>
        <c:if test="${empty key}">
        <p class="text-muted">${year} Dmitriy S</p>
        </c:if>
</ui:container>
</div>
