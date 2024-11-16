import java.util.HashMap;
import java.util.Map;

public class Currency { //class that serves as a constructor for currencies
    //attributes
    private String currencycode; //access modifier
    private double currencyrate;
    private String currencyname;

    //methods
    public Currency(String currencycode, double currencyrate, String currencyname){ //constructors
        this.currencycode = currencycode; //initializing all attributes
        this.currencyrate = currencyrate;
        this.currencyname = currencyname;
    }

    public String getCode() { return currencycode;} //data hiding, getters 
    public void setCode(String currencycode) { this.currencycode = currencycode;}//setters
    public double getRate() { return currencyrate;}
    public void setRate(double currencyrate) { this.currencyrate = currencyrate;}
    public String getName() { return currencyname;}
    public void setName(String currencyname) {this.currencyname = currencyname; }
}

class CurrencyData { //keeps all the currency information
    //attributes
    private HashMap<String, Currency> currencydata = new HashMap<>();
    Currency currency;
    //methods
    public CurrencyData() {
        currencydata.put("USD", new Currency ("USD", 1.0, "United States Dollar"));
        currencydata.put("PHP", new Currency ("PHP", 56.64, "Philippine Peso"));
        currencydata.put("CNY", new Currency ("CNY", 7.02, "Chinese Yuan"));
        currencydata.put("EUR", new Currency ("EUR", 0.91, "European Euro"));
        currencydata.put("AED", new Currency  ("AED", 3.67, "United Arab Emirates Dirham"));
        currencydata.put("KRW", new Currency ("KRW",  1346.87, "South Korean Won"));
        currencydata.put("JPY", new Currency("JPY", 148.72, "Japanese Yen"));
        currencydata.put("INR", new Currency("INR", 84.03, "Indian Rupee"));
        currencydata.put("CAD", new Currency("CAD", 1.36, "Canadian Dollar"));
        currencydata.put("THB", new Currency ("THB", 33.28, "Thai Baht"));
        currencydata.put("MXN", new Currency ("MXN", 20.14, "Mexican Peso"));
        currencydata.put("VND", new Currency ("VND", 25289.85, "Vietnamese Dong"));
        currencydata.put("CHF", new Currency ("CHF", 0.88, "Swiss Franc"));
        currencydata.put("SGD", new Currency ("SGD", 1.33, "Singaporean Dollar"));
        currencydata.put("SAR", new Currency ("SAR", 3.76, "Saudi Riyal"));
        currencydata.put("PLN", new Currency ("PLN", 4.05, "Polish złoty"));
        currencydata.put("RON", new Currency ("RON", 4.65, "Romanian Leu"));
        currencydata.put("MYR", new Currency ("MYR", 4.41, "Malaysian Ringgit"));
        currencydata.put("RUB", new Currency ("RUB", 98.00, "Russian Ruble"));
        currencydata.put("AUD", new Currency ("AUD", 1.52, "Australian Dollar"));
    }
    public double getCDataRate(String currencyCode) { //needed for converter
        currency = currencydata.get(currencyCode);
        return (currency != null) ? currency.getRate() : 0.0;
    }
    public Map<String, Currency> getCurrencies() {return new HashMap<>(currencydata);} //needed for currency display
}

// Converting Abstract class
abstract class converter {
    public double sourceRate;
    public double targetRate;
    public double amount;
    public abstract double convert(double amount, String source, String target, CurrencyData rates);}

class convert extends converter { //initialized subclass
    public double sourceRate;
    public double targetRate;
    public double amount;
    public double convert(double amount, String source, String target, CurrencyData rates) { //constructor initialized
        //attributes
        sourceRate = rates.getCDataRate(source); //get source
        targetRate = rates.getCDataRate(target); //get target
        //methods (if is not a method)
        if (sourceRate == 0.0 || targetRate == 0.0) { throw new IllegalArgumentException("Invalid currency code");} //error catching
        return (amount / sourceRate) * targetRate;  //converting formula
    }
}  
