package org.moneyproj.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.moneyproj.entities.Coin;

public class ActionDiv implements Action {

    @Override
    public final Coin performAction(final Coin c1, final Coin c2, final Coin c3) {
        BigDecimal r = BigDecimal.ZERO;

        r = c1.calcBaseValue();

        if ("!%".equals(c2.getStrCode())) {
            r = r.divide(c2.calcBaseValue());
        } else {
            r = r.multiply(new BigDecimal("100"));
            r = r.divide(c2.getValue());
            r = r.divide(c3.getRate(), 2, RoundingMode.HALF_EVEN);
        }

        r = r.multiply(new BigDecimal(c3.getScale().toString()));
        // r = r.divide( c3.getRate(),4, RoundingMode.HALF_EVEN);
        c3.setValue(r);

        return c3;
    }

    @Override
    public final String getName() {
        return " / ";
    }
}
