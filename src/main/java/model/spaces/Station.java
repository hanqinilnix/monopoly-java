package model.spaces;

public final class Station extends PurchasableSpace {

    private final int startingRentPrice = 25;

    public Station(String name, int position, int price) {
        super(name, position, price);
    }

    @Override
    public int getRent() {
        return (int) (startingRentPrice * Math.pow(2, deeds.getNumOfStations() - 1));
    }
}
