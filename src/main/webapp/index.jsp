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
    
        <h1>Hello world!</h1>

        <ui:footer key=""></ui:footer>

</ui:html>
