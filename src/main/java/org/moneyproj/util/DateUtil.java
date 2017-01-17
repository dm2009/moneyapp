package org.moneyproj.util;

import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    public static Date addDays(final Date date, final int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); // minus number would decrement the days
        // cal.add(Calendar.MONTH, -2);
        // cal.add(Calendar.YEAR, -5);
        return cal.getTime();
    }
}
