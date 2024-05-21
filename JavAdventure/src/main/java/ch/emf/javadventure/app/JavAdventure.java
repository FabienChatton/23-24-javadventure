/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ch.emf.javadventure.app;

import ch.emf.javadventure.models.IElement;
import ch.emf.javadventure.views.VintageGameView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.json.JSONArray;

import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * The JavAdventure class serves as the entry point for the JavAdventure application.
 * It initializes the game view and loads the initial room data from a JSON file.
 * 
 * @author <a href="mailto:fanny.riedo@edufr.ch">Fanny Riedo</a>
 * @since 18.05.2024
 */

public class JavAdventure {

    public static int[] currentRoom;

    /**
     * The main method starts the JavAdventure application.
     * It sets the initial room coordinates and initializes the game view.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        currentRoom = new int[]{0, 1, 0}; // start on ground floor, center room.
        
        
        

        SwingUtilities.invokeLater(() -> {
            VintageGameView view = new VintageGameView();
            loadJsonData(view);
        });
    }

    /**
     * Loads the JSON data for the current room and updates the game view.
     *
     * @param view the game view to be updated with the room data
     */
    private static void loadJsonData(VintageGameView view) {
        try (InputStream is = JavAdventure.class.getResourceAsStream("/data/data.json")) {
            if (is == null) {
                throw new IOException("Resource not found: /data/data.json");
            }

            JSONObject jsonObject = new JSONObject(new JSONTokener(is));
            JSONObject room = jsonObject.getJSONObject(String.valueOf(currentRoom[0]))
                    .getJSONObject(String.valueOf(currentRoom[1]))
                    .getJSONObject(String.valueOf(currentRoom[2]));

            view.drawRoomMap(room.getString("roomMap"));
            view.setRoomDescription(room.getString("roomDescription"));
            view.setMapLegend("ici sera la légende");
            view.setOutputText("informations supplémentaires");

            JSONArray elementsArray = room.getJSONArray("elements");
            List<IElement> elements = new ArrayList<>();
            for (int i = 0; i < elementsArray.length(); i++) {
                JSONObject elementObject = elementsArray.getJSONObject(i);
                String type = elementObject.getString("type");
                int elementX = elementObject.getInt("x");
                int elementY = elementObject.getInt("y");
                // elements.add(new IElement(type, elementX, elementY)); // ajouter des monstres, portes etc
            }
            // Pour chacun des éléments dans la liste, on le dessinera sur la carte et si nécessaire dans la légende
            view.setMapCharacter('ç',5,5);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
