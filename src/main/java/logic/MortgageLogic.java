package logic;

import model.player.Player;
import model.spaces.PurchasableSpace;

public class MortgageLogic extends Logic {
    private Player player;
    private PurchasableSpace toMortgageSpace;

    public MortgageLogic(Player player, PurchasableSpace toMortgageSpace) {
        this.player = player;
        this.toMortgageSpace = toMortgageSpace;
    }

    @Override
    public void action() {
        // space becomes mortgaged
        int mortgagedMoney = toMortgageSpace.mortgageProperty();

        player.receiveMoney(mortgagedMoney);
    }
}
