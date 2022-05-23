package model.card;

import model.player.Player;

public class CollectFromPlayersCard extends Card {
    private final int amountToCollect;

    public CollectFromPlayersCard(String description, int amountToCollect) {
        super(description);
        this.amountToCollect = amountToCollect;
    }

    @Override
    public void whenDrawn(Player player) {

    }
}
