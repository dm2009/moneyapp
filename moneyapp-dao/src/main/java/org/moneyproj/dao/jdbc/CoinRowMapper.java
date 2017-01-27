package org.moneyproj.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.moneyproj.entities.Coin;
import org.springframework.jdbc.core.RowMapper;

public class CoinRowMapper implements RowMapper<Coin> {
    @Override
    public final Coin mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        Coin ob = new Coin();

        ob.setId(rs.getInt("id"));
        ob.setNumCode(rs.getInt("numcode"));
        ob.setBaseNumCode(rs.getInt("basenumcode"));
        ob.setScale(rs.getInt("scale"));
        ob.setRate(rs.getBigDecimal("rate"));
        ob.setDate(rs.getDate("date"));
        ob.setStrCode(rs.getString("strcode"));
        ob.setName(rs.getString("name"));

        return ob;
    }
}
