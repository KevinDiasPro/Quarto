package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class PieceTest {
    /*
     * Test the constructor of the class Piece,
     * if it returns the correct answer
     *
     */

    @Test
    public void case1() {
        Piece test = new Piece(Shape.SQUARE, Color.BLACK, Size.SHORT, Filling.SOLID);
        assertEquals("SQUARE,BLACK,SHORT,SOLID", test.toString());
    }
    /*
     * Test the constructor of the class Piece,
     * if it returns the correct answer
     *
     */

    @Test
    public void case2() {
        Piece test2 = new Piece(Shape.SQUARE, Color.WHITE, Size.TALL, Filling.HOLLOW);
        assertEquals("SQUARE,WHITE,TALL,HOLLOW", test2.toString());
    }
    /*
     * Test the constructor of the class Piece,
     * if it returns the correct answer
     *
     */

    @Test(expected = IllegalArgumentException.class)
    public void case3() {
        Piece test2 = new Piece(Shape.SQUARE, null, Size.TALL, Filling.HOLLOW);
        assertEquals("SQUARE,WHITE,TALL,HOLLOW", test2);
    }
    /*
     * Test the method equals of the class Piece,
     * if it returns the correct answer, here it's true
     *
     */
    @Test
    public void case1_equals() {
        Piece test1 = new Piece(Shape.SQUARE, Color.WHITE, Size.TALL, Filling.HOLLOW);
        Piece test2 = new Piece(Shape.SQUARE, Color.WHITE, Size.TALL, Filling.HOLLOW);
        assertTrue(test1.equals(test2));
    }
    /*
     * Test the  method equals of the class Piece,
     * if it returns the correct answer, here it's false
     *
     */
    @Test
    public void case2_equals() {
        Piece test1 = new Piece(Shape.SQUARE, Color.WHITE, Size.TALL, Filling.HOLLOW);
        Piece test2 = new Piece(Shape.SQUARE, Color.BLACK, Size.TALL, Filling.HOLLOW);
        assertFalse(test1.equals(test2));
    }
}
