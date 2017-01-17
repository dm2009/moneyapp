package org.moneyproj.dao.jdbc;

import java.util.Date;
import java.util.List;

import org.moneyproj.dao.CoinDao;
import org.moneyproj.entities.Coin;
import org.moneyproj.exception.PersistentException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class CoinDaoImpl extends DaoSupport implements CoinDao {

    private final RowMapper<Coin> mapper = new CoinRowMapper();


    @Override
    public final void create(final Coin coin) {
        Integer id = getJdbcTemplate()
                .queryForObject("SELECT nextval('coin_id_seq')", Integer.class);
        coin.setId(id);
        getJdbcTemplate().update(getConfig().getString("SQL_INSERT_COIN"),
                coin.getId(), coin.getDate(),
                coin.getNumCode(), coin.getRate(),
                coin.getScale(), coin.getBaseNumCode());
    }

    @Override
    public final Coin read(final Integer id) {
        Coin cn;
        try {
            cn = getJdbcTemplate().queryForObject(getConfig()
                    .getString("SQL_SELECT_COIN"), mapper, id);
        } catch (EmptyResultDataAccessException e) {
            cn = new Coin();
            throw new PersistentException(e); //throw 
        }
        return cn;
    }

    @Override
    public final void update(final Coin coin) {
        getJdbcTemplate().update(getConfig().getString("SQL_UPDATE_COIN"),
                coin.getDate(), coin.getNumCode(),
                coin.getRate(), coin.getScale(),
                coin.getBaseNumCode(), coin.getId());
    }

    @Override
    public final void delete(final Integer id) {
        getJdbcTemplate().update(getConfig().getString("SQL_DELETE_COIN"), id);
    }

    @Override
    public final Coin getByDateAndCode(final Date date, final Integer code) {
        Coin cn;
        try {
            cn = getJdbcTemplate().queryForObject(getConfig()
                    .getString("SQL_SELECT_COIN_BY_DATE_AND_CODE"), mapper,
                    code, date);
        } catch (EmptyResultDataAccessException e) {
            cn = new Coin();
            throw new PersistentException(e);
        }
        return cn;
    }

    @Override
    public final Coin getByDateAndCodeAndBaseCode(final Date date,
            final Integer code, final Integer baseCode) {
        Coin cn;
        try {
            cn = getJdbcTemplate().queryForObject(getConfig()
                    .getString("SQL_SELECT_COIN_BY_DATE_AND_CODE_AND_BCODE"),
                    mapper, code, baseCode, date);
        } catch (EmptyResultDataAccessException e) {
            cn = new Coin();
            throw new PersistentException(e);
        }
        return cn;
    }

    @Override
    public final Coin getByDateAndCodeAndBaseCodeAny(final Date date,
            final Integer code, final Integer baseCode) {
        Coin cn;
        try {
            cn = getJdbcTemplate().queryForObject(getConfig()
                    .getString("SQL_SELECT_COIN_BY_DATE_AND_CODE_AND_BCODE_ANY"),
                    mapper, code, baseCode, date);
        } catch (EmptyResultDataAccessException e) {
            cn = new Coin();
            throw new PersistentException(e);
        }
        return cn;
    }

    @Override
    public final Date getLastDate(final Integer basenumcode) {
        Date o = null;

        try {
            o = (Date) getJdbcTemplate().queryForObject(getConfig()
                    .getString("SQL_SELECT_LAST_DATE"),
                    Date.class, basenumcode);
        } catch (EmptyResultDataAccessException e) {
            throw new PersistentException(e);
        }
        return o;

    }

    @Override
    public final List<Coin> getCoins(final Date date, final Integer baseCode) {
        List<Coin> coins = null;
        try {
            coins = getJdbcTemplate().query(getConfig()
                    .getString("SQL_SELECT_COINS_BY_DATE_AND_BCODE"),
                    new BeanPropertyRowMapper<Coin>(Coin.class), baseCode,
                    date);
        } catch (EmptyResultDataAccessException e) {
            throw new PersistentException(e);
        }
        return coins;
    }

    @Override
    public final List<Coin> getCoinsAll() {
        List<Coin> coins = null;
        try {
            coins = getJdbcTemplate().query(getConfig()
                    .getString("SQL_SELECT_COINS_ALL"),
                    new BeanPropertyRowMapper<Coin>(Coin.class));
        } catch (EmptyResultDataAccessException e) {
            throw new PersistentException(e);
        }

        return coins;
    }

    @Override
    public List<Coin> getCoins(Date date) {
        List<Coin> coins = null;
        try {
            coins = getJdbcTemplate().query(getConfig()
                    .getString("SQL_SELECT_COINS_BY_DATE"),
                    new BeanPropertyRowMapper<Coin>(Coin.class), date);
        } catch (EmptyResultDataAccessException e) {
            throw new PersistentException(e);
        }
        return coins;
    }

    @Override
    public List<Coin> getByDateAndCodeAndBaseCodeList(final Date date,
            final Integer code, final Integer baseCode) {
        List<Coin> coins = null;
        try {
            coins = getJdbcTemplate().query(getConfig()
                    .getString("SQL_SELECT_COIN_BY_DATE_AND_CODE_AND_BCODE_LIST"),
                    new BeanPropertyRowMapper<Coin>(Coin.class), code, baseCode, date);
        } catch (EmptyResultDataAccessException e) {
            throw new PersistentException(e);
        }
        return coins;
    }
}
