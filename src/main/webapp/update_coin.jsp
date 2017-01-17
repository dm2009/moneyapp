<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Form to create a new resource</title>
   <script src="js/jquery-2.0.3.min.js" ></script>

   <script type="text/javascript" >


   function postJsonFromUser() {
                var idInput = $("#idInput").val();
                var numCodeInput = $("#numCodeInput").val();
                var scaleInput = $("#scaleInput").val();
                var rateInput = $("#rateInput").val();
                var dateInput = $("#dateInput").val();
                var baseNumCodeInput = $("#baseNumCodeInput").val();

                var dataSendArray = {};
                dataSendArray['id'] = idInput;
                dataSendArray['numCode'] = numCodeInput;
                dataSendArray['scale'] = scaleInput;
                dataSendArray['rate'] = rateInput;
                dataSendArray['date'] = dateInput;
                dataSendArray['baseNumCode'] = baseNumCodeInput;


                var dataSend = JSON.stringify(dataSendArray);
                //alert( dataSend);
                $.ajax({
                    type: 'PUT',
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
        </script>


 </head>
<body>

  <span> Id </span>
  <input id="idInput" />
  <br/>
  <span> NumCode </span>
  <input id="numCodeInput" />
  <br/>
  <span> Scale </span>
  <input id="scaleInput" />
  <br/>
  <span> Rate </span>
  <input id="rateInput" />
  <br/>
  <span> Date (yyyy-MM-dd) </span>
  <input id="dateInput" />
  <br/>
   <span> BaseNumCode </span>
  <input  id="baseNumCodeInput" value="974" />
  <br/>

  <input type="button" value="Update Coin" onclick="postJsonFromUser();" />
  <div id="outPostJsonUser"></div>

</body>
</html>

