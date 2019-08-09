package currency;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyConverter {

    private String currency;
    private JsonReader jsonReader = new JsonReader();



    public String getCurrency() {
        return currency;
    }

    public JsonReader getJsonReader() {
        return jsonReader;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
