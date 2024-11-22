import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;


public class GUI {

        ////////////////////////////////////////////////
    public static void main(String[] args) {
        //ADDED THIS
//hi
        Designs FrontEnd = new Designs();
        FrontEnd.Menu();
    }
}

class Configurations{
    //config
    protected static String[] currencies = {
            "USD", "PHP", "CNY", "EUR", "AED", 
            "KRW", "JPY", "INR", "CAD", "THB", 
            "MXN", "VND", "CHF", "SGD", "SAR", 
            "PLN", "RON", "MYR", "RUB", "AUD"
        };

    protected static String flagLeft = "whiteflag.jpg";
    protected static String flagRight = "whiteflag.jpg";

    protected static String countryLeft = "Country";
    protected static String countryRight = "Country";

    protected static String countryCodeLeft = "XXX";
    protected static String countryCodeRight = "XXX";

    protected static int convertedCurrency = 0;
    protected static String strConvertedCurrency = String.valueOf(convertedCurrency); // Converts convertedCurrency to String for GUI.

    //REPETITIVE GUI COORDS

    protected static int CountryFlagXAxisCoords = 25;
    protected static int CountryFlagYAxisCoords = 20;

    protected static int CountryTextXAxisCoords = 50; //Country Text X axis
    protected static int CountryTextYAxisCoords = 130;

    protected static int CountryCodeXAxisCoords = 65;
    protected static int CountryCodeYAxisCoords = 170;

    protected static int CountryDropdownXAxisCoords = 40;
    protected static int CountryDropdownYAxisCoords = 270;
}


class Designs extends Configurations {
        CurrencyData rates = new CurrencyData(); //Get currency data
        convert converter = new convert(); //get a converter

        
    public Designs() {}

    public String getFlagImage(String currencyCode) {
        switch (currencyCode) {
            case "USD": return "usa.png";
            case "EUR": return "EUR.png";
            case "PHP": return "PHP.png";
            case "AED": return "AED.png";
            case "AUD": return "AUD.png";
            case "CHF": return "CHF.png";
            case "CNY": return "CNY.png";
            case "INR" : return "INR.png";
            case "JPY" : return "JPY.png";
            case "KRW" : return "KRW.png";
            case "MXN" : return "MXN.png";
            case "MYR" : return "MYR.png";
            case "PLN" : return "PLN.png";
            case "RON" : return "RON.png";
            case "RUB" : return "RUB.png";
            case "SAR" : return "SAR.png";
            case "SGD" : return "SGD.png";
            case "VND" : return "VND.png";
            case "THB" : return "THB.jpg";
            case "CAD" : return "CND.png";
           



           // add more in here 
            default: return "whiteflag.jpg";
        }
    }

    public String getCountryName(String currencyCode) {
        switch (currencyCode) {
            case "USD": return "United States";
            case "EUR": return "European Union";
            case "PHP": return "Philippines";
            case "AED": return "United Arab Emirates";
            case "AUD": return "Australia";
            case "CHF": return "Switzerland";
            case "CNY": return "China";
            case "INR": return "India";
            case "JPY": return "Japan";
            case "KRW": return "South Korea";
            case "MXN": return "Mexico";
            case "MYR": return "Malaysia";
            case "PLN": return "Poland";
            case "RON": return "Romania";
            case "RUB": return "Russia";
            case "SAR": return "Saudi Arabia";
            case "SGD": return "Singapore";
            case "VND": return "Vietnam";
            case "THB": return "Thailand";
            case "CAD": return "Canada";
            // Add more cases as needed
            default: return "Unknown Country";
        }
    }
    
    public String getCountryCode(String currencyCode) {
        switch (currencyCode) {
            case "USD": return "USD";
            case "EUR": return "EUR";
            case "PHP": return "PHP";
            case "AED": return "AED";
            case "AUD": return "AUD";
            case "CHF": return "CHF";
            case "CNY": return "CNY";
            case "INR" : return "INR";
            case "JPY" : return "JPY";
            case "KRW" : return "KRW";
            case "MXN" : return "MXN";
            case "MYR" : return "MYR";
            case "PLN" : return "PLN";
            case "RON" : return "RON";
            case "RUB" : return "RUB";
            case "SAR" : return "SAR";
            case "SGD" : return "SGD";
            case "VND" : return "VND";
            case "THB" : return "THB";
            case "CAD" : return "CND";
            // Add more cases as needed
            default: return "XXX";
        }
    }

    

    public void Menu() {

        // Mother of all GUI
        JFrame frame = new JFrame();

        // Button objects
        JToggleButton swap = new JToggleButton();
        JButton submit = new JButton(); 
 

        ImageIcon swapLogo = new ImageIcon("swap.jpg");

        // Swap button configurations
        swap.setBounds(75, 35, 50, 50);
        swap.setIcon(swapLogo);

        submit.setBounds(200, 35, 200, 35);
        submit.setText("Submit");

        //-------------------------------------------------------------------//

        JPanel topIntro = new JPanel();
        topIntro.setBackground(Color.orange);
        topIntro.setBounds(0,0,600,63);

        JLabel topIntroText = new JLabel();

        topIntroText.setText("CSCC20 FINAL PROJECT");

        topIntroText.setBounds(50, 100,300,50);
        
        topIntro.add(topIntroText);

        //-------------------------------------------------------------------// SIDE BAR 

        //IM NOT A DESIGNER UHUHUHU
        StringBuilder currencyData = new StringBuilder();
        
        currencyData.append("USD - United States Dollar - US - Exchange Rate: 1.0\n");
        currencyData.append("PHP - Philippine Peso - PH - Exchange Rate: 56.64\n");
        currencyData.append("CNY - Chinese Yuan - CN - Exchange Rate: 7.02\n");
        currencyData.append("EUR - European Euro - EU - Exchange Rate: 0.91\n");
        currencyData.append("AED - United Arab Emirates Dirham - AE - Exchange Rate: 3.67\n");
        currencyData.append("KRW - South Korean Won - KR - Exchange Rate: 1346.87\n");
        currencyData.append("JPY - Japanese Yen - JP - Exchange Rate: 148.72\n");
        currencyData.append("INR - Indian Rupee - IN - Exchange Rate: 84.03\n");
        currencyData.append("CAD - Canadian Dollar - CA - Exchange Rate: 1.36\n");
        currencyData.append("THB - Thai Baht - TH - Exchange Rate: 33.28\n");
        currencyData.append("MXN - Mexican Peso - MX - Exchange Rate: 20.14\n");
        currencyData.append("VND - Vietnamese Dong - VN - Exchange Rate: 25289.85\n");
        currencyData.append("CHF - Swiss Franc - CH - Exchange Rate: 0.88\n");
        currencyData.append("SGD - Singaporean Dollar - SG - Exchange Rate: 1.33\n");
        currencyData.append("SAR - Saudi Riyal - SA - Exchange Rate: 3.76\n");
        currencyData.append("PLN - Polish złoty - PL - Exchange Rate: 4.05\n");
        currencyData.append("RON - Romanian Leu - RO - Exchange Rate: 4.65\n");
        currencyData.append("MYR - Malaysian Ringgit - MY - Exchange Rate: 4.41\n");
        currencyData.append("RUB - Russian Ruble - RU - Exchange Rate: 98.00\n");
        currencyData.append("AUD - Australian Dollar - AU - Exchange Rate: 1.52\n");

        JLabel currencyInfo = new JLabel("<html>" + currencyData.toString().replace("\n", "<br>") + "</html>");
        
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        currencyInfo.setFont(labelFont);
        
        
        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(200,0,400,463);
        overlayPanel.setBackground(Color.green);
        overlayPanel.setVisible(false);

        overlayPanel.add(currencyInfo);

        JPanel rightHotBar = new JPanel();
        rightHotBar.setBackground(Color.cyan);
        rightHotBar.setBounds(600, 0, 36, 463);
        rightHotBar.setLayout(null); // Disable layout manager to manually position components

        JButton rightHotBarInvisibleButton = new JButton();
        rightHotBarInvisibleButton.setBounds(0, 0, rightHotBar.getWidth(), rightHotBar.getHeight()); // Fill entire panel

        rightHotBarInvisibleButton.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        rightHotBarInvisibleButton.setBorderPainted(false); // Remove the border
        rightHotBarInvisibleButton.setContentAreaFilled(false); // Make sure it has no content area
        rightHotBarInvisibleButton.setFocusPainted(false); // Remove focus painting

        rightHotBarInvisibleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                overlayPanel.setVisible(!overlayPanel.isVisible());
            }
        });

        rightHotBar.add(rightHotBarInvisibleButton);

        frame.add(overlayPanel);

        //-----------------------------------------------------------------//

        JPanel left = new JPanel();
        left.setBackground(Color.red);
        left.setBounds(0, 63, 200, 300);

        JLabel leftDesignFlag = new JLabel();
        ImageIcon inputCountry = new ImageIcon(flagLeft);

        leftDesignFlag.setIcon(inputCountry);
        leftDesignFlag.setBounds(CountryFlagXAxisCoords, CountryFlagYAxisCoords, 150, 100);

        JLabel leftDesignCountryName = new JLabel();
        leftDesignCountryName.setText(countryLeft);
        leftDesignCountryName.setBounds(CountryTextXAxisCoords, CountryTextYAxisCoords, 200, 30);
        leftDesignCountryName.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel leftDesignCountryCode = new JLabel();
        leftDesignCountryCode.setText(countryCodeLeft);
        leftDesignCountryCode.setBounds(CountryCodeXAxisCoords, CountryCodeYAxisCoords, 200, 30);
        leftDesignCountryCode.setFont(new Font("Arial", Font.PLAIN, 35));

        JTextField leftDesignInputAmount = new JTextField(); //use this
        leftDesignInputAmount.setBounds(40, 215, 120, 40);

        JComboBox<String> currencyComboBox = new JComboBox<>(currencies);
        currencyComboBox.setBounds(CountryDropdownXAxisCoords, CountryDropdownYAxisCoords, 120, 30);  //COMBO BOX left and right

  
        
        left.setLayout(null);

        left.add(leftDesignFlag);
        left.add(leftDesignCountryName);
        left.add(leftDesignCountryCode);
        left.add(leftDesignInputAmount);
        left.add(currencyComboBox);

        //------------------------------------------------------------//

        JPanel middle = new JPanel();
        middle.setBackground(Color.green);
        middle.setBounds(200, 63, 200, 300);
        middle.setLayout(null);

        middle.add(swap);

        //-----------------------------------------------------------//

        JPanel right = new JPanel();
        right.setBackground(Color.blue);
        right.setBounds(400, 63, 200, 300);

        JLabel rightDesignFlag = new JLabel();
        ImageIcon outputCountry = new ImageIcon(flagRight);

        rightDesignFlag.setBounds(CountryFlagXAxisCoords, CountryFlagYAxisCoords, 150, 100);
        rightDesignFlag.setIcon(outputCountry);

        JLabel rightCountryDesignName = new JLabel();
        rightCountryDesignName.setText(countryRight);
        rightCountryDesignName.setBounds(CountryTextXAxisCoords, CountryTextYAxisCoords, 200, 30);
        rightCountryDesignName.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel rightDesignCountryCode = new JLabel();
        rightDesignCountryCode.setText(countryCodeLeft);
        rightDesignCountryCode.setBounds(CountryCodeXAxisCoords, CountryCodeYAxisCoords, 200, 30);
        rightDesignCountryCode.setFont(new Font("Arial", Font.PLAIN, 35));

        JLabel rightDesignAmountNum = new JLabel();
        rightDesignAmountNum.setText(strConvertedCurrency);
        rightDesignAmountNum.setBounds(92, 210, 100, 30);
        rightDesignAmountNum.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel rightDesignAmountText = new JLabel();
        rightDesignAmountText.setText("Amount");
        rightDesignAmountText.setBounds(75, 233, 120, 40);
        rightDesignAmountText.setFont(new Font("Arial", Font.PLAIN, 15));

        JComboBox<String> currencyComboBox2 = new JComboBox<>(currencies);
        currencyComboBox2.setBounds(CountryDropdownXAxisCoords, CountryDropdownYAxisCoords, 120, 30); 

        currencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                String flagImage = getFlagImage(selectedCurrency);
                leftDesignFlag.setIcon(new ImageIcon(flagImage));
        
                String countryName = getCountryName(selectedCurrency);
                leftDesignCountryName.setText(countryName);
        
                String countryCode = getCountryCode(selectedCurrency);
                leftDesignCountryCode.setText(countryCode);
                leftDesignInputAmount.setText(""); //resets

                
            }
        });
        currencyComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurrency = (String) currencyComboBox2.getSelectedItem();
                String flagImage = getFlagImage(selectedCurrency);
                rightDesignFlag.setIcon(new ImageIcon(flagImage));
        
                String countryName = getCountryName(selectedCurrency);
                rightCountryDesignName.setText(countryName);
        
                String countryCode = getCountryCode(selectedCurrency);
                rightDesignCountryCode.setText(countryCode);
                rightDesignAmountNum.setText(""); // resets when picking a country
            }
        });

        right.setLayout(null);
        right.add(rightDesignFlag);
        right.add(rightCountryDesignName);
        right.add(rightDesignCountryCode);
        right.add(currencyComboBox2);
        right.add(rightDesignAmountText);
        right.add(rightDesignAmountNum);


        //------------------------------------------------------------//

        swap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // storing left and right panel values
                String tempCurrencyLeft = (String) currencyComboBox.getSelectedItem();
                String tempCurrencyRight = (String) currencyComboBox2.getSelectedItem();
                String tempInputAmount = leftDesignInputAmount.getText();
                String tempConvertedAmount = rightDesignAmountNum.getText();
        
                // Swap the values between the left and right panels
                currencyComboBox.setSelectedItem(tempCurrencyRight);
                currencyComboBox2.setSelectedItem(tempCurrencyLeft);
        
                leftDesignInputAmount.setText(tempConvertedAmount);
                rightDesignAmountNum.setText(tempInputAmount);
        
                // Update the flags, country names, and codes
                leftDesignFlag.setIcon(new ImageIcon(getFlagImage((String) currencyComboBox.getSelectedItem())));
                leftDesignCountryName.setText(getCountryName((String) currencyComboBox.getSelectedItem()));
                leftDesignCountryCode.setText(getCountryCode((String) currencyComboBox.getSelectedItem()));
        
                rightDesignFlag.setIcon(new ImageIcon(getFlagImage((String) currencyComboBox2.getSelectedItem())));
                rightCountryDesignName.setText(getCountryName((String) currencyComboBox2.getSelectedItem()));
                rightDesignCountryCode.setText(getCountryCode((String) currencyComboBox2.getSelectedItem()));
            }
        });  

        //------------------------------------------------------------//

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.yellow);
        bottom.setBounds(0, 363, 600, 100);
        bottom.setLayout(null);
        bottom.add(submit);

        frame.setVisible(true);
        frame.setSize(650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.add(topIntro);
        frame.add(rightHotBar);

        frame.add(left);
        frame.add(middle);
        frame.add(right);
        frame.add(bottom);
              submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dsfsfnsfsd");
                String amountget = leftDesignInputAmount.getText();
                double amount = Double.parseDouble(amountget);
                String source = (String) currencyComboBox.getSelectedItem();
                String target = (String) currencyComboBox2.getSelectedItem();
                double convertedAmount = converter.convert(amount, source, target, rates); 
                rightDesignAmountNum.setText(Double.toString(convertedAmount));
            }});
    }
}

class Currency { //class that serves as a constructor for currencies
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

