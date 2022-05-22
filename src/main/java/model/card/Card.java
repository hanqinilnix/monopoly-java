package model.card;

import model.player.Player;

public abstract class Card {
    protected String cardDescription;

    public Card(String description) {
        cardDescription = description;
    }

    public abstract void whenDrawn(Player player);

    public String getCardDescription() {
        return cardDescription;
    }
}
