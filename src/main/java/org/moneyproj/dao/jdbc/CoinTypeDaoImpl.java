package org.moneyproj.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.moneyproj.dao.CoinTypeDao;
import org.moneyproj.entities.CoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class CoinTypeDaoImpl extends DaoSupport implements CoinTypeDao {

    private final RowMapper<CoinType> mapper = new BeanPropertyRowMapper<CoinType>(CoinType.class);

    /**
     * Logger for this class.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public final void create(final CoinType entity) {
        getJdbcTemplate().update(getConfig().getString("SQL_INSERT_COIN_TYPE"), entity.getNumCode(),
                entity.getStrCode(), entity.getName());
    }

    @Override
    public final CoinType read(final Integer numcode) {
        CoinType o;
        try {
            o = getJdbcTemplate().queryForObject(getConfig().getString("SQL_SELECT_COIN_TYPE"), mapper, numcode);
        } catch (EmptyResultDataAccessException e) {
            o = new CoinType();
        }
        return o;
    }

    @Override
    public final void update(final CoinType entity) {
        getJdbcTemplate().update(getConfig().getString("SQL_UPDATE_COIN_TYPE"), entity.getNumCode(),
                entity.getStrCode(), entity.getName());

    }

    @Override
    public final void delete(final Integer numcode) {
        getJdbcTemplate().update(getConfig().getString("SQL_DELETE_COIN_TYPE"), numcode);

    }

    @Override
    public final Integer getNumCode(final String strCode) {
        Integer o = null;

        try {
            o = (Integer) getJdbcTemplate().queryForObject(getConfig().getString("SQL_SELECT_COIN_TYPE_CODE"),
                    Integer.class, strCode);
        } catch (EmptyResultDataAccessException e) {
            logger.info("getNumCode {}", e.getMessage());
        }
        return o;
    }

    @Override
    public final String getStrCode(final Integer numCode) {
        String o = null;

        try {
            o = (String) getJdbcTemplate().queryForObject(getConfig().getString("SQL_SELECT_COIN_TYPE_STRCODE"),
                    String.class, numCode);
        } catch (EmptyResultDataAccessException e) {
            logger.info("getStrCode {}", e.getMessage());
        }
        return o;
    }

    @Override
    public final List<CoinType> getCoinTypesList() {
        List<CoinType> coinTypes = null;

        try {
            coinTypes = getJdbcTemplate().query(getConfig().getString("SQL_SELECT_COINS_TYPES_ALL"),
                    new BeanPropertyRowMapper<CoinType>(CoinType.class));
        } catch (EmptyResultDataAccessException e) {
            logger.info("getCoinTypesList {}", e.getMessage());
        }
        return coinTypes;

    }

    @Override
    public final Map<Integer, CoinType> getCoinTypesMap() {
        List<CoinType> coinTypes = getCoinTypesList();
        Map<Integer, CoinType> coinTypesMap = null;

        if (coinTypes != null) {
            coinTypesMap = new HashMap<Integer, CoinType>();
            for (CoinType ct : coinTypes) {
                coinTypesMap.put(ct.getNumCode(), ct);
            }
        }
        return coinTypesMap;
    }

}
