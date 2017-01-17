<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("messages");
  String appName=resource.getString("common.title");
  String appCopyright=resource.getString("common.copyright");%>

<ui:html>
   <ui:menu> </ui:menu>
    
        <h1>Rest started!</h1>
        <h4> <a href="rest/coins">List of elements xml</a> </h4>
        <!-- h4> <a href="rest/json/coins">List of elements json</a> </h4>
        <h4> <a href="rest/csv/coins">List of elements csv</a> </h4 -->

        <h4> <a href="create_coin.jsp">Insert new element </a> </h4>
        <h4> <a href="update_coin.jsp">Update element </a> </h4>
        <h4> <a href="coin/list">MVC Coin List</a> </h4>
        
        <ui:footer key=""></ui:footer>

</ui:html>