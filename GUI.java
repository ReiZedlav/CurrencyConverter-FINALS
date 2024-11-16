import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI {

        ////////////////////////////////////////////////
    public static void main(String[] args) {
        //ADDED THIS

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

    protected static int CountryTextXAxisCoords = 70; //Country Text X axis
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
            case "USD": return "usa2.jpg";
            case "EUR": return "EUR.png";
            case "GBP": return "uk.jpg";
           // add more in here 
            default: return "whiteflag.jpg";
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

        submit.setBounds(200, 125, 200, 35);
        submit.setText("Submit");

        //-----------------------------------------------------------------//

        JPanel left = new JPanel();
        left.setBackground(Color.red);
        left.setBounds(0, 0, 200, 300);

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
        middle.setBounds(200, 0, 200, 300);
        middle.setLayout(null);

        middle.add(swap);

        //-----------------------------------------------------------//

        JPanel right = new JPanel();
        right.setBackground(Color.blue);
        right.setBounds(400, 0, 200, 300);

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
            }
        });

        currencyComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurrency = (String) currencyComboBox2.getSelectedItem();
                String flagImage = getFlagImage(selectedCurrency);
                rightDesignFlag.setIcon(new ImageIcon(flagImage));
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

        swap.addActionListener(new ActionListener(){    
            // Method when click 
            public void actionPerformed(ActionEvent e){    
                // what it do when clicked
//            	left.setBounds(400, 0, 200, 300);
//            	right.setBounds(0, 0, 200, 300);
//            	
            	if(swap.isSelected()) {

            		left.setBounds(400, 0, 200, 300);
                	right.setBounds(0, 0, 200, 300);
                } else {

                	right.setBounds(400, 0, 200, 300);
                	left.setBounds(0, 0, 200, 300);
                }
            }    
        });    

        //------------------------------------------------------------//

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.yellow);
        bottom.setBounds(0, 213, 600, 200);
        bottom.setLayout(null);
        bottom.add(submit);

        frame.setVisible(true);
        frame.setSize(600,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

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