package currency;

import java.io.IOException;

public class StandardDeviation extends CurrencyConverter {


    public void getStandardDeviation(String codeOfCurrency, String startData, String endData) throws IOException {
        setCurrency(getJsonReader().getJson(codeOfCurrency, startData, endData).currency);
        int length = getJsonReader().getJson(codeOfCurrency, startData, endData).rates.length;
        int count=0;
        double[] currencyTable = new double[length];
        for (int i = 0; i < length; i++) {
            double course = getJsonReader().getJson(codeOfCurrency, startData, endData).rates[count].getAsk();
            currencyTable[i] = course;
            count++;
        }
        Patterns patterns = new Patterns(currencyTable, length);
        double stdDev = patterns.getStandardDeviation();
        System.out.printf(new StringBuilder().append("Standardowe odchylenie waluty ").append(getCurrency()).append(": ").append("\n%.4f %n").toString(), stdDev);
    }
}
