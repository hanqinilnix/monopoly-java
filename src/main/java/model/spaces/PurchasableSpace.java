package model.spaces;

import model.player.Player;
import model.player.TitleDeeds;

public abstract class PurchasableSpace extends Space {
    protected final int price;

    protected Player owner;
    protected TitleDeeds deeds;
    private boolean isMortgaged = false;

    protected PurchasableSpace(String name, int price) {
        super(name);
        this.price = price;
    }

    public void buyBy(Player player) {
        owner = player;
        deeds = player.getTitleDeeds();
    }

    public void tradeWith(Player newOwner) {
        owner = newOwner;
        deeds = newOwner.getTitleDeeds();
    }

    public int mortgageProperty() {
        isMortgaged = true;
        return price / 2;
    }

    public int mortgageInterest() {
        return (int) (price * 0.1);
    }

    public int payMortgage() {
        isMortgaged = false;
        return price / 2 + mortgageInterest();
    }

    public abstract int getRent();

    // getter methods

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean getIsMortgaged() {
        return isMortgaged;
    }
}
