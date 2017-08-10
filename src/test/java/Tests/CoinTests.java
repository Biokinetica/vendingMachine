/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import app.Machine;
import java.util.Random;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Brenton
 */
public class CoinTests {
        boolean Accepted;
        boolean Chosen;
        int coin;
        int random;
        int[] item = {10,10,10};
        int[] emptyItem = {0,0,0};
        public static Machine.UseMoney CoinExchange = new Machine.UseMoney();
        @Before
              public void SetUp(){
                  CoinExchange.setCoin(0);
                  CoinExchange.setMoney(0);
                  Accepted = false;
                  Chosen = false;
                  Random rn = new Random();
                    int range = 50 - 4 + 1;
                    random =  rn.nextInt(range) + 4;
                  

    }
        
    @Test
    public void InputIsValid(){
      assertTrue(Machine.AcceptCoin(5,CoinExchange));
      assertTrue(Machine.AcceptCoin(10,CoinExchange));
      assertTrue(Machine.AcceptCoin(25,CoinExchange));
      assertFalse(Machine.AcceptCoin(23,CoinExchange));
    }
    @Test
    public void ItemIsChosen(){
        CoinExchange.setCoin(250);
      assertTrue(Machine.ChooseItem(1,item));
      assertTrue(Machine.ChooseItem(2,item));
      assertTrue(Machine.ChooseItem(3,item));
    }
    @Test
    public void WrongItemIsChosen(){
      //Will always choose item between 4-50.
      assertFalse(Machine.ChooseItem(random,item));
    }
    @Test
    public void OutOfStock(){
        
        assertFalse(Machine.ChooseItem(1,emptyItem));
    }
    
    }
