package model.card;

import model.player.Player;

public class MoveXSpacesCard extends Card {

    private int numOfSteps;

    public MoveXSpacesCard(String description, int numOfSteps) {
        super(description);
        this.numOfSteps = numOfSteps;
    }

    @Override
    public void whenDrawn(Player player) {
        
    }
}