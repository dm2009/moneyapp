package org.moneyproj.soap;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.moneyproj.entities.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.nbrb.ExRates;
import by.nbrb.ExRatesSoap;

public class SoapClientNBRBImpl implements SoapClient {

    @Override
    public final List<Coin> getValuesOnDate(final Date date) {
        Logger logger = LoggerFactory.getLogger(SoapClientNBRBImpl.class);

        ExRatesSoap service = new ExRates().getExRatesSoap();

        GregorianCalendar cal = new GregorianCalendar(TimeZone.getDefault());
        cal.setTime(date);
        XMLGregorianCalendar xmlcal = null;
        try {
            xmlcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        by.nbrb.ExRatesDailyResponse.ExRatesDailyResult result =
                service.exRatesDaily(xmlcal);

        ExRatesDailyAccessor accessor = ExRatesDailyAccessor.getInstance();

        List<ExRatesDailyAccessor.Currency> currencies =
                accessor.listCurrencies(result);
        List<Coin> coins = new ArrayList<Coin>();
        logger.info("getValuesOnDate...");

        for (ExRatesDailyAccessor.Currency cr : currencies) {
            Coin cn = new Coin();
            cn = cr.currencyToCoin();
            cn.setDate(date);
            cn.setBaseNumCode(getBaseCode(date));
            coins.add(cn);
            logger.info("{}", cn);
        }
        return coins;
    }

    @Override
    public final Integer getBaseCode(final Date date) {
        Date data2000, date2016;
        date2016 = new GregorianCalendar(2016, 7 - 1, 1).getTime();
        data2000 = new GregorianCalendar(2000, 1 - 1, 1).getTime();
        Integer code = null;
        if (date.before(data2000)) {
            code = 0;
        }
        if ((date.before(date2016)) && (date.after(data2000))) {
            code = 974;
        }
        if (date.after(date2016)) {
            code = 933;
        }
        return code;
    }
}
