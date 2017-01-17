package org.moneyproj.dao;

import java.util.Date;
import java.util.List;

import org.moneyproj.entities.Coin;

public interface CoinDao extends Dao<Integer, Coin> {
    Coin getByDateAndCode(Date date, Integer code);

    Coin getByDateAndCodeAndBaseCode(Date date, Integer code, Integer baseCode);

    Coin getByDateAndCodeAndBaseCodeAny(Date date, Integer code, Integer baseCode);

    Date getLastDate(Integer basenumcode);

    List<Coin> getCoins(Date date, Integer baseCode);

    List<Coin> getCoins(Date date);

    List<Coin> getCoinsAll();

    List<Coin> getByDateAndCodeAndBaseCodeList(Date date, Integer code, Integer baseCode);
}
