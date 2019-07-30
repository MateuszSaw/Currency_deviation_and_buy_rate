package Currency_RecruitmentTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class JsonReader {

    public  CurrencyTableWithRates getJson(String codeOfCurrency, String startData, String endData) throws IOException {
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
