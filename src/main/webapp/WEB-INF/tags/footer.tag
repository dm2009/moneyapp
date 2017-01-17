<%@tag%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@attribute name="key" required="true"%>
<div id="footer">
<ui:container>
        <p class="text-muted"> © 2016 <fmt:message key="${key}" /></p>
</ui:container>
</div>
