<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="path" required="true" %>
<%@attribute name="label"%>
<%@attribute name="value"%>
<%@attribute name="width"%>
<div class="form-group">
    <c:if test="${not empty label}">
    <label for="${path}" class="col-sm-${12-width} control-label">${label}</label>
    </c:if>
    <div class="col-sm-${width}">
        <input id="${path}" class="form-control" placeholder="${label}" value="${value}"/>
    </div>
</div>

