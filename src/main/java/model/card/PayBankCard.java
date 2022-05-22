package model.card;

import model.player.Player;

public class PayBankCard extends Card {
    private int amountToPay;

    public PayBankCard(String description, int amountToPay) {
        super(description);
        this.amountToPay = amountToPay;
    }

    @Override
    public void whenDrawn(Player player) {

    }
}
