<%@tag%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@attribute name="size" required="true"%>
<c:set var="pos" value="${fn:substringBefore((12 - size)/2, '.')}"/>

<div class="row"><div class="col-sm-offset-${pos} col-sm-${size}">
<jsp:doBody />
</div></div>
