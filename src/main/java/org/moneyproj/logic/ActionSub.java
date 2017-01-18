package org.moneyproj.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.moneyproj.entities.Coin;

public class ActionSub implements Action {

    @Override
    public final Coin performAction(final Coin c1, final Coin c2, final Coin c3) {
        BigDecimal r = BigDecimal.ZERO;

        r = c1.calcBaseValue();
        if ("%".equals(c2.getStrCode())) {
            r = r.multiply(c2.getValue());
            r = r.divide(new BigDecimal("100"));
            r = r.multiply(new BigDecimal("-1"));
            r = r.add(c1.calcBaseValue());
        } else {
            r = r.subtract(c2.calcBaseValue());
        }
        r = r.multiply(new BigDecimal(c3.getScale().toString()));
        r = r.divide(c3.getRate(), 2, RoundingMode.HALF_EVEN);
        c3.setValue(r);

        return c3;
    }

    @Override
    public final String getName() {
        return " - ";
    }
}
