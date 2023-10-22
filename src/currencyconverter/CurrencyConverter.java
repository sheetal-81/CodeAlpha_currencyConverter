package currencyconverter; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class CurrencyConverter extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "Indian Rupee",
                    "Pakistani Rupee",
                    "US Dollar",
                    "Canadian Dollar",
                    "Kenyan Shilling",
                    "Nigerian Naira",
                    "Brazilian Real",
                    "Indonesian Rupiah",
                    "Philippine_Pisco",
            };

    double Indian_Rupee = 95.21;
    double Pakistani_Rupee = 162.74;
    double US_Dollar = 1.31;
    double Canadian_Dollar = 1.71;
    double Kenyan_Shilling = 132.53;
    double Nigerian_Naira = 476.57;
    double Brazilian_Real = 5.47;
    double Indonesian_Rupiah = 19554.94;
    double Philippine_Pisco = 71.17;

    CurrencyConverter()
    {
        setBounds(300,60,790,700);
        getContentPane().setBackground(Color.GRAY);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(150,30,650,60);
        maintitle.setFont(new Font("Viner Hand ITC",Font.BOLD,50));
        maintitle.setForeground(Color.white);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(10,160,170,50);
        from.setFont(new Font("Mongolian Baiti",Font.BOLD,28));
        from.setForeground(Color.white);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        fromcountry.setBounds(100,165,240,40);
        fromcountry.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        //fromcountry.setForeground(Color.white);
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(630,175,250,40);
        fromunit.setFont(new Font("Mongolian Baiti",Font.BOLD,24));
        fromunit.setForeground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(10,310,90,50);
        to.setFont(new Font("Mongolian Baiti",Font.BOLD,28));
        to.setForeground(Color.white);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..", "India", "Pakistan", "USA", "Canada", "Kenyan", "Ngeria", "Brazil", "Indonesia", "Philippine" });
        tocountry.setBounds(100,310,400,40);
        tocountry.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        //tocountry.setForeground(Color.white);
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField("    VALUE WILL BE " );
        Answer.setBounds(20,430,740, 40);
        Answer.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(550,290,320,90);
        tounit.setFont(new Font("Mongolian Baiti",Font.BOLD,24));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        convert = new JButton("Convert Currency");
        convert.setBounds(10,580,200,40);
        convert.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        convert.addActionListener(this);
        add(convert);


        reset = new JButton("Reset");
        reset.setBounds(300,580,200,40);
        reset.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(600,580,170,40);
        exit.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //reset panel
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //to Exit
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new CurrencyConverter();
    }


    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromcountryItemStateChanged
        //units
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tocountryItemStateChanged
        //units
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "Pakistan":
                        amountInPounds = amountToChange / Pakistani_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Kenyan":
                        amountInPounds = amountToChange / Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        amountInPounds = amountToChange / Nigerian_Naira;
                        break;
                    case "Brazil":
                        amountInPounds = amountToChange / Brazilian_Real;
                        break;
                    case "Indonesia":
                        amountInPounds = amountToChange / Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        amountInPounds = amountToChange / Philippine_Pisco;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                    case "Pakistan":
                        newamount = amountInPounds * Pakistani_Rupee;
                        break;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Kenyan":
                        newamount = amountInPounds * Kenyan_Shilling;
                        break;
                    case "Ngeria":
                        newamount = amountInPounds * Nigerian_Naira;
                        break;
                    case "Brazil":
                        newamount = amountInPounds * Brazilian_Real;
                        break;
                    case "Indonesia":
                        newamount = amountInPounds * Indonesian_Rupiah;
                        break;
                    case "Philippine":
                        newamount = amountInPounds * Philippine_Pisco;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }


    }
}