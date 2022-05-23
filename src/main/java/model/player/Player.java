package model.player;

import java.util.ArrayList;

import model.card.Card;
import model.spaces.PurchasableSpace;

public class Player {
    private int id;
    private Wallet wallet = new Wallet();

    private TitleDeeds titleDeeds = new TitleDeeds();
    private ArrayList<Card> getOutOfJailList = new ArrayList<>();
    private int turnsInJail = 0;

    /**
     * This method is for property that is bought directly when player lands on the space.
     *
     * @param propertyBought property to be bought by the player
     */
    public void buy(PurchasableSpace propertyBought) {
        titleDeeds.addDeed(propertyBought);
        wallet.takeMoney(propertyBought.getPrice());
    }

    /**
     * This method is for property that is bought through auction.
     *
     * @param propertyBought property to be bought by the player
     * @param price          price at which the player bought the property at
     */
    public void buy(PurchasableSpace propertyBought, int price) {
        titleDeeds.addDeed(propertyBought);
        wallet.takeMoney(price);
    }

    public void receiveMoney(int money) {
        wallet.receiveMoney(money);
    }

    public void giveMoney(int money) {
        wallet.takeMoney(money);
    }

    public boolean canPay(int money) {
        return wallet.getMoney() >= money;
    }

    public void goToJail() {
        turnsInJail = 3;
    }

    public void outOfJail() {
        turnsInJail = 0;
    }

    public void decrementJailTime() {
        turnsInJail--;
        assert turnsInJail >= 0;
    }

    public boolean isInJail() {
        return turnsInJail > 0;
    }

    // getter methods

    public int getId() {
        return id;
    }

    public Wallet wallet() {
        return wallet;
    }

    public TitleDeeds getTitleDeeds() {
        return titleDeeds;
    }

    public ArrayList<Card> getGetOutOfJailList() {
        return getOutOfJailList;
    }

    public int getTurnsInJail() {
        return turnsInJail;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }

        Player player = (Player) obj;
        return player.id == id;
    }

}
