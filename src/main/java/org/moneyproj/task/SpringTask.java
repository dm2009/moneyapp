package org.moneyproj.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.moneyproj.entities.BaseCodeHolder;
import org.moneyproj.entities.Coin;

import org.moneyproj.service.CoinService;
import org.moneyproj.soap.SoapClient;
import org.moneyproj.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No need to implement any interface
 */

// @Component("springTask")
public class SpringTask {

    private SoapClient soapService;

    private CoinService coinService;

    private String dateFormatString;

    public final void setSoapService(final SoapClient soapService) {
        this.soapService = soapService;
    }

    public final void setCoinService(final CoinService coinService) {
        this.coinService = coinService;
    }

    public final void setDateFormatString(final String dateFormatString) {
        this.dateFormatString = dateFormatString;
    }

    public final void execute() {
        Logger logger = LoggerFactory.getLogger(SpringTask.class);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat(dateFormatString, Locale.getDefault());

        logger.info("Executed task on : {}", new Date());

        Date dateCurrent =
                new GregorianCalendar(TimeZone.getDefault()).getTime();

        BaseCodeHolder.setValue(soapService.getBaseCode(dateCurrent));

        Date dateLastDB = coinService.getLastDate(BaseCodeHolder.getValue());
        Date loopDate;

        if (dateLastDB == null) {
            dateLastDB = DateUtil.addDays(dateCurrent, -1);
        }
        logger.info("DB Last Date : {}", dateFormat.format(dateLastDB));

        loopDate = dateLastDB;
        List<Coin> lc;

        while (loopDate.before(dateCurrent)) {
            logger.info("Loop Date : {}", dateFormat.format(loopDate));
            loopDate = DateUtil.addDays(loopDate, 1);

            lc = soapService.getValuesOnDate(loopDate);
            coinService.saveList(lc);
        }
    }
}
