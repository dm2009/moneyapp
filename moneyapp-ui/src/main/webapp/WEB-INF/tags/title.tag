<%@tag%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@attribute name="key" required="true"%>
<h4><fmt:message key="${key}" /><jsp:doBody/></h4>
