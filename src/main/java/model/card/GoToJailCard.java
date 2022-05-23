package model.card;

import model.player.Player;

public class GoToJailCard extends Card{
    public GoToJailCard(String description) {
        super(description);
    }

    @Override
    public void whenDrawn(Player player) {
        player.goToJail();
    }
}
