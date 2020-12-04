package g41481.quarto.view;

import g41481.quarto.model.Board;
import static g41481.quarto.model.Board.SIZE;
import g41481.quarto.model.Position;
import g41481.quarto.model.Stock;

/**
 *
 * @author Kevin Dias
 */
public class Display {

    private Stock stock;
    private Board board;

    public static void displayBoard(Board board) {
        String boardTest = "    1   2   3   4\n  -----------------";
        for (int row = 1; row <= SIZE; row++) {
            boardTest += "\n " + row + "|";
            for (int column = 1; column <= SIZE; column++) {
                if (board.isFree(new Position(row, column)) == true) {
                    boardTest += "   |";
                } else {
                    boardTest += "" + board.getPiece(new Position(row , column )).getShape().asChar() + " " + board.getPiece(new Position(row , column )).getColor().asChar() + "|";
                }
                if (column == SIZE) {
                    boardTest += "\n  |";
                    for (int column2 = 1; column2 <= SIZE; column2++) {
                        if (board.isFree(new Position(row, column2)) == true) {
                            boardTest += "   |";
                        } else {
                            boardTest += "" + board.getPiece(new Position(row , column )).getSize().asChar() + " " + board.getPiece(new Position(row , column )).getFilling().asChar() + "|";
                        }
                    }
                }
            }
            boardTest += "\n  -----------------";
        }
        System.out.println(boardTest);

    }

    public static void displayStock(Stock stock) {
        String aRenvoyer = "";
        for (int i = 1; i <= stock.size(); i++) {
            aRenvoyer += "" + i + " " + stock.getPiece(i-1) + "\n";
        }
        System.out.println(aRenvoyer);
    }
}
