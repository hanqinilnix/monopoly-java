package logic;

import model.player.Player;
import model.spaces.PurchasableSpace;

public class BuyLogic extends Logic {
    private final Player owner;
    private final PurchasableSpace toBuySpace;

    public BuyLogic(Player owner, PurchasableSpace toBuySpace) {
        this.owner = owner;
        this.toBuySpace = toBuySpace;
    }

    @Override
    public void action() {
        toBuySpace.buyBy(owner);
        owner.buy(toBuySpace);
    }
}
