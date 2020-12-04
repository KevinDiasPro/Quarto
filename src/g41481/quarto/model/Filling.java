package g41481.quarto.model;

/**
 *
 * @author Kevin Dias
 */
public enum Filling {

    HOLLOW, SOLID;

    /**
     * The method asChar returns the first letter of the enumeration
     *
     * @return the first letter of the filling
     */
    public char asChar() {
        return this.toString().charAt(0);
    }
}
