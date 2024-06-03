/**
 * Project: Javadventure
 * File: JavAdventure.java
 *
 * Description: This is the main class.
 *
 * Author: Nicolas Schwander
 *
 * Created: 21.05.2024
 *
 * License: GPL License
 *
 */
package ch.emf.javadventure.app;

import ch.emf.javadventure.ctrl.GameCtrl;
import ch.emf.javadventure.ctrl.IGameCtrl;
import ch.emf.javadventure.views.IGameView;
import ch.emf.javadventure.views.VintageGameView;
import javax.swing.SwingUtilities;

/**
 * The JavAdventure class serves as the entry point for the JavAdventure
 * application. It initializes the game view and loads the initial room data
 * from a JSON file.
 *
 * @author <a href="mailto:fanny.riedo@edufr.ch">Fanny Riedo</a>
 * @since 18.05.2024
 */
public class JavAdventure {

    /**
     * The main method starts the JavAdventure application. It sets the initial
     * room coordinates and initializes the game view.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        IGameView view = new VintageGameView();
        IGameCtrl gameCtrl = new GameCtrl();

        view.setGamectrl(gameCtrl);
        gameCtrl.setGameView(view);

        SwingUtilities.invokeLater(() -> {
            gameCtrl.initializeGame();

        });
    }

}
