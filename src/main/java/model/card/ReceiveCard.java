package model.card;

import model.player.Player;

public class ReceiveCard extends Card {
    private int amountToReceive;

    public ReceiveCard(String description, int amountToReceive) {
        super(description);
        this.amountToReceive = amountToReceive;
    }

    @Override
    public void whenDrawn(Player player) {

    }
}
