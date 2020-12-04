package g41481.quarto.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Kevin Dias
 */
public class Quarto implements Serializable {

    private final Stock stock;
    private final Board board;
    private Piece chosenPiece;

    public Quarto() {
        stock = new Stock();
        board = new Board();
        chosenPiece = null;
    }

    /**
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * This method picks a piece in the stock
     *
     * @param index the number of the piece who is in the stock
     * @throws QuartoException
     */
    public void pickPiece(int index) throws QuartoException {
        if (chosenPiece != null) {
            throw new IllegalStateException("A piece is already selected");
        }
        setChosenPiece(stock.takePiece(index));
    }

    public void setChosenPiece(Piece chosenPiece) {
        this.chosenPiece = chosenPiece;
    }

    /**
     * This method shows the chosen piece
     *
     * @return the chosenPiece
     */
    public Piece getChosenPiece() {
        if (this.chosenPiece == null) {
            throw new IllegalStateException("The piece selected is null");
        }
        return this.chosenPiece;
    }
    /*
     This method places a piece in a position
     @param position The position of the piece
     @throws QuartoException if the position is busy
     */

    public void placePiece(Position position) throws QuartoException {
        if (!board.isFree(position)) {
            throw new QuartoException("The position is busy");
        }
        if (getChosenPiece() == null) {
            throw new IllegalStateException("There is no piece selected");
        }
        board.addPiece(chosenPiece, position);
        this.chosenPiece = null;
    }
    /*
     This method shows if the game is over when the board is full or an alignement exists
     @return boolean if the game is over
     */

    public boolean isOver() {
        if (board.isFull() == true || board.hasAlignement() == true) {
            return true;
        }
        return false;
    }
    /*
     This method swaps the players
     @param1 player1 the player number one
     @param2 player2 the player number two
     */

    public void changePlayer(Player player1, Player player2) {
        Player player3 = new Player(null);
        player3.setName(player1.getName());
        player1.setName(player2.getName());
        player2.setName(player3.getName());
    }

    /*
     This method saves the game
     @param quarto the quarto
     @throws IOException
     */
    public void gameSave(Quarto quarto) throws IOException {
        try {
            FileOutputStream gameSave = new FileOutputStream("Game.quarto");
            ObjectOutputStream game = new ObjectOutputStream(gameSave);
            try {
                game.writeObject(this);
                game.flush();
                System.out.println(quarto + " a été serialisé");
            } finally {

                try {
                    game.close();
                } finally {
                    gameSave.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     This method loads the game
     @return quarto the game we loaded
     @throws1 IOException
     @throws2 ClassNotFoundException
     */

    public static Quarto gameLoad() throws IOException, ClassNotFoundException {
        Quarto quarto = null;
        try {
            FileInputStream gameLoad = new FileInputStream("Game.quarto");
            ObjectInputStream game = new ObjectInputStream(gameLoad);
            try {
                quarto = (Quarto) game.readObject();
            } finally {
                try {
                    game.close();
                } finally {
                    gameLoad.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        if (quarto != null) {
            System.out.println(quarto + " a été deserialisé");
        }
        return quarto;
    }
}
