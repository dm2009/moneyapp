package org.moneyproj.soap;

import java.util.Date;
import java.util.List;

import org.moneyproj.entities.Coin;

public interface SoapClient {

    List<Coin> getValuesOnDate(Date date);

    Integer getBaseCode(Date date);

}
