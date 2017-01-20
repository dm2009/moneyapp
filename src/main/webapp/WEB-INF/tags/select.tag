<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@attribute name="path" required="true" %>
<%@attribute name="label"%>
<%@attribute name="width"%>
<%@attribute name="value"%>
<%@attribute name="valuestr"%>
<%@attribute name="items" required="true" type="java.util.Map"%>
<div class="form-group">
    <c:if test="${not empty label}">
    <label for="${path}" class="col-sm-${12-width} control-label"><spring:message code="${label}" text="${label}"/></label>
    </c:if>
    <div class="col-sm-${width}">
        <form:select id="${path}" path="${path}" class="form-control input">
            <form:option value="${value}">${caption}</form:option>
            <form:options items="${items}"/>
        </form:select>
    </div>
</div>
