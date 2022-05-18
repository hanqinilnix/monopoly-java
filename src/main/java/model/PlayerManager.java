package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.player.Player;

public class PlayerManager {
    private LinkedList<Player> players = new LinkedList<Player>();

    public PlayerManager(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            players.offer(new Player());
        }
    }

    /**
     * Returns the current player this turn.
     */
    public Player getCurrentPlayer() {
        return players.peek();
    }

    /**
     * Returns the next player this turn.
     */
    public Player getNextPlayer() {
        return players.get(1);
    }

    /**
     * Returns the previous player.
     */
    public Player getPreviousPlayer() {
        return players.getLast();
    }

    /**
     * Returns the player at specified index at this point.
     *
     * @param index
     */
    public Player getPlayerAt(int index) {
        return players.get(index);
    }

    /**
     * Returns all players still in game.
     */
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }

    /**
     * Removes player at the specified index.
     *
     * @param toRemoveIndex the specified index
     */
    public void removePlayer(int toRemoveIndex) {
        players.remove(toRemoveIndex);
    }

    /**
     * Removes specified player.
     *
     * @param toRemovePlayer the specified player
     */
    public void removePlayer(Player toRemovePlayer) {
        players.remove(toRemovePlayer);
    }

    /**
     * Changes the current player.
     */
    public void next() {
        Player currentPlayer = players.poll();
        players.offer(currentPlayer);
    }

    public int getSize() {
        return players.size();
    }
}
