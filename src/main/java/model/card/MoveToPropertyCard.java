package model.card;

import model.player.Player;
import model.spaces.PurchasableSpace;

public class MoveToPropertyCard extends Card {
    private PurchasableSpace moveToSpace;

    public MoveToPropertyCard(String description, PurchasableSpace moveToSpace) {
        super(description);
        this.moveToSpace = moveToSpace;
    }

    @Override
    public void whenDrawn(Player player) {
        // if not owned, can buy, else auction

        // if utilities, rent is multiplied by 10
        // if stations, rent is doubled
    }
}
