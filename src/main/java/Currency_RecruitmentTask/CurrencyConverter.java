package Currency_RecruitmentTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {

        String codeOfCurrency = "eur";
        String startData = "2017-11-20";
        String endData = "2017-11-24";
        String course = jsonReader(codeOfCurrency, startData, endData).rates[0].getAsk();
        System.out.println(course);
    }

    // Load Json Data from NBP.Api
    private static CurrencyTableWithRates jsonReader(String codeOfCurrency, String startData, String endData) throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/rates/c/" + codeOfCurrency + "/" + startData + "/" + endData + "/?format=json";
        System.out.println(link);
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
