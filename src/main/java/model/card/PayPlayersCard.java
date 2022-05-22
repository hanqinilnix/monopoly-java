package model.card;

import model.player.Player;

public class PayPlayersCard extends Card {
    private int amountToPay;

    public PayPlayersCard(String description, int amountToPay) {
        super(description);
        this.amountToPay = amountToPay;
    }

    @Override
    public void whenDrawn(Player player) {

    }
}
