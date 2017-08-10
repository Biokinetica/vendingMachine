package app;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import org.junit.Before;


public class Machine {
    /**
     * @return 
     */
    
    public static class UseMoney{
        public static int coin;
        public static int money;
        public UseMoney(){
            UseMoney.coin = 0;
            UseMoney.money = 0;
        }
  
        public int getCoin() {
            return UseMoney.coin;
        }

        public int getMoney() {
            return UseMoney.money;
        }
        public void setCoin(int c){
            UseMoney.coin = c;
        }
        public void setMoney(int m){
            UseMoney.money = m;
        }
    }
    public static UseMoney CoinExchange = new UseMoney();


    
    public static boolean AcceptCoin(int moneyInserted, UseMoney coin){
        
                if(moneyInserted == 10 || moneyInserted == 25 || moneyInserted == 5){
                    CoinExchange.setCoin(coin.getCoin() + moneyInserted);
                    System.out.println(moneyInserted + " cents inserted. " + coin.getCoin() + " total");
                    return true;
                }
                else
                    System.out.println("Not a valid coin.");
                    
   
        return false;
        
    }
    
    public static boolean ChooseItem(int choice, int itemStock[]){
        if(choice == 1 && (CoinExchange.getCoin() >= 100)){
            
            if(itemStock[0] == 0){
                System.out.println("OUT OF STOCK");
                return false;
            }
            
            CoinExchange.setCoin(CoinExchange.getCoin() - 100);
            itemStock[0] -= 1;
            System.out.println("Dispensing " + CoinExchange.getCoin() + " cents in change");
            System.out.println("THANK YOU");
            return true;
        }
        else if(choice == 2 && (CoinExchange.getCoin() >= 50)){
            
            if(itemStock[1] == 0){
                System.out.println("OUT OF STOCK");
                return false;
            }
            
            CoinExchange.setCoin(CoinExchange.getCoin() - 50);
            itemStock[1] -= 1;
            System.out.println("Dispensing " + CoinExchange.getCoin() + " cents in change");
            System.out.println("THANK YOU");
            return true;
        }
        else if(choice == 3 && (CoinExchange.getCoin() >= 65)){
            
            if(itemStock[2] == 0){
                System.out.println("OUT OF STOCK");
                return false;
            }
            CoinExchange.setCoin(CoinExchange.getCoin() - 65);
            itemStock[2] -= 1;
            System.out.println("Dispensing " + CoinExchange.getCoin() + " cents in change");
            System.out.println("THANK YOU");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        boolean Chosen = false;
        int[] itemStock = {10,10,10};
        Scanner read = new Scanner(System.in);
        //int money = 0;
        
        
        while (!Chosen) {
            System.out.print("INSERT COIN (Type '5','10', or '25' without the quotes)"
                        + "\nChoose Cola for $1 by typing '1',"
                        + "\nChips for $0.50 by typing '2',"
                        + "\nCandy for $0.65 by typing '3'\n");
            
               
                    if(read.hasNext()){
                 CoinExchange.setMoney(Integer.parseInt(read.nextLine()));
                    read.reset();
                    }
                
                
                //We could try to buy at any point!
                if(CoinExchange.getMoney() == 1 || CoinExchange.getMoney() == 2 || CoinExchange.getMoney() ==3){
                      Chosen = ChooseItem(CoinExchange.getMoney(),itemStock);
                      break;
                }
            if(CoinExchange.getMoney() != 0)
              AcceptCoin(CoinExchange.getMoney(),CoinExchange);
                
        }
        
    }

}
