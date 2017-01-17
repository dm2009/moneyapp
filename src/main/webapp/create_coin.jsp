<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html>
<ui:menu> </ui:menu>
<ui:container style="min-height: 500px">
    <ui:row size="8">
        <!-- ui:title key="coinEdit.title" /-->

      <form class="form-horizontal">
        <ui:inputhtm path="numCodeInput" label="NumCode" width="10"></ui:inputhtm>
        <!-- span> NumCode </span>
        <input id="numCodeInput" />
        <br/ -->
        
        <ui:inputhtm path="scaleInput" label="Scale" width="10"></ui:inputhtm>
        <!-- span> Scale </span>
        <input id="scaleInput" />
        <br/-->
        
        <ui:inputhtm path="rateInput" label="Rate" width="10"></ui:inputhtm>
        <!--  span> Rate </span>
        <input id="rateInput" />
        <br/-->

        <ui:inputhtm path="dateInput" label="Date (yyyy-MM-dd)" width="10"></ui:inputhtm>
        <!-- span> Date (yyyy-MM-dd) </span>
        <input id="dateInput" />
        <br/-->
        
        <ui:inputhtm path="baseNumCodeInput" label="BaseNumCode" width="10" value="974"></ui:inputhtm>
        <!-- span> BaseNumCode </span>
        <input  id="baseNumCodeInput" value="974" />
        <br/-->

        <!-- input type="button" value="Create Coin" onclick="postJsonFromUser();" / -->
  
        <div class="col-sm-offset-2 col-sm-10">
            <ui:button id="btCreate" text="Create Coin" type="primary btn-sm"/>
        </div>

        <br/>
        <div id="outPostJsonUser" class="help-block"></div>

      </form>
    </ui:row>
</ui:container>
<ui:footer key="common.copyright" />

<script type="text/javascript">
function postJsonFromUser() {
    var numCodeInput = $("#numCodeInput").val();
    var scaleInput = $("#scaleInput").val();
    var rateInput = $("#rateInput").val();
    var dateInput = $("#dateInput").val();
    var baseNumCodeInput = $("#baseNumCodeInput").val();

    var dataSendArray = {};
    dataSendArray['numCode'] = numCodeInput;
    dataSendArray['scale'] = scaleInput;
    dataSendArray['rate'] = rateInput;
    dataSendArray['date'] = dateInput;
    dataSendArray['baseNumCode'] = baseNumCodeInput;


    var dataSend = JSON.stringify(dataSendArray);
    $.ajax({
        type: 'POST',
        url: "rest/coins",
        dataType: 'html',
        headers: {'Content-Type': 'application/json'},
        data: dataSend,
        error: function(jqXHR, textStatus, errorThrown) {
            alert("error: " + textStatus);
        },
        success: function(data, textStatus, jqXHR) {
            $("#outPostJsonUser").html(data );
        }
    });
}

    $('#btCreate').on('click', function (e) {
        postJsonFromUser();
    })

</script>
</ui:html>