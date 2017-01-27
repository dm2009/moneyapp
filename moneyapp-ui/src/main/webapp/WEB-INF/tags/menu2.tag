<%@tag%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="blog-masthead">
    <ui:container>
        <nav class="blog-nav">
            <a class="blog-nav-item ${pageContext.request.requestURI eq '/moneyapp/' ? ' active' : '' }" href="/moneyapp/">Home</a>
            <a class="blog-nav-item ${pageContext.request.requestURI eq '/moneyapp/WEB-INF/jsp/view/coin/list.jsp' ? ' active' : ''}" href="/moneyapp/coin/list">Coins</a>

            <a> ${pageContext.request.requestURI}</a>
        </nav>
    </ui:container>
</div>
