/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Brenton
 */
public class InsertMoney{
        public static int coins;
        public static int money;
        public InsertMoney(){
            InsertMoney.coins = 0;
            InsertMoney.money = 0;
        }
  
        public int getCoin() {
            return InsertMoney.coins;
        }

        public int getMoney() {
            return InsertMoney.money;
        }
        public void setCoin(int c){
            InsertMoney.coins = c;
        }
        public void setMoney(int m){
            InsertMoney.money = m;
        }
    }
