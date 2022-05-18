package model.player;

import model.spaces.PurchasableSpace;

public class Player {
    private int id;
    private Wallet wallet = new Wallet();

    private TitleDeeds titleDeeds = new TitleDeeds();
    private int numOfGofj = 0; // Gofj = Get out of jail

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
     * @param price price at which the player bought the property at
     */
    public void buy(PurchasableSpace propertyBought, int price) {
        titleDeeds.addDeed(propertyBought);
        wallet.takeMoney(price);
    }

    public boolean canPay(int money) {
        return wallet.getMoney() >= money;
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

    public int getNumOfGofj() {
        return numOfGofj;
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
