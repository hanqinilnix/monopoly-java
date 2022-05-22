package model.spaces;

import commons.ColorGroup;

public final class Property extends PurchasableSpace {
    private static int MAX_NUM_OF_HOUSE = 32;
    private static int MAX_NUM_OF_HOTEL = 12;

    private final ColorGroup colorGroup;
    private final int housePrice;
    /**
     * Rents should contain the following information: Unimproved rent, rents for the with 1, 2, 3, and 4 houses and hotel rent in this order.
     */
    private final int[] rents;

    private int numOfHouses = 0;
    private boolean hasHotel = false;

    public Property(String name, int position, int price, ColorGroup colorGroup, int housePrice, int[] rents) {
        super(name, position, price);
        this.colorGroup = colorGroup;
        this.housePrice = housePrice;
        this.rents = rents;
    }

    public void buyHouse() {
        if (canBuyHouse()) {
            numOfHouses += 1;
            MAX_NUM_OF_HOUSE -= 1;
        }
    }

    public void buyHotel() {
        if (canBuyHotel()) {
            numOfHouses = 0;
            MAX_NUM_OF_HOUSE += 4;
            MAX_NUM_OF_HOTEL -= 1;
        }
    }

    public void sellHouse() {
        if (canSellHouse()) {
            numOfHouses -= 1;
            MAX_NUM_OF_HOUSE += 1;
        }
    }

    public void sellHotel() {
        if (canSellHotel()) {
            numOfHouses = 4;
            MAX_NUM_OF_HOUSE -= 4;
            MAX_NUM_OF_HOTEL += 1;
        }
    }

    public boolean canBuyHotel() {
        if (hasHotel) {
            return false;
        }

        if (numOfHouses < 4) {
            return false;
        }

        return numOfHouses == 4 && MAX_NUM_OF_HOTEL > 0;
    }

    public boolean canSellHotel() {
        assert numOfHouses == 0;

        return hasHotel;
    }

    private boolean canBuyHouse() {
        assert MAX_NUM_OF_HOUSE <= 32;

        if (hasHotel) {
            return false;
        }

        if (MAX_NUM_OF_HOUSE <= 0) {
            return false;
        }

        if (numOfHouses == 4) {
            return false;
        }

        return true;
    }

    private boolean canSellHouse() {
        assert MAX_NUM_OF_HOUSE <= 32;

        if (hasHotel) {
            return false;
        }

        if (numOfHouses <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public int getRent() {
        if (numOfHouses == 0 && deeds.hasCompleteColorGroup(colorGroup)) {
            return rents[numOfHouses] * 2;
        }

        if (hasHotel) {
            return rents[-1];
        }

        return rents[numOfHouses];
    }

    // getter methods

    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getNumOfHouses() {
        return numOfHouses;
    }

    public boolean getHasHotel() {
        return hasHotel;
    }
}
