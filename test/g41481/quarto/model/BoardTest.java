package g41481.quarto.model;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Kevin Dias
 */
public class BoardTest {

    /**
     * Test if a position free when is free.
     */
    @Test
    public void case1_isFree() {
        Position onePosition = new Position(3, 3);
        Board oneBoard = new Board();
        assertTrue(oneBoard.isFree(onePosition));

    }

    /**
     * Test if a position is free when is not free.
     *
     * @throws QuartoException if the method receives a wrong data
     */
    @Test
    public void case2_isFree() throws QuartoException {
        Position onePosition = new Position(1, 1);
        Board oneBoard = new Board();
        Piece onePiece = new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW);
        oneBoard.addPiece(onePiece, onePosition);
        assertFalse(oneBoard.isFree(onePosition));
    }

    /**
     * Test if the method addPiece() give the piece at the good position.
     *
     * @throws QuartoException if the method receives a wrong data
     */
    @Test
    public void case1_addPiece() throws QuartoException {
        Position onePosition = new Position(2, 2);
        Board oneBoard = new Board();
        Piece onePiece = new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW);
        oneBoard.addPiece(onePiece, onePosition);
        assertFalse(oneBoard.isFree(onePosition));

    }

    /**
     * Test if the position is free when we added a piece
     *
     * @throws QuartoException if the method receives a wrong data
     */
    @Test
    public void case3() throws QuartoException {
        Board board1 = new Board();
        Position position = new Position(2, 2);
        Piece piece = new Piece(Shape.ROUND, Color.WHITE, Size.TALL, Filling.HOLLOW);
        board1.addPiece(piece, position);
        assertFalse(board1.isFree(position));
    }

    @Test
    public void case1_isFull() throws QuartoException {
        Stock stock = new Stock();
        Board board = new Board();
        int row = 1;
        int column = 1;
        for (int i = 1; i < 16; i++) {

            board.addPiece(stock.takePiece(1), new Position(row, column));
            column++;
            if (column == 5) {
                row++;
                column = 1;
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    public void case2_isFull() throws QuartoException {
        Stock stock = new Stock();
        Board board = new Board();
        int row = 1;
        int column = 1;
        for (int i = 1; i <= 16; i++) {

            board.addPiece(stock.takePiece(1), new Position(row, column));
            column++;
            if (column == 5) {
                row++;
                column = 1;
            }
        }
        assertTrue(board.isFull());

    }

    @Test
    public void case3_isFull() {
        Board board1 = new Board();
        assertFalse(board1.isFull());
    }

    /**
     * Test the method hasAlignment() It has an alignment horizontal on the
     * first raw
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case1_hasAlignment() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(1, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(1, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 4));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignment() It has an alignement horizontal on the
     * second raw
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case2_hasAlignment() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(2, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(2, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(2, 4));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has an alignement vertical on the
     * first column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case3_hasAlignment() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 1));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has an alignement vertical on the
     * third column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case4_hasAlignment() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 3));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has an alignement on the diagonal.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case5_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 4));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has an alignement on the other
     * diagonal.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case6_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 1));
        assertTrue(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() when It has not an alignement horizontal
     * on the first row.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case7_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.SQUARE, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(1, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(1, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 4));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has not an alignement horizontal on
     * the third row.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case8_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.SQUARE, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(3, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(3, 4));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has not an alignement vertical on the
     * first column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case9_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 1));
        board.addPiece(new Piece(Shape.SQUARE, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 1));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has not an alignement vertical on the
     * second column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case10_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        board.addPiece(new Piece(Shape.SQUARE, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 2));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has not an alignement on the diagonal.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case11_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        board.addPiece(new Piece(Shape.SQUARE, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 4));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() It has not an alignement on the other
     * diagonal.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case12_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 3));
        board.addPiece(new Piece(Shape.SQUARE, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 1));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() when a piece is missing in the alignement
     * vertical on the first column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case13_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() when a piece is missing in the alignement
     * vertical on the last column.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case14_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() when a piece is missing in the alignement
     * on the diagonal.
     *
     * @throws QuartoException if receive an incoherent value.
     */
    @Test
    public void case15_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(2, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(4, 4));

        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method hasAlignement() when a piece is missing in the alignement
     * on the other diagonal.
     *
     * @throws QuartoException if receive a incoherent value.
     */
    @Test
    public void case16_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(3, 2));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(1, 1));
        assertFalse(board.hasAlignement());

    }

    /**
     * Test the method if it throws the exception when a piece is missing in the
     * alignement horizontal on the first row.
     *
     * @throws QuartoException if receive a incoherent value.
     */
    @Test
    public void case17_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(1, 1));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(1, 3));
        board.addPiece(new Piece(Shape.SQUARE, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(1, 4));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        assertFalse(board.hasAlignement());
    }

    /**
     * Test the method if it throws the exception when a piece is missing in the
     * alignement horizontal on the third column.
     *
     * @throws QuartoException if receive a incoherent value.
     */
    @Test
    public void case18_hasAlignement() throws QuartoException {

        Board board = new Board();

        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.SHORT, Filling.HOLLOW), new Position(2, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(3, 3));
        board.addPiece(new Piece(Shape.SQUARE, Color.WHITE, Size.SHORT, Filling.SOLID), new Position(1, 3));
        board.addPiece(new Piece(Shape.ROUND, Color.BLACK, Size.TALL, Filling.HOLLOW), new Position(2, 2));
        assertFalse(board.hasAlignement());
    }

}
