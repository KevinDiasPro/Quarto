package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class ShapeTest {
/*
     * Test the methode asChar() of the shape,
     * if it returns the correct answer
     *
     */
    @Test
    public void case1_AsChar() {
        Shape unShape = Shape.SQUARE;
        char reponse = 'S';
        char resultat = unShape.asChar();
        assertEquals(reponse, resultat);

    }
/*
     * Test the methode asChar() of the shape,
     * if it returns the correct answer
     *
     */
    @Test
    public void case2_AsChar() {
        Shape unShape = Shape.ROUND;
        char reponse = 'R';
        char resultat = unShape.asChar();
        assertEquals(reponse, resultat);

    }
}
