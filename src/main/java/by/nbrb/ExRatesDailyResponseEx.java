package by.nbrb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2001.xmlschema.Schema;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExRatesDailyResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.w3.org/2001/XMLSchema}schema"/>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "exRatesDailyResult" })
@XmlRootElement(name = "ExRatesDailyResponse")
public class ExRatesDailyResponseEx {

    @XmlElement(name = "ExRatesDailyResult")
    protected ExRatesDailyResponseEx.ExRatesDailyResult exRatesDailyResult;

    /**
     * Gets the value of the exRatesDailyResult property.
     * 
     * @return possible object is
     *         {@link ExRatesDailyResponseEx.ExRatesDailyResult }
     * 
     */
    public ExRatesDailyResponseEx.ExRatesDailyResult getExRatesDailyResult() {
        return exRatesDailyResult;
    }

    /**
     * Sets the value of the exRatesDailyResult property.
     * 
     * @param value
     *            allowed object is
     *            {@link ExRatesDailyResponseEx.ExRatesDailyResult }
     * 
     */
    public void setExRatesDailyResult(ExRatesDailyResponseEx.ExRatesDailyResult value) {
        this.exRatesDailyResult = value;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     * 
     * <p>
     * The following schema fragment specifies the expected content contained
     * within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}schema"/>
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "schema", "any" })
    public static class ExRatesDailyResult {

        @XmlElement(namespace = "http://www.w3.org/2001/XMLSchema", required = true)
        protected Schema schema;
        @XmlElement(name = "diffgram", namespace = "urn:schemas-microsoft-com:xml-diffgram-v1")
        // @XmlElement(name="NewDataSet",namespace="")
        protected ExRatesData any;

        public Schema getSchema() {
            return schema;
        }

        public void setSchema(Schema value) {
            this.schema = value;
        }

        public ExRatesData getAny() {
            return any;
        }

        public void setAny(ExRatesData value) {
            this.any = value;
        }

    }

}
