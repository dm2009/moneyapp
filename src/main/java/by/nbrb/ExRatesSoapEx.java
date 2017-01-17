package by.nbrb;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ExRatesSoap", targetNamespace = "http://www.nbrb.by/")
public interface ExRatesSoapEx /* extends ExRatesSoap */ {

    /**
     * ����������� ���� ������������ ����� �� ��������� � ����������� �������,
     * ��������������� ������������ ������ ���������� �������� ���������, �
     * ����� �� 17.02.1997 �.
     * 
     * @param onDate
     * @return returns by.nbrb.ExRatesDailyResponseEx.ExRatesDailyResult
     */
    @WebMethod(operationName = "ExRatesDaily", action = "http://www.nbrb.by/ExRatesDaily")
    @WebResult(name = "ExRatesDailyResult", targetNamespace = "http://www.nbrb.by/")
    @RequestWrapper(localName = "ExRatesDaily", targetNamespace = "http://www.nbrb.by/", className = "by.nbrb.ExRatesDaily")
    @ResponseWrapper(localName = "ExRatesDailyResponse", targetNamespace = "http://www.nbrb.by/", className = "by.nbrb.ExRatesDailyResponseEx")
    public by.nbrb.ExRatesDailyResponseEx.ExRatesDailyResult exRatesDaily(
            @WebParam(name = "onDate", targetNamespace = "http://www.nbrb.by/") XMLGregorianCalendar onDate);

}
