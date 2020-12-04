package g41481.quarto.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author G41481
 */
public class Player implements Serializable {

    private String name;
    /*
     Constructor of the class Player
    @param name of the player
     */

    public Player(String name) {
        this.name = name;
    }

    /**
     * Gives the value of the name
     *
     * @return the name
     */
    public String getName() {
        return "" + name;
    }

    /**
     * Changes the value of the name
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     This method saves the player one
     @param player1 the player number one
     @throws IOException
     */

    public void player1Save(Player player1) throws IOException {
        try {
            FileOutputStream player1Save = new FileOutputStream("Player1.quarto");
            ObjectOutputStream player = new ObjectOutputStream(player1Save);
            try {
                player.writeObject(this);
                player.flush();
                System.out.println(player1 + " a été serialisé");
            } finally {

                try {
                    player.close();
                } finally {
                    player1Save.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     This method loads the player one
     @return player the player one we loaded
     @throws1 IOException
     @throws2 ClassNotFoundException
     */

    public static Player player1Load() throws IOException, ClassNotFoundException {
        Player player1 = null;
        try {
            FileInputStream player1Load = new FileInputStream("Player1.quarto");
            ObjectInputStream player = new ObjectInputStream(player1Load);
            try {
                //  player1 = (Player) player1.readObject();
            } finally {
                try {
                    player1Load.close();
                } finally {
                    player.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if (player1 != null) {
            System.out.println(player1 + " a été deserialisé");
        }
        return player1;
    }
    /*
     This method saves the player number two
     @param player2 the player number two
     @throws IOException
     */

    public void player2Save(Player player2) throws IOException {
        try {
            FileOutputStream player2Save = new FileOutputStream("Player2.quarto");
            ObjectOutputStream player = new ObjectOutputStream(player2Save);
            try {
                player.writeObject(this);
                player.flush();
                System.out.println(player2 + " a été serialisé");
            } finally {

                try {
                    player.close();
                } finally {
                    player2Save.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     This method loads the player two
     @return player the player two we loaded
     @throws1 IOException
     @throws2 ClassNotFoundException
     */

    public static Player player2Load() throws IOException, ClassNotFoundException {
        Player player2 = null;
        try {
            FileInputStream player2Load = new FileInputStream("Player2.quarto");
            ObjectInputStream player = new ObjectInputStream(player2Load);
            try {
                //     player2 = (Player) player2.readObject();
            } finally {
                try {
                    player2Load.close();
                } finally {
                    player.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if (player2 != null) {
            System.out.println(player2 + " a été deserialisé");
        }
        return player2;
    }

}
