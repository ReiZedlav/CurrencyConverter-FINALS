import javax.swing.*;
import javax.swing.border.Border;

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

    protected static String flagLeft = "img/misc/whiteflag.jpg";
    protected static String flagRight = "img/misc/whiteflag.jpg";

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
        public String getsymbol(String currencyCode){
            switch (currencyCode){
                case "USD": return "$";
                case "EUR": return "€";
                case "PHP": return "₱";
                case "AED": return "د.إ";
                case "AUD": return "$";
                case "CHF": return "CHF";
                case "CNY": return "¥";
                case "INR": return "₹";
                case "JPY": return "¥";
                case "KRW": return "₩";
                case "MXN": return "$";
                case "MYR": return "RM";
                case "PLN": return "zł";
                case "RON": return "lei";
                case "RUB": return "₽";
                case "SAR": return "﷼.";
                case "SGD": return "$";
                case "VND": return "₫";
                case "THB": return "฿";
                case "CAD": return "$";
                default: return "";
            }
            
        }
        
    public Designs() {}

    public String getFlagImage(String currencyCode) {
        switch (currencyCode) {
            case "USD": return "img/flag/usa.png";
            case "EUR": return "img/flag/EUR.png";
            case "PHP": return "img/flag/PHP.png";
            case "AED": return "img/flag/AED.png";
            case "AUD": return "img/flag/AUD.png";
            case "CHF": return "img/flag/CHF.png";
            case "CNY": return "img/flag/CNY.png";
            case "INR" : return "img/flag/INR.png";
            case "JPY" : return "img/flag/JPY.png";
            case "KRW" : return "img/flag/KRW.png";
            case "MXN" : return "img/flag/MXN.png";
            case "MYR" : return "img/flag/MYR.png";
            case "PLN" : return "img/flag/PLN.png";
            case "RON" : return "img/flag/RON.png";
            case "RUB" : return "img/flag/RUB.png";
            case "SAR" : return "img/flag/SAR.png";
            case "SGD" : return "img/flag/SGD.png";
            case "VND" : return "img/flag/VND.png";
            case "THB" : return "img/flag/THB.jpg";
            case "CAD" : return "img/flag/CND.png";
           



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

        // Misc designs
        ImageIcon swapLogo = new ImageIcon("img/misc/swap.png");
        ImageIcon submitLogo = new ImageIcon("img/misc/subbutton.png");
        ImageIcon design = new ImageIcon("img/misc/background.png");
        ImageIcon sidearrow = new ImageIcon("img/misc/sidebarrow.jpg");

        // Swap button configurations
        swap.setBounds(65, 35, 75, 75);
        swap.setIcon(swapLogo);
        swap.setBorderPainted(false);
        swap.setContentAreaFilled(false);

        // The submit button
        submit.setBounds(200, 35, 200, 35);
        submit.setIcon(submitLogo);
        
        // Border, green squares
        Color borderColor = new Color(113, 140, 105);
        Border normalBorder = BorderFactory.createLineBorder(borderColor, 3);

        //-------------------------------------------------------------------//

        JPanel topIntro = new JPanel();
        topIntro.setBackground(new Color(1, 60, 90));
        topIntro.setBounds(0,0,600,63);

        JLabel topIntroText = new JLabel();
        topIntroText.setFont(new Font("Arial", Font.ITALIC, 40));
        topIntroText.setForeground(new Color(255, 255, 255));
        topIntroText.setText("CSCC20 Currency Converter");
        topIntroText.setBounds(50, 100,320,50);
        
        topIntro.add(topIntroText);

        //-------------------------------------------------------------------// SIDE BAR 

        //IM NOT A DESIGNER UHUHUHU
        StringBuilder currencyData = new StringBuilder();
        
        currencyData.append("<html><table border='1' cellpadding='2' cellspacing='0' style='border-collapse: collapse;'>");

        // Table header row with Currency Code, Country Name, and Exchange Rate
        currencyData.append("<tr><th>Currency Code</th><th>Country Name</th><th>Exchange Rate</th></tr>");

        // Append each currency data as a new row, including the country name
        currencyData.append("<tr><td>USD</td><td>United States</td><td>1.0</td></tr>");
        currencyData.append("<tr><td>PHP</td><td>Philippines</td><td>56.64</td></tr>");
        currencyData.append("<tr><td>CNY</td><td>China</td><td>7.02</td></tr>");
        currencyData.append("<tr><td>EUR</td><td>European Union</td><td>0.91</td></tr>");
        currencyData.append("<tr><td>AED</td><td>United Arab Emirates</td><td>3.67</td></tr>");
        currencyData.append("<tr><td>KRW</td><td>South Korea</td><td>1346.87</td></tr>");
        currencyData.append("<tr><td>JPY</td><td>Japan</td><td>148.72</td></tr>");
        currencyData.append("<tr><td>INR</td><td>India</td><td>84.03</td></tr>");
        currencyData.append("<tr><td>CAD</td><td>Canada</td><td>1.36</td></tr>");
        currencyData.append("<tr><td>THB</td><td>Thailand</td><td>33.28</td></tr>");
        currencyData.append("<tr><td>MXN</td><td>Mexico</td><td>20.14</td></tr>");
        currencyData.append("<tr><td>VND</td><td>Vietnam</td><td>25289.85</td></tr>");
        currencyData.append("<tr><td>CHF</td><td>Switzerland</td><td>0.88</td></tr>");
        currencyData.append("<tr><td>SGD</td><td>Singapore</td><td>1.33</td></tr>");
        currencyData.append("<tr><td>SAR</td><td>Saudi Arabia</td><td>3.76</td></tr>");
        currencyData.append("<tr><td>PLN</td><td>Poland</td><td>4.05</td></tr>");
        currencyData.append("<tr><td>RON</td><td>Romania</td><td>4.65</td></tr>");
        currencyData.append("<tr><td>MYR</td><td>Malaysia</td><td>4.41</td></tr>");
        currencyData.append("<tr><td>RUB</td><td>Russia</td><td>98.00</td></tr>");
        currencyData.append("<tr><td>AUD</td><td>Australia</td><td>1.52</td></tr>");

        // Close the HTML table structure
        currencyData.append("</table></html>");



        // Create the JLabel with the formatted HTML table
        JLabel currencyInfo = new JLabel(currencyData.toString());
        
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        currencyInfo.setFont(labelFont);
        currencyInfo.setForeground(new Color(244, 162, 88));
        
        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(200,0,400,463);
        overlayPanel.setBackground(new Color(0, 46, 70));
        overlayPanel.setVisible(false);

        overlayPanel.add(currencyInfo);

        //-----------------------------------------------------------------//

        JPanel rightHotBar = new JPanel();
        rightHotBar.setBackground(new Color(0, 46, 70));
        rightHotBar.setBounds(600, 0, 36, 463);
        rightHotBar.setLayout(null); // Disable layout manager to manually position components

        JLabel sideArrow = new JLabel();
        sideArrow.setBounds(0, 0, 36, 463);
        sideArrow.setIcon(sidearrow);

        rightHotBar.add(sideArrow);

        //------------------------------------------------------------//

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


        //-----------------------------------------------------------------//

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setBounds(0, 63, 200, 300);

        JLabel leftDesignFlag = new JLabel();
        ImageIcon inputCountry = new ImageIcon(flagLeft);

        leftDesignFlag.setIcon(inputCountry);
        leftDesignFlag.setBounds(CountryFlagXAxisCoords, CountryFlagYAxisCoords, 150, 100);

        JLabel leftDesignCountryName = new JLabel();
        leftDesignCountryName.setText(countryLeft);
        leftDesignCountryName.setBounds(13, CountryTextYAxisCoords, 175, 30);
        leftDesignCountryName.setHorizontalAlignment(SwingConstants.CENTER);
        leftDesignCountryName.setBorder(normalBorder);
        leftDesignCountryName.setFont(new Font("Arial", Font.ITALIC, 16));

        JLabel leftDesignCountryCode = new JLabel();
        leftDesignCountryCode.setText(countryCodeLeft);
        leftDesignCountryCode.setBounds(50, CountryCodeYAxisCoords, 100, 40);
        leftDesignCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
        leftDesignCountryCode.setBorder(normalBorder);
        leftDesignCountryCode.setFont(new Font("Arial", Font.BOLD, 35));

        JTextField leftDesignInputAmount = new JTextField(); //use this
        leftDesignInputAmount.setBounds(40, 215, 120, 40);
        leftDesignInputAmount.setFont(new Font("Arial", Font.PLAIN, 18));

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
        middle.setOpaque(false);
        middle.setBounds(200, 63, 200, 300);
        middle.setLayout(null);

        middle.add(swap);

        //-----------------------------------------------------------//

        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setBounds(400, 63, 200, 300);

        JLabel rightDesignFlag = new JLabel();
        ImageIcon outputCountry = new ImageIcon(flagRight);

        rightDesignFlag.setBounds(CountryFlagXAxisCoords, CountryFlagYAxisCoords, 150, 100);
        rightDesignFlag.setIcon(outputCountry);

        JLabel rightCountryDesignName = new JLabel();
        rightCountryDesignName.setText(countryRight);
        rightCountryDesignName.setBounds(13, CountryTextYAxisCoords, 175, 30);
        rightCountryDesignName.setHorizontalAlignment(SwingConstants.CENTER);
        rightCountryDesignName.setBorder(normalBorder);
        rightCountryDesignName.setFont(new Font("Arial", Font.ITALIC, 18));

        JLabel rightDesignCountryCode = new JLabel();
        rightDesignCountryCode.setText(countryCodeLeft);
        rightDesignCountryCode.setBounds(50, CountryCodeYAxisCoords, 100, 40);
        rightDesignCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
        rightDesignCountryCode.setBorder(normalBorder);
        rightDesignCountryCode.setFont(new Font("Arial", Font.BOLD, 35));

        JLabel rightDesignAmountNum = new JLabel();
        rightDesignAmountNum.setText(strConvertedCurrency);
        rightDesignAmountNum.setBounds(0, 215, 200, 30);
        rightDesignAmountNum.setHorizontalAlignment(SwingConstants.CENTER);
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
                // Storing the left and right panel values
                String tempCurrencyLeft = (String) currencyComboBox.getSelectedItem();
                String tempCurrencyRight = (String) currencyComboBox2.getSelectedItem();
                
                // Get the amount from the left and right panels
                String tempInputAmount = leftDesignInputAmount.getText();
                String tempConvertedAmount = rightDesignAmountNum.getText();
        
                // Clean the amounts by removing symbols to avoid bad recalc
                String cleanedInputAmount = tempInputAmount.replaceAll("[^0-9.]", "");  
                String cleanedConvertedAmount = tempConvertedAmount.replaceAll("[^0-9.]", ""); 
        
                // Swap the values between the left and right panels (numeric values only)
                currencyComboBox.setSelectedItem(tempCurrencyRight);
                currencyComboBox2.setSelectedItem(tempCurrencyLeft);
                
                // Set the cleaned values to the left and right design inputs (without currency symbols)
                leftDesignInputAmount.setText(cleanedConvertedAmount);  // Use the converted amount (cleaned)
                rightDesignAmountNum.setText(cleanedInputAmount);       // Use the original input (cleaned)
                
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
        bottom.setOpaque(false);
        bottom.setBounds(0, 363, 600, 100);
        bottom.setLayout(null);
        bottom.add(submit);

        //------------------------------------------------------------//

        JPanel Fancybackground = new JPanel();
        Fancybackground.setBackground(Color.MAGENTA);
        Fancybackground.setBounds(0, 0, 600, 465);
        Fancybackground.setLayout(null);

        JLabel maindesign = new JLabel();
        maindesign.setBounds(0, 0, 600, 465);
        maindesign.setIcon(design);

        Fancybackground.add(maindesign);

        //------------------------------------------------------------//

        frame.setVisible(true);
        frame.setSize(650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        frame.add(overlayPanel);
        frame.add(topIntro);
        frame.add(rightHotBar);
        
        frame.add(left);
        frame.add(middle);
        frame.add(right);
        frame.add(bottom);
        frame.add(Fancybackground);
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dsfsfnsfsd");
        
                
                String amountget = leftDesignInputAmount.getText();
                String cleanedAmount = amountget.replaceAll("[^0-9.]", "");  // to remove the symbols
                double amount = Double.parseDouble(cleanedAmount); 
        
                // Get the selected source and target currencies
                String source = (String) currencyComboBox.getSelectedItem();
                String target = (String) currencyComboBox2.getSelectedItem();
        
                // Perform the conversion using the cleaned amount and the selected currencies
                double convertedAmount = converter.convert(amount, source, target, rates);
        
                // Format the result (add the symbol for the target currency) and display the converted amount
                String formattedAmount = getsymbol(target) + String.format("%.2f", convertedAmount);
                rightDesignAmountNum.setText(formattedAmount);  // Set the result in the right panel
            }
        });
        
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



