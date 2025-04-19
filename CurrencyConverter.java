import java.util.*;

public class CurrencyConverter {

    // Simulated exchange rates (Base: USD)
    static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.91);
        exchangeRates.put("INR", 83.10);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("JPY", 154.32);
        exchangeRates.put("CAD", 1.37);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Available currencies: " + exchangeRates.keySet());

        // Currency selection
        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Amount input
        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Validate currencies
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("❌ Invalid currency code entered.");
            return;
        }

        // Conversion
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        double convertedAmount = (amount / baseRate) * targetRate;

        // Display result
        System.out.printf("✅ %.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
    }
}

