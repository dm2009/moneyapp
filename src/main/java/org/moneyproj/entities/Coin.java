package org.moneyproj.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Dmitriy S.
 *
 */
public class Coin extends Entity {

    /**
     * UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Numeric Code of currency.
     */
    private Integer numCode;

    /**
     * The String Code of currency.
     */
    private String strCode;

    /**
     * The Numeric Code of Base currency.
     */
    private Integer baseNumCode;

    /**
     * The Scale of currency.
     */
    private Integer scale;

    /**
     * The Rate of currency.
     */
    private BigDecimal rate;

    /**
     * The Date for rate of currency.
     */
    private Date date;

    /**
     * The nominal value of currency.
     */
    private BigDecimal value;

    /**
     * @return the value (nominal) of currency.
     */
    public final BigDecimal getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set.
     */
    public final void setValue(final BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the numeric code of currency.
     */
    public final Integer getNumCode() {
        return numCode;
    }

    /**
     * @param numCode
     *            the numCode to set.
     */
    public final void setNumCode(final Integer numCode) {
        this.numCode = numCode;
    }

    /**
     * @return the string code of currency.
     */
    public final String getStrCode() {
        return strCode;
    }

    /**
     * @param strCode
     *            the strCode to set.
     */
    public final void setStrCode(final String strCode) {
        this.strCode = strCode;
    }

    /**
     * @return the base numeric code.
     */
    public final Integer getBaseNumCode() {
        return baseNumCode;
    }
    /**
     * @param baseNumCode
     *            the baseNumCode to set.
     */
    public final void setBaseNumCode(final Integer baseNumCode) {
        this.baseNumCode = baseNumCode;
    }

    /**
     * @return the scale
     */
    public final Integer getScale() {
        return scale;
    }

    /**
     * @param scale
     *            the scale to set.
     */
    public final void setScale(final Integer scale) {
        this.scale = scale;
    }

    /**
     * @return the rate
     */
    public final BigDecimal getRate() {
        return rate;
    }

    /**
     * @param rate
     *            the rate to set.
     */
    public final void setRate(final BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * @return the date.
     */
    public final Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set.
     */
    public final void setDate(final Date date) {
        this.date = date;
    }

    /**
     * Returns a string representation of the object.
     * @return string representation.
     */
    @Override
    public String toString() {
        return new StringBuilder("Coin [id=").append(getId())
                .append(" ,value=").append(getValue())
                .append(" ,numCode=").append(numCode)
                .append(", strCode=").append(strCode)
                .append(", baseNumCode=").append(baseNumCode)
                .append(", scale=").append(scale)
                .append(", rate=").append(rate)
                .append(", date=").append(date)
                .append("]").toString();
    }
    /**
     * Returns a full amount of the currency.
     * @return full amount.
     */
    public final BigDecimal calcBaseValue() {
        BigDecimal r = BigDecimal.ZERO;
        if ((getScale() != 0) && (getScale() != null)) {
            r = getValue();
            r = r.multiply(getRate());
            r = r.divide(new BigDecimal(getScale().toString()));
        }
        return r;
    }
}
