import javax.swing.*;
import java.awt.*;

class GUI{
    public static void main(String[] args){
        Designs FrontEnd = new Designs();

        FrontEnd.Menu();
    }
}

class Designs{
    private String flagLeft = "emptyCountry.jpg";
    private String flagRight = "emptyCountry.jpg";

    private String countryLeft = "Country";
    private String countryRight = "Country";

    private String countryCodeLeft = "XXX";
    private String countryCodeRight = "XXX";

    private int convertedCurrency = 0;
    private String strConvertedCurrency = String.valueOf(convertedCurrency); //Converts convertedCurrency to String for GUI.

    public Designs(){}

    public void Menu(){
        //Mother of all GUI
        JFrame frame = new JFrame();

        //Button objects
        JButton swap = new JButton();
        JButton submit = new JButton();

        ImageIcon swapLogo = new ImageIcon("swap.jpg");

        //Swap button configurations
        swap.setBounds(50,35,50,50);
        swap.setIcon(swapLogo);

        submit.setBounds(120,125,200,35); //Submit Bottom size and coordinates.
        submit.setText("Submit");

        //-----------------------------------------------------------------//

        JPanel left = new JPanel();
        left.setBackground(Color.red);
        left.setBounds(0,0,150,300);

        JLabel leftDesignFlag = new JLabel();
        ImageIcon inputCountry = new ImageIcon(flagLeft); //Left flag design

        leftDesignFlag.setIcon(inputCountry);
        leftDesignFlag.setText(countryLeft); 
        leftDesignFlag.setBounds(25,20,100,100);

        JLabel leftDesignCountryName = new JLabel();
        leftDesignCountryName.setText(countryLeft);
        leftDesignCountryName.setBounds(45,130,200,30);
        leftDesignCountryName.setFont(new Font("Arial",Font.PLAIN,18));

        JLabel leftDesignCountryCode = new JLabel();
        leftDesignCountryCode.setText(countryCodeLeft);
        leftDesignCountryCode.setBounds(41,170,200,30);
        leftDesignCountryCode.setFont(new Font("Arial",Font.PLAIN,35));

        JTextField leftDesignInputAmount = new JTextField();
        leftDesignInputAmount.setBounds(15, 220, 120, 40);

        JLabel leftDesignAmountText = new JLabel();
        leftDesignAmountText.setText("Amount");
        leftDesignAmountText.setBounds(50, 230, 100, 100);

        left.setLayout(null);

        left.add(leftDesignFlag);
        left.add(leftDesignCountryName);
        left.add(leftDesignCountryCode);
        left.add(leftDesignInputAmount);
        left.add(leftDesignAmountText);
        //------------------------------------------------------------//

        JPanel middle = new JPanel();
        middle.setBackground(Color.green);
        middle.setBounds(150,0,150,300);
        middle.setLayout(null);

        middle.add(swap);


        //-----------------------------------------------------------//
                
        JPanel right = new JPanel();
        right.setBackground(Color.blue);
        right.setBounds(300,0,150,300);

        JLabel rightDesignFlag = new JLabel();

        ImageIcon outputCountry = new ImageIcon(flagRight); //Left flag design

        rightDesignFlag.setBounds(25,20,100,100);


        JLabel rightCountryDesignName = new JLabel();
        rightCountryDesignName.setText(countryRight);
        rightCountryDesignName.setBounds(45,130,200,30);
        rightCountryDesignName.setFont(new Font("Arial",Font.PLAIN,18));

        JLabel rightDesignCountryCode = new JLabel();
        rightDesignCountryCode.setText(countryCodeLeft);
        rightDesignCountryCode.setBounds(41,170,200,30);
        rightDesignCountryCode.setFont(new Font("Arial",Font.PLAIN,35));

        JLabel rightDesignAmountNum = new JLabel();
        rightDesignAmountNum.setText(strConvertedCurrency);
        rightDesignAmountNum.setBounds(70,225,200,30);
        rightDesignAmountNum.setFont(new Font("Arial",Font.PLAIN,20));

        JLabel rightDesignAmountText = new JLabel();
        rightDesignAmountText.setText("Amount");
        rightDesignAmountText.setBounds(50, 230, 100, 100);

        right.setLayout(null);

        rightDesignFlag.setIcon(outputCountry);
    
        right.add(rightDesignFlag);
        right.add(rightCountryDesignName);
        right.add(rightDesignCountryCode);
        right.add(rightDesignAmountNum);
        right.add(rightDesignAmountText);

        //------------------------------------------------------------//

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.yellow);
        bottom.setBounds(0,213,450,200);
        bottom.setLayout(null);
        bottom.add(submit); //This button not showing up on JPanel

        //----------------------------------------------------------//

        frame.setVisible(true);
        frame.setSize(450,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //frame.setResizable(false);

        frame.add(left);
        frame.add(middle);
        frame.add(right);
        frame.add(bottom);
    }
}