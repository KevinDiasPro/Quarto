
package g41481.quarto.model;
/**
 *
 * @author Kevin Dias
 */
public class MainTest {

    public static void main(String[] args) throws QuartoException {

        Board board2 = new Board();
        System.out.println("Voici le tableau vide : \n" + board2);
        Stock stock = new Stock();
        System.out.println("Voici le stock initial : \n" + stock);
        

        //Initialisation pieces
        Piece piece1 = stock.takePiece(15);
        Piece piece2 = stock.takePiece(14);
        Piece piece3 = stock.takePiece(13);

        //Initialisation positions
        Position position1 = new Position(1, 1);
        Position position2 = new Position(1, 3);
        Position position3 = new Position(1, 2);

        //Adding pieces to the board
        
       board2.addPiece(piece1, position1);
       board2.addPiece(piece2, position2);
       board2.addPiece(piece3, position3);

        System.out.println("Voici le tableau apres l'ajout de pieces : \n" + board2);
        System.out.println("La taille du stock apres enlevement des pieces : " + stock.size());
        System.out.println("Voici la liste restante des objets du stock : \n" + stock);

    }

}
