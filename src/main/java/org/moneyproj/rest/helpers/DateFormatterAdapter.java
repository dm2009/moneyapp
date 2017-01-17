package org.moneyproj.rest.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateFormatterAdapter extends XmlAdapter<String, Date> {

    // @Value("${common.date.format:yyyy-MM-dd}")
    private final static String FORMAT_PATTERN = "yyyy-MM-dd";

    @Override
    public final Date unmarshal(final String v) throws Exception {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(FORMAT_PATTERN, Locale.getDefault());
        return dateFormat.parse(v);
    }

    @Override
    public final String marshal(final Date v) throws Exception {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(FORMAT_PATTERN, Locale.getDefault());
        return dateFormat.format(v);
    }

}
