package g41481.quarto.model;

/**
 *
 * @author Kevin Dias
 */
public enum Shape {

    ROUND, SQUARE;

    /**
     * The method asChar returns the first letter of the enumeration
     *
     * @return the first letter of the shape
     */
    public char asChar() {
        return this.toString().charAt(0);
    }
}
