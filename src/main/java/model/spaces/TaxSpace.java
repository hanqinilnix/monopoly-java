package model.spaces;

public class TaxSpace extends Space {
    private final int taxToPay;

    public TaxSpace(String name, int position, int taxToPay) {
        super(name, position);
        this.taxToPay = taxToPay;
    }

    public int getTaxToPay() {
        return taxToPay;
    }

}
