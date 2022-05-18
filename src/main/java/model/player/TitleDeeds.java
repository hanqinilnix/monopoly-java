package model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
    private Map<ColorGroup, LinkedList<Integer>> housePerPropertyPerColorGroup = new HashMap<>();

    public void addDeed(PurchasableSpace newDeed) {
        if (newDeed instanceof Utility) {
            numOfUtilities++;
        } else if (newDeed instanceof Station) {
            numOfStations++;
        } else {
            Property deed = (Property) newDeed;
            ColorGroup group = deed.getColorGroup();
            incrementPropertyCount(group);
            initialiseHouseCount(group);
        }
        deeds.add(newDeed);
    }

    public void removeDeed(PurchasableSpace toRemoveDeed) {
        if (toRemoveDeed instanceof Utility) {
            numOfUtilities--;
            deeds.remove(toRemoveDeed);
        } else if (toRemoveDeed instanceof Station) {
            numOfStations--;
            deeds.remove(toRemoveDeed);
        } else {
            Property deed = (Property) toRemoveDeed;
            removeProperty(deed);
        }
    }

    public void buyBuilding(Property propertyToBuyHouse) {
        if (!canBuildEvenly(propertyToBuyHouse)) {
            return;
        }

        incrementHouseCount(propertyToBuyHouse.getColorGroup());
        if (propertyToBuyHouse.canBuyHotel()) {
            propertyToBuyHouse.buyHotel();
        } else {
            propertyToBuyHouse.buyHouse();
        }
    }

    public void sellBuilding(Property propertyToSellHouse) {
        if (!canRemoveEvenly(propertyToSellHouse)) {
            return;
        }

        decrementHouseCount(propertyToSellHouse.getColorGroup());
        if (propertyToSellHouse.canSellHotel()) {
            propertyToSellHouse.sellHotel();
        } else {
            propertyToSellHouse.sellHouse();
        }
    }

    public boolean canBuildEvenly(Property propertyToBuyHouse) {
        ColorGroup group = propertyToBuyHouse.getColorGroup();
        if (!hasCompleteColorGroup(group)) {
            return false;
        }

        LinkedList<Integer> houses = housePerPropertyPerColorGroup.get(group);
        int numOfHouses = propertyToBuyHouse.getNumOfHouses();

        return houses.peekFirst() == numOfHouses;
    }

    public boolean canRemoveEvenly(Property propertyToSellHouse) {
        ColorGroup group = propertyToSellHouse.getColorGroup();
        if (!hasCompleteColorGroup(group)) {
            return false;
        }

        LinkedList<Integer> houses = housePerPropertyPerColorGroup.get(group);
        int numOfHouses = propertyToSellHouse.getNumOfHouses();

        return houses.peekLast() == numOfHouses;
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

    private void incrementPropertyCount(ColorGroup group) {
        int numOfProperties = 0;
        if (propertyPerColorGroup.containsKey(group)) {
            numOfProperties = propertyPerColorGroup.get(group);
        }

        propertyPerColorGroup.replace(group, numOfProperties + 1);
    }

    private void decrementPropertyCount(ColorGroup group) {
        assert propertyPerColorGroup.containsKey(group);

        int numOfProperties = propertyPerColorGroup.get(group);
        propertyPerColorGroup.replace(group, numOfProperties - 1);
    }

    private void initialiseHouseCount(ColorGroup group) {
        LinkedList<Integer> houses = new LinkedList<>(Arrays.asList(0, 0, 0));
        if (group == ColorGroup.PURPLE || group == ColorGroup.BLUE) {
            houses.removeLast();
        }

        housePerPropertyPerColorGroup.put(group, houses);
    }

    private void incrementHouseCount(ColorGroup group) {
        assert housePerPropertyPerColorGroup.containsKey(group);

        LinkedList<Integer> houses = housePerPropertyPerColorGroup.get(group);
        int numOfHouses = houses.removeFirst();
        houses.addLast(numOfHouses + 1);
    }

    private void decrementHouseCount(ColorGroup group) {
        assert housePerPropertyPerColorGroup.containsKey(group);

        LinkedList<Integer> houses = housePerPropertyPerColorGroup.get(group);
        int numOfHouses = houses.removeLast();
        houses.addFirst(numOfHouses - 1);
    }

    private void removeProperty(Property propertyToRemove) {
        ColorGroup group = propertyToRemove.getColorGroup();
        if (canRemoveProperty(propertyToRemove)) {
            decrementPropertyCount(group);
            housePerPropertyPerColorGroup.remove(group);
        }
    }

    private boolean canRemoveProperty(Property propertyToRemove) {
        ColorGroup group = propertyToRemove.getColorGroup();
        LinkedList<Integer> houses = housePerPropertyPerColorGroup.get(group);
        for (int house : houses) {
            if (house != 0) {
                return false;
            }
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

    public Map<ColorGroup, LinkedList<Integer>> getHousePerPropertyPerColorGroup() {
        return housePerPropertyPerColorGroup;
    }

}
