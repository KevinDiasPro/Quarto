/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41481.quarto.model;

import org.junit.Test;


/**
 *
 * @author Kevin Dias
 */
public class PositionTest {
    
     /**
     * This method tests if the exception is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void case1_Position() {
        Position testPosition = new Position(-1, -2);

    }
    
    
    /**
     * This method tests if the exception is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void case2_Position() {
        Position testPosition = new Position(6, 7);

    }

    /**
     * This method tests if the position created is on the board.
     */
    @Test 
    public void case3_Position() {
        Position testPosition = new Position(2, 3);

    }
    
    /**
     * This method tests if the position created is on the board.
     */
    public void case4_Position() {
        Position testPosition = new Position(0,0);

    }

}


