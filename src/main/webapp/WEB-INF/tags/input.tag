<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@attribute name="path" required="true" %>
<%@attribute name="label"%>
<%@attribute name="width"%>
<spring:bind path="${path}">
<div class="form-group${status.error?' has-error':''}">
    <c:if test="${not empty label}">
    <label for="${path}" class="col-sm-${12-width} control-label"><spring:message code="${label}" text="${label}"/></label>
    </c:if>
    <div class="col-sm-${width}">
        <form:input id="${path}" path="${path}" cssClass="form-control" placeholder="${label}"/>
        <c:if test="${status.error}">
        <span id="helpBlock2" class="help-block">${status.errorMessage}</span>
        </c:if>
    </div>
</div>
</spring:bind>
