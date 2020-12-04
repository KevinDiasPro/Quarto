package g41481.quarto.view;

import g41481.quarto.model.Quarto;
import g41481.quarto.model.QuartoException;
import java.io.IOException;

/**
 *
 * @author Kevin Dias
 */
public class MainView {

    public static void main(String[] args) throws QuartoException, IOException, ClassNotFoundException {

        QuartoView quartoView = new QuartoView();

        quartoView.play();

    }
}
