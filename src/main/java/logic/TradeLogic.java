package logic;

import model.player.Player;

public class TradeLogic extends Logic {
    private Player player;
    private Player toTradeWithPlayer;

    public TradeLogic(Player currentPlayer, Player toTradeWithPlayer) {
        this.player = currentPlayer;
        this.toTradeWithPlayer = toTradeWithPlayer;
    }

    @Override
    public void action() {
        // display the titles deeds of current player
        // display the money of current player
        // display GOJF card

        // display the titles deeds of toTradeWithPlayer
        // display the money of toTradeWithPlayer
        // display GOJF card (if any)

        // current player choose things to trade with
        // choose things to trade with toTradeWithPlayer

        // toTradeWithPlayer confirms or decline the offer

        // to back to the normal stuff
    }
}
