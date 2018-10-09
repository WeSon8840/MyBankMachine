/*
 *  
 */
package mybankmachine;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloria Song
 */
public class MyBankMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         while (true) {
            String option = JOptionPane.showInputDialog("Would you like to:\n1. Deposit\n2. Withdraw\n3. View your balance.\n4. Set up intrest\n5. Exit");
            
        switch (option) {
            case "1":
            // deposit
                try {
                    MyBankMachine.bank.deposit(Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?")));
                    } 
                catch (Exception e) {// failsafe
                    if (e instanceof NumberFormatException) {
                        JOptionPane.showMessageDialog(null,"You must enter a valid number to deposit." );
                            break;
                        }
                    }

            case "2":
            // withdraw
                try {
                    MyBankMachine.bank.withdraw(Double.parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?")));
                    }
                catch (Exception e) {
                    if (e instanceof NumberFormatException) {
                        JOptionPane.showMessageDialog(null, "You must enter a valid number to withdraw.");
                            break;
                        }
                        JOptionPane.showMessageDialog(null,"You have exceeded you maximum withdraw limit of: "
                                        + MyBankMachine.bank.getBalance());
                    }
                    break;
                
            case "3":
            // balance
                JOptionPane.showMessageDialog(null,"The bank name : RBC Royal Bank\n" +
                        "Your balance is: " + MyBankMachine.bank.getBalance());
                
                    break;
                
            case "4":
            //calculate intrest
                double P = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to start with?"));
                    if (P > MyBankMachine.bank.getBalance()) {
                        JOptionPane.showMessageDialog(null,"You have exceeded you maximum balance of: "
                                        + MyBankMachine.bank.getBalance());
                        continue;
                    }
                    double rateYearly = Double.parseDouble(JOptionPane.showInputDialog("What is the annual intrest rate"));
                    int days = Integer.parseInt(JOptionPane.showInputDialog("How many days would you like to collect intrest?"));
                    double intrest = P * Math.pow((1 + rateYearly/100.0/365.05), days);
                    JOptionPane.showMessageDialog(null, "You have gained $" + intrest + " of intrest over " + days + " days.");
                    break;
                
            case "5":
            // exit
                    System.exit(0);
                    break;
            }
        }
    }
    private static ATM bank = new ATM("My Bank", 0);
    }
    

