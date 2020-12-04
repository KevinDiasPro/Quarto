package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class FillingTest {
    /*
     * Test the methode asChar() of the filling,
     * if it returns the correct answer
     *
     */

    @Test
    public void case1_AsChar() {
        Filling unFilling = Filling.HOLLOW;
        char reponse = 'H';
        char resultat = unFilling.asChar();
        assertEquals(reponse, resultat);
    }
    /*
     * Test the methode asChar() of the filling,
     * if it returns the correct answer
     *
     */

    @Test
    public void case2_AsChar() {
        Filling unFilling = Filling.SOLID;
        char reponse = 'S';
        char resultat = unFilling.asChar();
        assertEquals(reponse, resultat);
    }

}
