package model.player;

public class Wallet {
    private final int startingMoney = 1500;

    private int money;

    public Wallet() {
        money = startingMoney;
    }

    public Wallet(int money) {
        this.money = money;
    }

    public void takeMoney(int value) {
        money -= value;
    }

    public void getMoney(int value) {
        money += value;
    }

    // getter method

    public int getMoney() {
        return money;
    }
}
