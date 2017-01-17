package org.moneyproj.logic;

import org.moneyproj.entities.Coin;

public interface Action {
    Coin performAction(Coin c1, Coin c2, Coin c3);

    String getName();
}
