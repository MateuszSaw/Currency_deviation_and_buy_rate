package Currency_RecruitmentTask;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyConverter {

    private int count;
    private String currency ;
   private JsonReader jsonReader = new JsonReader();



    public void getStandardDeviation(String codeOfCurrency, String startData, String endData) throws IOException {
        currency = jsonReader.getJson(codeOfCurrency, startData, endData).currency;
        int length = jsonReader.getJson(codeOfCurrency, startData, endData).rates.length;
        double[] currencyTable = new double[length];
        for (int i = 0; i < length; i++) {
            double course = jsonReader.getJson(codeOfCurrency, startData, endData).rates[count].getAsk();
            currencyTable[i] = course;
            count++;
        }
        Patterns patterns = new Patterns(currencyTable, length);
        double stdDev = patterns.getStandardDeviation();
        System.out.printf(new StringBuilder().append("Standardowe odchylenie waluty ").append(currency).append(": ").append("\n%.4f %n").toString(), stdDev);
    }

    public void getAverageOfBidCurrency(String codeOfCurrency, String startData, String endData) throws IOException {
        currency = jsonReader.getJson(codeOfCurrency, startData, endData).currency;
        int length = jsonReader.getJson(codeOfCurrency, startData, endData).rates.length;
       count = 0;
        double result = 0;
        for (int i = 0; i < length; i++) {
            double course = jsonReader.getJson(codeOfCurrency, startData, endData).rates[count].getBid();
            result += course;
            count++;
        }
        System.out.printf(new StringBuilder().append("Średni kurs kupna waluty ").append(currency).append(": ").append("\n%.4f %n").toString(), result / length);
    }

}
