/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

/**
 *
 * @author Gloria Song
 */
public class ATM {
        //variables for characteristics

    private final String BankName;
    private double Balance ; 
    
    //constructors
    public ATM(String Name, double balance) {
        this.BankName = Name;
        this.Balance = balance;
    }
    public void displayBalance() {
        System.out.println("Your balance is: " + Balance);
    }
    
    public void withdraw(double amount){
        if (this.Balance - amount < 0) {
            System.out.println("Maximum withdrawal reached!");
            //this.Balance = amount;
        }
        else {
            this.Balance -= amount ;
        }
    }
    
    public void deposit(double amount){
        if (amount > 200) {
            System.out.println("Deposit exceed 200.");
            //this.Balance = amount;
        }
        else{
            this.Balance += amount;
        }
    }
     
    public double getBalance() {
    return Balance;
    }
        
}
