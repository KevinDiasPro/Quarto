package g41481.quarto.model;

/**
 *
 * @author Kevin Dias
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor of Position.
     *
     * @param row the row of the board
     * @param column the column of the board
     * @throws IllegalArgumentException if one of the numbers is not in the
     * board
     */
    public Position(int nRow, int nColumn) {
        if (nRow <= 0 || nColumn <= 0 || nRow > Board.SIZE || nColumn > Board.SIZE) {
            throw new IllegalArgumentException("The position is not on the board");
        } else {
            row = nRow - 1;
            column = nColumn - 1;
        }
    }

    /**
     * Gives the value of the row
     *
     * @return the raw
     */
    public int getRow() {
        return row;
    }

    /**
     * Gives the value of the column
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    

}
