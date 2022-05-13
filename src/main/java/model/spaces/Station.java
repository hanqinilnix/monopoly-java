package model.spaces;

public final class Station extends PurchasableSpace{

    private final int startingRentPrice = 25;

    protected Station(String name, int price) {
        super(name, price);
    }

    @Override
    public int getRent() {
        return (int) (startingRentPrice * Math.pow(2, deeds.getNumOfStations() - 1));
    }
}
