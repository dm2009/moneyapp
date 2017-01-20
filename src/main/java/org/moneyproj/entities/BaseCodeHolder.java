package org.moneyproj.entities;

/**
 * Class hold Base Code.
 *
 * @author Dmitriy S
 */
public final class BaseCodeHolder {
    /**
     * value of Base Code.
     */
    private static Integer value;

    /**
     * @return the value.
     */
    public static Integer getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set.
     */
    public static void setValue(final Integer value) {
        BaseCodeHolder.value = value;
    }

    /**
     * Constructor for class.
     */
    private BaseCodeHolder() {
    }

}
