package g41481.quarto.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Kevin Dias
 */
public class Piece implements Serializable{

    private Shape shape;
    private Color color;
    private Size size;
    private Filling filling;

    /**
     * Constructor of the class Piece.
     *
     * @param shape it gives the value to the shape.
     * @param color it gives the value to the color.
     * @param size it gives the value to the size.
     * @param filling it gives the value to the filling.
     * @throws IllegalArgumentException it gives an IllegalArgumentException if
     * one character is null.
     */
    public Piece(Shape shape, Color color, Size size, Filling filling) {
        if (shape == null || color == null || size == null || filling == null) {
            throw new IllegalArgumentException("At least one character of the piece is null");
        } else {
            this.shape = shape;
            this.color = color;
            this.size = size;
            this.filling = filling;
        }
    }

    /**
     * Gives the value of the shape
     *
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Gives the value of the color
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gives the value of the size
     *
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Gives the value of the filling
     *
     * @return the filling
     */
    public Filling getFilling() {
        return filling;
    }

    /**
     * Gives the hashcode of the piece
     *
     * @return the hashcode
     */
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.shape);
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.size);
        hash = 67 * hash + Objects.hashCode(this.filling);
        return hash;
    }

    /**
     * Method who shows the attribut of the class Piece
     *
     * @return String with the attributes of the Piece's class
     */
    public String toString() {
        return shape + "," + color + "," + size + "," + filling;
    }

    /**
     * Compare two objects
     *
     * @param obj the object to compare
     * @return Boolean if the object is equal to the current object
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.shape != other.shape) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (this.filling != other.filling) {
            return false;
        }
        return true;
    }

    /**
     * Setter of the shape
     *
     * @param shape the shape to set
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Setter of the color
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Setter of the size
     *
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Setter of the filling
     *
     * @param filling the filling to set
     */
    public void setFilling(Filling filling) {
        this.filling = filling;
    }
}
