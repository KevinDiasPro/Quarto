package g41481.quarto.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class SizeTest {
    /*
     * Test the methode asChar() of the size,
     * if it returns the correct answer
     *
     */

    @Test
    public void case1_AsChar() {
        Size unSize = Size.SHORT;
        char reponse = 'S';
        char resultat = unSize.asChar();
        assertEquals(reponse, resultat);

    }
    /*
     * Test the methode asChar() of the size,
     * if it returns the correct answer
     *
     */

    @Test
    public void case2_AsChar() {
        Size unSize = Size.TALL;
        char reponse = 'T';
        char resultat = unSize.asChar();
        assertEquals(reponse, resultat);

    }
}
