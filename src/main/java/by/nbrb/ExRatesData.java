package by.nbrb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class ExRatesData {
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DailyExRatesOnDate {
        @XmlElement(name = "Cur_QuotName")
        private String quotName;
        @XmlElement(name = "Cur_Scale")
        private BigDecimal scale;
        @XmlElement(name = "Cur_OfficialRate")
        private BigDecimal officialRate;
        @XmlElement(name = "Cur_Code")
        private Integer code;
        @XmlElement(name = "Cur_Abbreviation")
        private String abbreviation;

        // getters and setters
        public String getQuotName() {
            return quotName;
        }

        public void setQuotName(String quotName) {
            this.quotName = quotName;
        }

        public BigDecimal getScale() {
            return scale;
        }

        public void setScale(BigDecimal scale) {
            this.scale = scale;
        }

        public BigDecimal getOfficialRate() {
            return officialRate;
        }

        public void setOfficialRate(BigDecimal officialRate) {
            this.officialRate = officialRate;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

    }

    @XmlElementWrapper(name = "NewDataSet")
    @XmlElement(name = "DailyExRatesOnDate")

    protected List<DailyExRatesOnDate> item;

    public List<DailyExRatesOnDate> getItem() {
        if (item == null)
            item = new ArrayList<DailyExRatesOnDate>();
        return item;
    }
    /*
     * private List<DailyExRatesOnDate> rows = new
     * ArrayList<DailyExRatesOnDate>();
     * 
     * public List<DailyExRatesOnDate> getRows() { return rows; }
     * 
     * public void setRows(List<DailyExRatesOnDate> rows) { this.rows = rows; }
     */

}