/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ch.emf.javadventure.ctrl;

import ch.emf.javadventure.models.Player;
import ch.emf.javadventure.models.Room;
import ch.emf.javadventure.models.RoomElement;
import ch.emf.javadventure.views.IGameView;

/**
 *
 * @author schwandern
 */
public interface IGameCtrl {

    public void setGameView(IGameView gameView);

    public RoomElement[][] move(int key);

    public void initializeGame();
    
    public boolean executeCommand(String command);

}
