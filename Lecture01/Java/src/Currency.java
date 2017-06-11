import java.util.HashMap;

/**
 * Created by championswimmer on 10/12/16.
 */
public class Currency {
    // Static vars
    private static HashMap<String, Currency> currencyTable;


    // Object vars
    private String currencyName;

    private Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public static Currency newInstance (String currencyName) {
        if (!currencyTable.containsKey(currencyName)) {
            currencyTable.put(currencyName, new Currency(currencyName));
        }

        return currencyTable.get(currencyName);
    }
}
