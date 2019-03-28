package Currency_RecruitmentTask;

import java.util.Arrays;


public class CurrencyTableWithRates {

    String currency;
    String code;
    Rates[] rates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyTableWithRates that = (CurrencyTableWithRates) o;
        return Arrays.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rates);
    }


    public class Rates {

        double bid;
        double ask;

        public double getBid() {
            return bid;
        }

        public double getAsk() {
            return ask;
        }
    }

}