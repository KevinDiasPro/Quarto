package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class ColorTest {
    /*
     * Test the methode asChar() of the color,
     * if it returns the correct answer
     *
     */

    @Test
    public void case1_AsChar() {
        Color uneColor = Color.WHITE;
        char reponse = 'W';
        char resultat = uneColor.asChar();
        assertEquals(reponse, resultat);
    }

    /*
     * Test the methode asChar() of the color,
     * if it returns the correct answer
     *
     */
    @Test
    public void case2_AsChar() {
        Color uneColor = Color.BLACK;
        char reponse = 'B';
        char resultat = uneColor.asChar();
        assertEquals(reponse, resultat);
    }
}
