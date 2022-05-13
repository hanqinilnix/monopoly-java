package model.player;

import java.util.ArrayList;
import java.util.List;

import model.spaces.PurchasableSpace;

public class TitleDeeds {

    private List<PurchasableSpace> deeds = new ArrayList<>();

    private int numOfStations = 0;
    private int numOfUtilities = 0;
    private int[] numOfPropertiesPerColorGroup = new int[8];
    private int[] numOfHousePerPropertiesPerColorGroup = new int[8];

    public void addDeed(PurchasableSpace newDeed) {
        deeds.add(newDeed);
    }

    public void buyHouse(PurchasableSpace propertyToBuyHouse) {

    }

    // getter methods

    public PurchasableSpace getDeedAt(int index) {
        return deeds.get(index);
    }

    public int getNumOfStations() {
        return numOfStations;
    }

    public int getNumOfUtilities() {
        return numOfUtilities;
    }

    public int[] getNumOfPropertiesPerColorGroup() {
        return numOfPropertiesPerColorGroup;
    }

    public int[] getNumOfHousePerPropertiesPerColorGroup() {
        return numOfHousePerPropertiesPerColorGroup;
    }

}
