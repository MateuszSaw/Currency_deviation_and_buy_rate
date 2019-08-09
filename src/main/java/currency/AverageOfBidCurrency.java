package currency;

import java.io.IOException;

public class AverageOfBidCurrency extends CurrencyConverter{

    public void getAverageOfBidCurrency(String codeOfCurrency, String startData, String endData) throws IOException {
        setCurrency(getJsonReader().getJson(codeOfCurrency, startData, endData).currency);
        int length = getJsonReader().getJson(codeOfCurrency, startData, endData).rates.length;
        int count=0;
        double result = 0;
        for (int i = 0; i < length; i++) {
            double course = getJsonReader().getJson(codeOfCurrency, startData, endData).rates[count].getBid();
            result += course;
            count++;
        }
        System.out.printf(new StringBuilder().append("Średni kurs kupna waluty ").append(getCurrency()).append(": ").append("\n%.4f %n").toString(), result / length);
    }
}
