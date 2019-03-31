package Currency_RecruitmentTask;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyConverter {

    private String currency = "";
    private int count = 0;

    public void getStandardDeviation(String codeOfCurrency, String startData, String endData) throws IOException {
        currency = jsonReader(codeOfCurrency, startData, endData).currency;
        int length = jsonReader(codeOfCurrency, startData, endData).rates.length;
        count = 0;
        double[] currencyTable = new double[length];
        for (int i = 0; i < length; i++) {
            double course = jsonReader(codeOfCurrency, startData, endData).rates[count].getAsk();
            currencyTable[i] = course;
            count++;
        }
        Patterns patterns = new Patterns(currencyTable, length);
        double stdDev = patterns.getStandardDeviation();
        System.out.printf(new StringBuilder().append("Standardowe odchylenie waluty ").append(currency).append(": ").append("\n%.4f %n").toString(), stdDev);
    }

    public void getAverageOfBidCurrency(String codeOfCurrency, String startData, String endData) throws IOException {
        currency = jsonReader(codeOfCurrency, startData, endData).currency;
        int length = jsonReader(codeOfCurrency, startData, endData).rates.length;
        count = 0;
        double result = 0;
        for (int i = 0; i < length; i++) {
            double course = jsonReader(codeOfCurrency, startData, endData).rates[count].getBid();
            result += course;
            count++;
        }
        System.out.printf(new StringBuilder().append("Średni kurs kupna waluty ").append(currency).append(": ").append("\n%.4f %n").toString(), result / length);
    }

    // Load Json Data from NBP.Api
    private static CurrencyTableWithRates jsonReader(String codeOfCurrency, String startData, String endData) throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/rates/c/" + codeOfCurrency + "/" + startData + "/" + endData + "/?format=json";
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("user-agent", "Mozilla");
        connection.connect();
        InputStream is = connection.getInputStream();
        Scanner scanner = new Scanner(is);
        String jsonText = scanner.nextLine();
        Gson gson = new Gson();
        return gson.fromJson(jsonText, CurrencyTableWithRates.class);

    }
}
