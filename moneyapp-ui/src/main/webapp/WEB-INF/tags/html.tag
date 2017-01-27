<%@tag %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="intitle" required="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta contentType="text/html; charset=UTF-8">
        <title>
        <c:if test="${not empty intitle}"><fmt:message key="${intitle}" /></c:if>
        </title>
        <spring:url value="/resources/js/jquery.min.js" var="jqueryJs" /><script src="${jqueryJs}"></script>
        <spring:url value="/resources/js/collapse.js" var="collapseJs" /><script src="${collapseJs}"></script>
        <spring:url value="/resources/js/moment.min.js" var="momentJs" /><script src="${momentJs}"></script>
        <spring:url value="/resources/js/transition.js" var="transitionJs" /><script src="${transitionJs}"></script>
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" /><script src="${bootstrapJs}"></script>
        <spring:url value="/resources/js/bootstrap-datetimepicker.min.js" var="bootstrapDatetimepickerJs" /><script src="${bootstrapDatetimepickerJs}"></script>
        <spring:url value="/resources/js/bootstrap-select.min.js" var="bootstrapSelectJs" /><script src="${bootstrapSelectJs}"></script>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
        <spring:url value="/resources/css/bootstrap-datetimepicker.min.css" var="bootstrapDatetimepickerCss" />
        <spring:url value="/resources/css/bootstrap-select.min.css" var="bootstrapSselectCss" />
        <spring:url value="/resources/css/sticky-footer-navbar.css" var="footerCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${bootstrapDatetimepickerCss}" rel="stylesheet" />
        <link href="${bootstrapSelectCss}" rel="stylesheet" />
        <link href="${footerCss}" rel="stylesheet" />
    </head>
    <body>
        <jsp:doBody/>
    </body>
</html>