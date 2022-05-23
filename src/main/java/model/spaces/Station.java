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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Station)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        }

        Station newObj = (Station) obj;
        return startingRentPrice == newObj.startingRentPrice;
    }
}
