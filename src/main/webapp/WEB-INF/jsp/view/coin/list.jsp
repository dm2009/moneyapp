<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<fmt:message key="common.date.format" var="pattern" />
<fmt:formatDate value="${date}" pattern="${pattern}" var="dtm"/>
<ui:html intitle="coins.title">
<ui:menu> </ui:menu>
<ui:container style="min-height: 500px">
    <div class="starter-template">
        <ui:title key="coins.title">: ${dtm}</ui:title>
        <input type="hidden" name="ddate" id="ddate" value="${dtm}" />
        <!-- "datetimepicker" -->
        <div class="form-group">
            <input type="text" class="form-control" id="dpDate" value="${dtm}">
        </div>
        <div class="form-group">
            <input type="hidden" name="dformat" id="dformat" value="${pattern}" />
        </div>
        <form action="list" method="post">
            <div id="tablecnt">
                <table> <!-- class="table" -->
                    <tr>
                        <th>&nbsp;</th>
                        <th><fmt:message key="coins.name" /></th>
                        <th><fmt:message key="coins.numCode" /></th>
                        <th><fmt:message key="coins.strCode" /></th>
                        <th><fmt:message key="coins.scale" /></th>
                        <th><fmt:message key="coins.rate" /></th>
                    </tr>
                    <c:forEach var="item" items="${coins}">
                        <tr>
                            <td><ui:checbox name="coinIds" value="${item.id}" /></td>
                            <td><ui:link href="/coin/edit?id=${item.id}" value="${item.name}" /></td>
                            <td><c:out value="${item.numCode}" /></td>
                            <td><c:out value="${item.strCode}" /></td>
                            <td><c:out value="${item.scale}" /></td>
                            <td><c:out value="${item.rate}" /></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><ui:submit value="common.delete" type="primary btn-sm" /></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</ui:container>

<br/>

<ui:footer key="common.copyright"></ui:footer>

<script type="text/javascript" >
    $(function() {
        $('#dpDate').datetimepicker({
            pickTime : false,
            format : $("#dformat").val().toUpperCase(),
            defaultDate : new Date($("#ddate").val())
        });
    });

    $("#dpDate").on(
            "dp.change",
            function(e) {
                var dt = document.getElementById('dpDate');
                var dpDate = moment(dt);
                var dpDateFormat = document.getElementById('dformat').value.toUpperCase();
                var dpDateStr = moment(dt.value).format('YYYY-MM-DD').toUpperCase();
                if ((e.date != e.oldDate) && (dpDateStr != $("#ddate").val())) {
                    location.href = "?date=" + dpDateStr;
                }
            });

</script>
</ui:html>
