package g41481.quarto.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Dias
 */
public class Stock implements Serializable {

    private List<Piece> pieces ;

    /**
     * Constructor of the class Stock. It creates the 16 pieces of the stock and
     * it adds to the list
     */
    public Stock() {
        pieces = new ArrayList<Piece>();
        for (Shape shape : Shape.values()) {
            for (Color color : Color.values()) {
                for (Size size : Size.values()) {
                    for (Filling filling : Filling.values()) {
                        pieces.add(new Piece(shape, color, size, filling));
                    }
                }
            }
        }
    }

    /**
     * Method who shows the stock of pieces
     *
     * @return String with the stock
     */
    public String toString() {
        String aRenvoyer = "";
        for (int i = 1; i <= pieces.size(); i++) {
            aRenvoyer += "" + i + " " + pieces.get(i-1).toString() + "\n";
        }
        return aRenvoyer;
    }

    /**
     * This method takes a piece of the stock
     *
     * @param i the place where we want to take the piece
     * @return Piece the piece that we remove
     * @throws QuartoException if the value is not in the stock
     */
    public Piece takePiece(int i) throws QuartoException {
        if (i > this.pieces.size() || i <= 0) {
            throw new QuartoException("I is not in the stock");
        } else {
            Piece toReturn = this.pieces.remove(i - 1);
            return toReturn;

        }
    }

    /**
     * This method gives the size of the list.
     *
     * @return the size
     */
    public int size() {
        return this.pieces.size();
    }

    /**
     * This method confirms if the list is empty.
     *
     * @return Boolean if the stock is empty.
     */
    public boolean isEmpty() {
        return this.pieces.isEmpty();
    }
    public Piece getPiece(int index){
        return this.pieces.get(index);
    }
/*
     This method saves the stock
     @param stock the stock
     @throws IOException
     */
    public void stockSave(Stock stock) throws IOException {
        try {
            FileOutputStream stockSave = new FileOutputStream("Stock.quarto");
            ObjectOutputStream stock2 = new ObjectOutputStream(stockSave);
            try {
                stock2.writeObject(this);
                stock2.flush();
                System.out.println(stock2 + " a été serialisé");
            } finally {

                try {
                    stock2.close();
                } finally {
                    stockSave.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     This method loads the stock
     @return stock the stock we loaded
     @throws1 IOException
     @throws2 ClassNotFoundException
     */

    public static Stock stockLoad() throws IOException, ClassNotFoundException {
        Stock stock = null;
        try {
            FileInputStream stockLoad = new FileInputStream("Game.quarto");
            ObjectInputStream stock2 = new ObjectInputStream(stockLoad);
            try {
           //     stock = (Quarto) stock2.readObject();
            } finally {
                try {
                    stock2.close();
                } finally {
                    stockLoad.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if (stock != null) {
            System.out.println(stock + " a été deserialisé");
        }
        return stock;
    }
}
