package org.moneyproj.soap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.xerces.dom.ElementNSImpl;
import org.moneyproj.entities.Coin;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.nbrb.ExRatesDailyResponse.ExRatesDailyResult;

/**
 * http://www.nbrb.by/statistics/Rates/WebService/?what=1 Получение официального
 * курса белорусского рубля по отношению к иностранным валютам на определенную
 * дату, устанавливаемого ежедневно: ExRatesDaily(ByVal onDate As DateTime) As
 * DataSet Параметр: onDate – дата в формате System.DateTime, на которую
 * запрашивается курс. Метод ExRatesDaily возвращает XML-документ в формате
 * System.Data.Dataset, содержащий таблицу DailyExRatesOnDate таблицы имеют
 * одинаковую структуру: Cur_QuotName – наименование валюты, содержащее номинал
 * Cur_Scale – номинал Cur_OfficialRate – курс Cur_Code – цифровой код
 * Cur_Abbreviation – буквенный код.
 *
 * Возвращаемый DataSet в свойстве ExtendedProperties содержит элемент с ключом
 * "onDate" и значением равным дате, на которую получен официальный курс.
 *
 */
public final class ExRatesDailyAccessor {

    private static final ExRatesDailyAccessor INSTANCE =
            new ExRatesDailyAccessor();

    public static ExRatesDailyAccessor getInstance() {
        return INSTANCE;
    }

    private ExRatesDailyAccessor() {
    }

    public static class Currency {
        private String curQuotName;
        private String curAbbreviation;
        private Integer curCode;
        private BigDecimal curScale;
        private BigDecimal curOfficialRate;



        public final String getCurQuotName() {
            return curQuotName;
        }

        public final void setCurQuotName(final String curQuotName) {
            this.curQuotName = curQuotName;
        }

        public final String getCurAbbreviation() {
            return curAbbreviation;
        }

        public final void setCurAbbreviation(final String curAbbreviation) {
            this.curAbbreviation = curAbbreviation;
        }

        public final Integer getCurCode() {
            return curCode;
        }

        public final void setCurCode(final Integer curCode) {
            this.curCode = curCode;
        }

        public final BigDecimal getCurScale() {
            return curScale;
        }

        public final void setCurScale(final BigDecimal curScale) {
            this.curScale = curScale;
        }

        public final BigDecimal getCurOfficialRate() {
            return curOfficialRate;
        }

        public final void setCurOfficialRate(final BigDecimal curOfficialRate) {
            this.curOfficialRate = curOfficialRate;
        }

        @Override
        public String toString() {
            return new StringBuilder("Currency [Cur_QuotName=").append(curQuotName)
                    .append(" ,Cur_Abbreviation=").append(curAbbreviation)
                    .append(" ,Cur_Code=").append(curCode.toString())
                    .append(" ,Cur_Scale=").append(curScale.toString())
                    .append(" ,Cur_OfficialRate=").append(curOfficialRate.toString())
                    .append("]").toString();
        }

        public final Boolean isEmpty() {
            return StringUtils.isEmpty(curQuotName)
                    || StringUtils.isEmpty(curAbbreviation)
                    || curCode == null
                    || curScale == null
                    || curOfficialRate == null;
        }

        public final Coin currencyToCoin() {
            Coin cn = new Coin();
            cn.setName(curQuotName);
            cn.setStrCode(curAbbreviation);
            cn.setNumCode(curCode);
            cn.setScale(curScale.intValue());
            cn.setRate(curOfficialRate);
            return cn;

        }
    }

    public List<Currency> listCurrencies(final ExRatesDailyResult result) {

        List<Currency> currencies = new ArrayList<>();
        if (result != null) {
            ElementNSImpl root = (ElementNSImpl) result.getAny();
            NodeList nodes = root.getElementsByTagName("Cur_Abbreviation");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Currency c = buildCurrency(node);
                if (!c.isEmpty()) {
                    currencies.add(c);
                }
            }

        }
        return currencies;
    }

    private Currency buildCurrency(final Node node) {

        Currency currency = new Currency();
        Node parent = node.getParentNode();
        NodeList list = parent.getChildNodes();

        for (int j = 0; j < list.getLength(); j++) {

            Node current = list.item(j);

            String name = StringUtils.trimToEmpty(current.getNodeName());
            Node firstChild = current.getFirstChild();
            String value = StringUtils.trimToEmpty(firstChild.getNodeValue());

            switch (name) {
            case "Cur_QuotName":
                currency.curQuotName = value;
                break;
            case "Cur_Scale":
                currency.curScale = new BigDecimal(value);
                break;
            case "Cur_OfficialRate":
                currency.curOfficialRate = new BigDecimal(value);
                break;
            case "Cur_Code":
                currency.curCode = Integer.parseInt(value);
                break;
            case "Cur_Abbreviation":
                currency.curAbbreviation = value;
                break;
            default:
                throw new RuntimeException("Unknown element name " + name);
            }
        }

        return currency;
    }
}
