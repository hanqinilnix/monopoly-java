package model.card;

import model.player.Player;

public class GetOutOfJailCard extends Card {
    public GetOutOfJailCard(String description) {
        super(description);
    }

    @Override
    public void whenDrawn(Player player) {

    }

    public boolean use() {
        return true;
    }
}
