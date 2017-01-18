package org.moneyproj.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.moneyproj.entities.Coin;
import org.moneyproj.entities.CoinType;

public interface CoinService {

    Coin findByDateAndCodeAndBaseCode(Date date, Integer code,
            Integer baseCode);

    Coin findByDateAndCodeAndBaseCodeAny(Date date, Integer code,
            Integer baseCode);

    Date getLastDate(Integer basenumcode);

    void save(Coin coin);

    void delete(Integer id);

    void saveList(List<Coin> coins);

    Integer getNumCode(String strCode);

    String getStrCode(Integer numCode);

    List<CoinType> getCoinTypesList();

    Map<Integer, CoinType> getCoinTypesMap();

    List<Coin> getCoins(Date date, Integer baseCode);

    List<Coin> getCoins(Date date);

    Coin read(Integer id);

    Map<Integer, String> getCoinTypesSelector();

    boolean isDoubleExist(Coin coin);




}
