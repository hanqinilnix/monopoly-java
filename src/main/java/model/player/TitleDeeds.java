package model.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

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
    private Map<ColorGroup, SortedSet<Integer>> housePerPropertyPerColorGroup = new HashMap<>();

    public void addDeed(PurchasableSpace newDeed) {
        if (newDeed instanceof Utility) {
            numOfUtilities++;
        } else if (newDeed instanceof Station) {
            numOfStations++;
        } else {
            Property deed = (Property) newDeed;
            ColorGroup group = deed.getColorGroup();
            int numOfProperty = 0;
            if (propertyPerColorGroup.containsKey(group)) {
                numOfProperty = propertyPerColorGroup.get(group);
            }
            propertyPerColorGroup.replace(group, numOfProperty + 1);
        }
        deeds.add(newDeed);
    }

    public boolean hasCompleteColorGroup(ColorGroup group) {
        if (propertyPerColorGroup.containsKey(group)) {
            return false;
        }
        int numOfProperties = propertyPerColorGroup.get(group);

        if (group == ColorGroup.PURPLE || group == ColorGroup.BLUE) {
            return numOfProperties == 2;
        }
        return numOfProperties == 3;
    }

    public boolean canBuildEvenly(Property propertyToBuyHouse) {
        ColorGroup group = propertyToBuyHouse.getColorGroup();
        if (!hasCompleteColorGroup(group)) {
            return false;
        }

        SortedSet<Integer> housesSet = housePerPropertyPerColorGroup.get(group);
        assert housesSet.size() <= 2;

        if (housesSet.size() == 2) {
            int numOfHouses = propertyToBuyHouse.getNumOfHouses();
            return housesSet.first() == numOfHouses;
        }

        return true;
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

    public Map<ColorGroup, SortedSet<Integer>> getHousePerPropertyPerColorGroup() {
        return housePerPropertyPerColorGroup;
    }

}
