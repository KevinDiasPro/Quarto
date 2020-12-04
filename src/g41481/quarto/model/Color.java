
package g41481.quarto.model;

/**
 *
 * @author Kevin Dias
 */
public enum Color {

    WHITE,BLACK;

    /**
     * The method asChar returns the first letter of the enumeration
     * @return the first letter of the color
     */
    public char asChar() {
        
        return this.toString().charAt(0);
    }
    
}
