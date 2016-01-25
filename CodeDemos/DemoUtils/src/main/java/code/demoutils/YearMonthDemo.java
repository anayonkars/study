package code.demoutils;

import org.joda.time.YearMonth;

/**
 * Created by anayonkar on 24/1/16.
 */
public class YearMonthDemo {
    public static void main(String[] args) {
        YearMonth ym = YearMonth.now();
        System.out.println(ym);
        ym = ym.withMonthOfYear(5);
        ym = ym.withYear(500);
        System.out.println(ym);
    }
}
