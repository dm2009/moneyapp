package org.moneyproj.logic;

import org.moneyproj.entities.Coin;

public class CalculatorImpl implements Calculator {

    private Action action;
    private Coin Coin1;
    private Coin Coin2;
    private Coin Coin3;

    @Override
    public final void setAction(final Action action) {
        this.action = action;
    }

    public final void setCoin1(final Coin Coin1) {
        this.Coin1 = Coin1;
    }

    public final void setCoin2(final Coin Coin2) {
        this.Coin2 = Coin2;
    }

    public final void setCoin3(final Coin Coin3) {
        this.Coin3 = Coin3;
    }

    @Override
    public final String run() {
        return Coin1 + action.getName() + Coin2 + " = "
               + action.performAction(Coin1, Coin2, Coin3);
    }

    @Override
    public final void setActionByStr(final String op) {
        switch (op) {
        case "+":
            setAction(new ActionAdd());
            break;
        case "-":
            setAction(new ActionSub());
            break;
        case "x":
            setAction(new ActionMul());
            break;
        case "/":
            setAction(new ActionDiv());
            break;
        default:
            throw new RuntimeException("Unknown operation " + op);
        }
    }
}
