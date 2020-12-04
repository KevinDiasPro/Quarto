package g41481.quarto.model;

/**
 *
 * @author Kevin Dias
 */
public class Board {

    public static final int SIZE = 4;
    private Piece[][] pieces;

    /*
     * Constructor of the class Board.
     */
    public Board() {
        this.pieces = new Piece[SIZE][SIZE];
    }

    /*
     * Constructor of the class Board.
     *@param pieces it gives a board with pieces
     */
    public Board(Piece[][] pieces) {
        this.pieces = pieces;
    }

    /*
     *  This method shows if the position on the board is free
     * @param position Position on the board
     * @return boolean if the position is free or not
     */
    public boolean isFree(Position position) {
        return this.pieces[position.getRow()][position.getColumn()] == null;
    }

    /*
     *This method add a piece in a position of the board
     *@param1 piece The piece to add to the board
     *@param2 position The position on the board
     */
    public void addPiece(Piece piece, Position position) throws QuartoException {
        if (!isFree(position)) {
            throw new QuartoException("la position n'est pas libre");
        } else {
            this.pieces[position.getRow()][position.getColumn()] = piece;
        }
    }

    /**
     * Method who shows the board of the Quarto
     *
     * @return String with the board
     */
    public String toString() {
        String board = "    1   2   3   4\n  -----------------";
        for (int row = 1; row <= SIZE; row++) {
            board += "\n " + row + "|";
            for (int column = 1; column <= SIZE; column++) {
                if (this.isFree(new Position(row, column)) == true) {
                    board += "   |";
                } else {
                    board += "" + pieces[row - 1][column - 1].getShape().asChar() + " " + pieces[row - 1][column - 1].getColor().asChar() + "|";
                }
                if (column == SIZE) {
                    board += "\n  |";
                    for (int column2 = 1; column2 <= SIZE; column2++) {
                        if (this.isFree(new Position(row, column2)) == true) {
                            board += "   |";
                        } else {
                            board += "" + pieces[row - 1][column2 - 1].getSize().asChar() + " " + pieces[row - 1][column2 - 1].getFilling().asChar() + "|";
                        }
                    }
                }
            }
            board += "\n  -----------------";
        }
        return board;
    }

    /**
     * This method checks if the board contains a winning combination on it
     *
     * @return boolean if a winning combination exists
     */
    public boolean hasAlignement() {
        //horizontal
        if (checkCharacteristic(pieces[0][0], pieces[0][1], pieces[0][2], pieces[0][3])
                || checkCharacteristic(pieces[1][0], pieces[1][1], pieces[1][2], pieces[1][3])
                || checkCharacteristic(pieces[2][0], pieces[2][1], pieces[2][2], pieces[2][3])
                || checkCharacteristic(pieces[3][0], pieces[3][1], pieces[3][2], pieces[3][3])
                //vertical
                || checkCharacteristic(pieces[0][0], pieces[1][0], pieces[2][0], pieces[3][0])
                || checkCharacteristic(pieces[0][1], pieces[1][1], pieces[2][1], pieces[3][1])
                || checkCharacteristic(pieces[0][2], pieces[1][2], pieces[2][2], pieces[3][2])
                || checkCharacteristic(pieces[0][3], pieces[1][3], pieces[2][3], pieces[3][3])
                //diagonal
                || checkCharacteristic(pieces[0][0], pieces[1][1], pieces[2][2], pieces[3][3])
                || checkCharacteristic(pieces[3][0], pieces[2][1], pieces[1][2], pieces[0][3])) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if at least one characteristic is the same between the
     * four pieces
     *
     * @param piece1 The first piece to be compared.
     * @param piece2 The second piece to be compared.
     * @param piece3 The third piece to be compared.
     * @param piece4 The fourth piece to be compared.
     * @return boolean if a characteristic is the same between the four pieces
     */
    private boolean checkCharacteristic(Piece piece1, Piece piece2, Piece piece3, Piece piece4) {
        if (piece1 == null || piece2 == null || piece3 == null || piece4 == null) {
            return false;
        }

        if (piece1.getShape() == piece2.getShape() && piece2.getShape() == piece3.getShape() && piece3.getShape() == piece4.getShape()
                || piece1.getColor() == piece2.getColor() && piece2.getColor() == piece3.getColor() && piece3.getColor() == piece4.getColor()
                || piece1.getSize() == piece2.getSize() && piece2.getSize() == piece3.getSize() && piece3.getSize() == piece3.getSize()
                || piece1.getFilling() == piece2.getFilling() && piece2.getFilling() == piece3.getFilling() && piece3.getFilling() == piece4.getFilling()) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the board is full
     *
     * @return boolean if the board is full
     */
    public boolean isFull() {
        for (int row = 1; row <= this.pieces.length; row++) {
            for (int column = 1; column <= this.pieces.length; column++) {
                if (this.isFree(new Position(row, column)) == true) {
                    return false;
                }
            }
        }
        return true;
    }
    public Piece getPiece(Position position){
        return this.pieces[position.getRow()][position.getColumn()];
    }
}
