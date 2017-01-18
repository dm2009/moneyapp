package org.moneyproj.logic;

import org.moneyproj.entities.Coin;

public interface Calculator {

    void setAction(Action action);

    void setActionByStr(String op);

    String run();

    void setCoin1(Coin Coin1);

    void setCoin2(Coin Coin2);

    void setCoin3(Coin Coin3);
}
