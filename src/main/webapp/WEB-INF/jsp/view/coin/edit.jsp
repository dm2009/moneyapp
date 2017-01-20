<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<fmt:message key="common.date.format" var="pattern" />
<fmt:formatDate value="${coin.date}" pattern="${pattern}" var="date"/>
<ui:html>
<ui:menu> </ui:menu>
<ui:container style="min-height: 500px">
    <ui:row size="8">
        <ui:title key="coinEdit.title" />
        <ui:form model="coin" type="horizontal">
            <form:hidden path="id"/>
            <ui:input path="date" label="coins.date" width="10" />
            <ui:select items="${coinTypes}" value="${numCode}" valuestr="${strCode}" path="numCode" label="coins.numCode" width="10" ></ui:select>
            <ui:select items="${coinTypes}" value="${baseNumCode}" valuestr="${strCode}" path="baseNumCode" label="coins.baseCode" width="10" ></ui:select>
            <ui:input path="scale" label="coins.scale" width="10" />
            <ui:input path="rate" label="coins.rate" width="10" />
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <ui:submit value="common.save" type="primary btn-sm"/>
                </div>
            </div>
        </ui:form>
    </ui:row>
</ui:container>
<ui:footer key="common.copyright" />
<%--
<script type="text/javascript">
</script>
--%>
</ui:html>
