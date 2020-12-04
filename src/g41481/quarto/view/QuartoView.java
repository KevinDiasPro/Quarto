package g41481.quarto.view;

import g41481.quarto.model.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Kevin Dias
 */
public class QuartoView implements Serializable {

    final Quarto quarto;
    static Player player1;
    static Player player2;
    /*
     Constructor of the QuartoView
     */

    public QuartoView() {
        this.quarto = new Quarto();
    }
    /*
    
     This method shows the game
    
     @throws1 QuartoException
     @throws2 IOException
     @throws3 ClassNotFoundException
     */

    public void play() throws QuartoException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------------------"
                + "\n-------------------- QUARTO GAME --------------------"
                + "\n-----------------------------------------------------");
        System.out.println("Auteur G41481 - Dias Kevin");
        String charger = "";
        do {
            System.out.println("Voulez vous charger une partie ? \n 2 choix possible : \n oui\n non");
            charger = scanner.nextLine();
        } while (!charger.equals("oui") && !charger.equals("non"));
        Player player1 = null;
        Player player2 = null;
        Boolean reprendre = null;

        if (charger.equals("oui")) {
          /*  quarto.gameLoad();
            quarto.getStock().stockLoad();
            player1 = player1Load();
            player2 = player2Load();
            System.out.println(player1 + "  " + player2);
            reprendre = true;*/
            System.out.println("------------------------------------------------------"
                    + "\n-------------------- LOADING GAME --------------------"
                    + "\n------------------------------------------------------");
        } else {
            reprendre = false;
            System.out.println("--------------------------------------------------"
                    + "\n-------------------- NEW GAME --------------------"
                    + "\n--------------------------------------------------");
            String name;
            String prenom;
            do {
                System.out.println("Quel est le nom du premier joueur ?");
                name = scanner.nextLine();
                player1 = new Player(name);
                System.out.println("Le nom du premier joueur est " + player1.getName());

                System.out.println("Quel est le nom du deuxieme joueur ?");
                prenom = scanner.nextLine();
                player2 = new Player(prenom);
                System.out.println("Le nom du deuxieme joueur est " + player2.getName());
            } while (name.equals(prenom));
            Random aleatoire = new Random();
            int random = aleatoire.nextInt(2) + 1;
            System.out.println("Le joueur qui commence le jeu est le joueur " + random);

            if (random == 1) {
                System.out.println("Joueur 1 est " + player1.getName() + " et le joueur 2 est " + player2.getName());
            } else {
                quarto.changePlayer(player1, player2);
                System.out.println("Joueur 1 est " + player2.getName() + " et le joueur 2 est " + player1.getName());
            }

        }
        if (reprendre == false) {

            do {
                int piece = 0;
                do {
                    System.out.println("Le stock :");
                    //Showing the stock
                    
                    Display.displayStock(quarto.getStock());
                    System.out.println(player1.getName() + " choisis la piece : \n");
                    System.out.println("Quelle piece voulez-vous?");
                    piece = scanner.nextInt();

                } while (piece > quarto.getStock().size() || piece <= 0);

                quarto.pickPiece(piece);
                System.out.println("La piece choisie est la piece suivante :\n"
                        + quarto.getChosenPiece());

                System.out.println("Voulez-vous continuer le jeu ? \n 2 choix possibles : oui et non ");
                String word = scanner.next();

                if (word.equals("non")) {
                   /* quarto.gameSave(quarto);
                    quarto.getStock().stockSave(quarto.getStock());
                    player.player1Save(player1);
                    player.player2Save(player2);*/
                    System.exit(0);
                }
                Position position;
                do {

                    System.out.println("!!! Choix de la place dans le tableau par " + player2.getName() + "!!!");

                    System.out.println("Dans quelle rangée voulez-vous la placer ? ");
                    int row = scanner.nextInt();

                    System.out.println("Dans quelle colonne voulez-vous la placer ? ");
                    int column = scanner.nextInt();

                    position = new Position(row, column);

                } while (!quarto.getBoard().isFree(position));
                quarto.placePiece(position);
                Display.displayBoard(quarto.getBoard());

                quarto.changePlayer(player1, player2);
            } while (!quarto.isOver());
            if (quarto.getBoard().hasAlignement() == true) {
                System.out.println("Il y a alignement et le vainqueur est " + player1.getName());
            } else {
                System.out.println("Le tableau est rempli et il n'y a pas de vainqueur :(  !!!!!");
            }
        } else {
            Position position;
            do {

                System.out.println("!!! Choix de la place dans le tableau par " + player2.getName() + " !!!");

                System.out.println("Dans quelle rangée voulez la placer ? ");
                int row = scanner.nextInt();

                System.out.println("Dans quelle colonne voulez la placer ? ");
                int column = scanner.nextInt();

                position = new Position(row, column);

            } while (!quarto.getBoard().isFree(position));
            quarto.placePiece(position);
            Display.displayBoard(quarto.getBoard());

            quarto.changePlayer(player1, player2);

            if (quarto.getBoard().hasAlignement() == true) {
                System.out.println("Le vainqueur est " + player1.getName());
            } else {
                reprendre = false;
            }

        }
    }

}
