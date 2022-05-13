package commons;

public class Dice {
    Die die1 = new Die();
    Die die2 = new Die();

    public int roll() {
        return die1.roll() + die2.roll();
    }

    public boolean isDoubles() {
        return die1.getValue() == die2.getValue();
    }

}
