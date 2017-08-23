package app;

import java.util.Scanner;


public class Machine {

    public static InsertMoney CoinExchange = new InsertMoney();

    public static boolean AcceptCoin(int moneyInserted, InsertMoney coin){
        
                if(moneyInserted == 10 || moneyInserted == 25 || moneyInserted == 5){
                    CoinExchange.setCoin(coin.getCoin() + moneyInserted);
                    System.out.println(moneyInserted + " cents inserted. " + coin.getCoin() + " total");
                    return true;
                }
                else
                    System.out.println("Not a valid coin.");
                    
   
        return false;
        
    }
    public static boolean IsOutOfStock(int stock){
        if(stock == 0){
                System.out.println("OUT OF STOCK");
                return true;
            }
        else
            return false;
    }
    public static String ChooseItemHelper(int moneyAmount, int itemStock[]){
        CoinExchange.setCoin(CoinExchange.getCoin() - moneyAmount);
            itemStock[0] -= 1;
            String confirmationMessage = "Dispensing " + CoinExchange.getCoin() + " cents in change";
            System.out.println(confirmationMessage);
            System.out.println("THANK YOU");
            return confirmationMessage;
    }
    public static boolean ChooseItem(int choice, int itemStock[]){
        if(choice == 1 && (CoinExchange.getCoin() >= 100)){
            
            if(IsOutOfStock(itemStock[0])){
                return false;
            }
            
            ChooseItemHelper(100,itemStock);
            return true;
        }
        else if(choice == 2 && (CoinExchange.getCoin() >= 50)){
            
            if(itemStock[1] == 0){
                System.out.println("OUT OF STOCK");
                return false;
            }
            
            ChooseItemHelper(50,itemStock);
            return true;
        }
        else if(choice == 3 && (CoinExchange.getCoin() >= 65)){
            
            if(itemStock[2] == 0){
                System.out.println("OUT OF STOCK");
                return false;
            }
            ChooseItemHelper(65,itemStock);
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
