package model.card;

import commons.PurchasableType;
import model.player.Player;

public class AdvanceToNearestCard extends Card {
    private PurchasableType spaceType;
    public AdvanceToNearestCard(String description, PurchasableType spaceType) {
        super(description);
        this.spaceType = spaceType;
    }

    @Override
    public void whenDrawn(Player player) {
        if (spaceType == PurchasableType.STATION) {
            // search for the nearest station
        } else {
            // search for the nearest utility
        }
    }
}
