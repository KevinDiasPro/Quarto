/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author Kevin Dias
 */
public class StockTest {

    /**
     * Test the method Size, when the stock is full.
     */
    @Test
    public void case1_Size() {
        Stock stock1 = new Stock();
        assertEquals(16, stock1.size());
    }

    /**
     * Test the method Size, when the stock only has 11 pieces.
     */
    @Test
    public void case2_Size() throws QuartoException {
        Stock stock1 = new Stock();
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);
        assertEquals(11, stock1.size());
    }

    /**
     * Test the method Size, when the stock is empty.
     */
    @Test
    public void case3_Size() throws QuartoException {
        Stock stock1 = new Stock();
        for (int i = 0; i < 16; i++) {
            stock1.takePiece(1);
        }
        assertEquals(0, stock1.size());
    }

    /**
     * Test the method isEmpty, when the stock is full.
     */
    @Test
    public void case1_isEmpty() {
        Stock stock1 = new Stock();
        assertFalse(stock1.isEmpty());
    }

    /**
     * Test the method isEmpty, when the stock contains pieces.
     */
    @Test
    public void case2_isEmpty() throws QuartoException {
        Stock stock1 = new Stock();
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);
        stock1.takePiece(1);

        assertFalse(stock1.isEmpty());

    }

    /**
     * Test the method isEmpty, when the stock is empty.
     */
    @Test
    public void case3_isEmpty() throws QuartoException {
        Stock stock1 = new Stock();
        for (int i = 0; i < 16; i++) {
            stock1.takePiece(1);
        }
        assertTrue(stock1.isEmpty());

    }

    /**
     * Test the method takePiece, if it takes the good piece of the stock.
     */
    @Test
    public void case1_takePiece() throws QuartoException {
        Stock stock1 = new Stock();
        Piece piece = new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.SOLID);
        assertEquals(piece, stock1.takePiece(8));
    }

}
