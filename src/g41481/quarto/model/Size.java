package g41481.quarto.model;

import static g41481.quarto.model.Color.WHITE;

/**
 *
 * @author Kevin Dias
 */
public enum Size {

    TALL, SHORT;

    /**
     * The method asChar returns the first letter of the enumeration
     *
     * @return the first letter of the size
     */
    public char asChar() {
        return this.toString().charAt(0);
    }

}
