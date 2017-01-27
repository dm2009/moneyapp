<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@attribute name="type"%>
<%@attribute name="text" required="true"%>
<%@attribute name="id"%>

<c:if test="${empty id}">
<c:set var="idval" value=""/>
</c:if>
<c:if test="${not empty id}">
<c:set var="idval" value=' id="${id}"'/>
</c:if>

<button${idval} type="button" class="btn btn-${empty type?'default':type}">${text}</button>
