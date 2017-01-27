<%@tag%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@attribute name="type"%>
<%@attribute name="value" required="true"%>
<fmt:message key="${value}" var="text" /><button type="submit" class="btn btn-${empty type?'default':type}">${text}</button>
