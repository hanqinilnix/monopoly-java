package model.card;

import model.player.Player;

public class PayAllPlayersCard extends Card {
    private int amountToPay;

    public PayAllPlayersCard(String description, int amountToPay) {
        super(description);
        this.amountToPay = amountToPay;
    }

    @Override
    public void whenDrawn(Player player) {

    }
}
