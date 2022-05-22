package model.spaces;

import commons.Dice;

public final class Utility extends PurchasableSpace {
    public Utility(String name, int position, int price) {
        super(name, position, price);
    }

    @Override
    public int getRent() {
        Dice dice = new Dice();
        int rent = dice.roll();

        int numOfUtilities = deeds.getNumOfUtilities();
        if (numOfUtilities == 1) {
            return rent * 4;
        }
        assert numOfUtilities == 2;
        return rent * 10;
    }
}
