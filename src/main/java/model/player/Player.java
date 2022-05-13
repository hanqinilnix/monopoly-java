package model.player;

public class Player {
    private int id;
    private Wallet wallet = new Wallet();

    private TitleDeeds titleDeeds = new TitleDeeds();
    private int numOfGofj = 0; // Gofj = Get out of jail

    // getter methods

    public int getId() {
        return id;
    }

    public Wallet wallet() {
        return wallet;
    }

    public TitleDeeds getTitleDeeds() {
        return titleDeeds;
    }

    public int getNumOfGofj() {
        return numOfGofj;
    }

}
