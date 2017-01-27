package org.moneyproj.entities;
/**
 *
 * @author Dmitriy S
 *
 */
public class CoinType extends Entity {

    /**
     * UID.
     */
     private static final long serialVersionUID = 1L;

    /**
     * Numeric code of money.
     */
    private Integer numCode;

    /**
     * String code of money.
     */
    private String strCode;

    /**
     * @return the NumCode
     */
    public final Integer getNumCode() {
        return numCode;
    }

    /**
     * @param numCode the numCode to set.
     */
    public final void setNumCode(final Integer numCode) {
        this.numCode = numCode;
    }

    /**
     * @return the strCode.
     */
    public final String getStrCode() {
        return strCode;
    }

    /**
     * @param strCode the String Code to set.
     */
    public final void setStrCode(final String strCode) {
        this.strCode = strCode;
    }
}
