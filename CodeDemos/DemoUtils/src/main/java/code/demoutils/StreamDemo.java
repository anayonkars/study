package code.demoutils;

import org.joda.time.YearMonth;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anayonkar on 24/1/16.
 */
class MyDataType {
    private String dataField;
    private YearMonth yearMonth;

    public MyDataType(String dataField, YearMonth yearMonth) {
        this.dataField = dataField;
        this.yearMonth = yearMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDataType that = (MyDataType) o;

        return dataField.equals(that.dataField) && yearMonth.equals(that.yearMonth);

    }

    @Override
    public int hashCode() {
        int result = dataField.hashCode();
        result = 31 * result + yearMonth.hashCode();
        return result;
    }

    public String getDataField() {

        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    @Override
    public String toString() {
        return "MyDataType{" +
                "dataField='" + dataField + '\'' +
                ", yearMonth=" + yearMonth +
                '}';
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        /*Set<String> strSet = new HashSet<>();
        strSet.add("abc");
        strSet.add("def");
        strSet.add("pqr");
        strSet.add("xyz");
        String result = strSet.stream().filter(s -> s.startsWith("x")).findFirst().get();
        System.out.println(result);*/
        Set<MyDataType> myDataTypeSet = new HashSet<>();
        myDataTypeSet.add(new MyDataType("abc", YearMonth.now()));
        myDataTypeSet.add(new MyDataType("def", YearMonth.now()));
        myDataTypeSet.add(new MyDataType("pqr", YearMonth.now()));
        myDataTypeSet.add(new MyDataType("xyz", YearMonth.now().plusMonths(5)));
        MyDataType toSearch = new MyDataType("pqr", YearMonth.now());
        MyDataType result = myDataTypeSet.stream().
                filter(/*s -> s.getDataField().equals(toSearch.getDataField()) && s.getYearMonth().equals(toSearch.getYearMonth())*/s -> s.equals(toSearch)).
                findFirst().
                get();
        System.out.println(result);
        //myDataTypeSet.removeIf(s -> s.getDataField().startsWith("x"));
        //myDataTypeSet.removeIf(s -> !s.getDataField().isEmpty());
        final YearMonth ym = YearMonth.now().plusMonths(1);
        myDataTypeSet.removeIf(s -> s.getYearMonth().isBefore(ym));
        System.out.println(myDataTypeSet);
    }
}
