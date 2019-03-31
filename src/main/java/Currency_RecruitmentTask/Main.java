package Currency_RecruitmentTask;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod waluty: ");
        String codeOfCurrency = scanner.next();
        codeOfCurrency.toLowerCase().trim();
        System.out.println("Podaj datę początkową (rrrr-mm-dd): ");
        String startData = scanner.next();
        System.out.println("Podaj datę końcową (rrrr-mm-dd): ");
        String endData = scanner.next();

        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.getStandardDeviation(codeOfCurrency, startData, endData);
        currencyConverter.getAverageOfBidCurrency(codeOfCurrency, startData, endData);


    }
}
