import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CurrencyMain {
    private static LinkedHashMap<String,Currency> enumArray = new LinkedHashMap<>();

    public static final String RUB = "RUB";
    public static final String USD = "USD";

    public static Currency RUB_CURRENCY = new Currency(RUB,1);
    public static Currency USD_CURRENCY = new Currency(USD,2);

    static {
        enumArray.put(RUB,RUB_CURRENCY);
        enumArray.put(USD,USD_CURRENCY);
    }
    public CurrencyMain()

    {

    }

    public List<Currency> getAll(){
        return (List)enumArray.values();
    }

    public static Currency getCurrencyByName(String name){
       return enumArray.get(name);
    }
    public static Currency getByOrdinal(int i) throws Exception {
        if(i>=enumArray.size()) throw new Exception("no such element");
        ArrayList values = (ArrayList) enumArray.values();
        return (Currency) values.get(i);
    }

    public static void main(String[] args) {
        System.out.println(RUB_CURRENCY == RUB_CURRENCY);
    }
}
