package model.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.ColorGroup;
import model.spaces.Property;
import model.spaces.PurchasableSpace;
import model.spaces.Station;
import model.spaces.Utility;

public class TitleDeeds {

    private List<PurchasableSpace> deeds = new ArrayList<>();

    private int numOfStations = 0;
    private int numOfUtilities = 0;
    private Map<ColorGroup, Integer> propertyPerColorGroup = new HashMap<>();
    private int[] housePerPropertyPerColorGroup = new int[8];

    public void addDeed(PurchasableSpace newDeed) {
        if (newDeed instanceof Utility) {
            numOfUtilities++;
        } else if (newDeed instanceof Station) {
            numOfStations++;
        } else {
            Property deed = (Property) newDeed;
            ColorGroup group = deed.getColorGroup();
            int numOfProperty = propertyPerColorGroup.get(group);
            propertyPerColorGroup.replace(group, numOfProperty + 1);
        }
        deeds.add(newDeed);
    }

    public boolean hasCompleteColorGroup(ColorGroup group) {
        int numOfProperties = propertyPerColorGroup.get(group);

        if (group == ColorGroup.PURPLE || group == ColorGroup.BLUE) {
            return numOfProperties == 2;
        }
        return numOfProperties == 3;
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

    public Map<ColorGroup, Integer> getPropertyPerColorGroup() {
        return propertyPerColorGroup;
    }

    public int[] getHousePerPropertyPerColorGroup() {
        return housePerPropertyPerColorGroup;
    }

}
