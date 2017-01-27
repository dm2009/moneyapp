package org.moneyproj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.moneyproj.dao.CoinDao;
import org.moneyproj.dao.CoinTypeDao;
import org.moneyproj.entities.Coin;
import org.moneyproj.entities.CoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinServiceImpl implements CoinService {

    private CoinDao coinDao;

    private CoinTypeDao coinTypeDao;

    /**
     * Logger for this class.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public final void setCoinDao(final CoinDao coinDao) {
        this.coinDao = coinDao;
    }

    public final void setCoinTypeDao(final CoinTypeDao coinTypeDao) {
        this.coinTypeDao = coinTypeDao;
    }

    @Override
    public final boolean isDoubleExist(final Coin coin) {
        Boolean result = true;
        List<Coin> coins = coinDao.getByDateAndCodeAndBaseCodeList(coin.getDate(), coin.getNumCode(),
                coin.getBaseNumCode());

        if (coins != null) {
            for (Coin i : coins) {
                logger.info("isExist() cn   {}", i);
            }
        }

        Coin cn = new Coin();
        if (coins.size() >= 1) {
            cn = coins.get(0);
        }
        logger.info("isExist() cn   {}", cn);
        logger.info("isExist() coin {}", coin);
        if (cn.getId() == null) {
            result = false;
        }

        if ((coin.getId() != null) && (cn.getId() != null)) {
            if (coin.getId().equals(cn.getId())) {
                result = false;
            }
        }

        if (coins.size() > 1) {
            result = true;
        }
        logger.info("isExist() result {}", result);

        return result;

    }

    @Override
    public final void save(final Coin coin) {

        if (isDoubleExist(coin) == false) {
            if (coin.getId() == null) {
                coinDao.create(coin);
            } else {
                coinDao.update(coin);
            }
        }
        logger.info("save() coin {}", coin);
    }

    @Override
    public final void delete(final Integer id) {
        coinDao.delete(id);
    }

    @Override
    public final Coin read(final Integer id) {
        return coinDao.read(id);
    }

    @Override
    public final Coin findByDateAndCodeAndBaseCodeAny(final Date date, final Integer code, final Integer baseCode) {
        return coinDao.getByDateAndCodeAndBaseCodeAny(date, code, baseCode);
    }

    @Override
    public final Coin findByDateAndCodeAndBaseCode(final Date date, final Integer code, final Integer baseCode) {
        return coinDao.getByDateAndCodeAndBaseCode(date, code, baseCode);
    }

    @Override
    public final void saveList(final List<Coin> coins) {
        for (Coin cn : coins) {
            save(cn);
        }
    }

    @Override
    public final Date getLastDate(final Integer basenumcode) {
        return coinDao.getLastDate(basenumcode);
    }

    @Override
    public final List<Coin> getCoins(final Date date, final Integer baseCode) {
        return coinDao.getCoins(date, baseCode);
    }

    @Override
    public final List<Coin> getCoins(final Date date) {
        return coinDao.getCoins(date);
    }

    @Override
    public final Integer getNumCode(final String strCode) {
        return coinTypeDao.getNumCode(strCode);
    }

    @Override
    public final String getStrCode(final Integer numCode) {
        return coinTypeDao.getStrCode(numCode);
    }

    @Override
    public final List<CoinType> getCoinTypesList() {
        return coinTypeDao.getCoinTypesList();
    }

    @Override
    public final Map<Integer, CoinType> getCoinTypesMap() {
        return coinTypeDao.getCoinTypesMap();
    }

    @Override
    public final Map<Integer, String> getCoinTypesSelector() {
        List<CoinType> coinTypes = getCoinTypesList();
        Map<Integer, String> coinTypesMap = new HashMap<Integer, String>();
        for (CoinType el : coinTypes) {
            coinTypesMap.put(el.getNumCode(), el.getStrCode());
        }

        return coinTypesMap;
    }

}
