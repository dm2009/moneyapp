<%@tag%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="act" value='class="active"' />

<!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-static-top" role="navigation">
      <ui:container>
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">Coin App</a>
        </div>

        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ${pageContext.request.requestURI eq '/moneyapp/' ? act : '' }><a href="/moneyapp/">Home</a></li>
            <li ${pageContext.request.requestURI eq '/moneyapp/WEB-INF/jsp/view/coin/list.jsp' ? act : '' }><a href="/moneyapp/coin/list">Coin</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">REST<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="/moneyapp/rest/coins">List of elements in xml</a></li>
                <li><a href="/moneyapp/create_coin.jsp">Insert new element</a></li>
                <li><a href="/moneyapp/update_coin.jsp">Update element</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </ui:container>
    </div>