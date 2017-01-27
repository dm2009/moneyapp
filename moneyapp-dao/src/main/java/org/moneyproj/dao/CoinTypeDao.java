package org.moneyproj.dao;

import java.util.List;
import java.util.Map;

import org.moneyproj.entities.CoinType;

public interface CoinTypeDao extends Dao<Integer, CoinType> {

    Integer getNumCode(String strCode);

    String getStrCode(Integer numCode);

    List<CoinType> getCoinTypesList();

    Map<Integer, CoinType> getCoinTypesMap();

}
