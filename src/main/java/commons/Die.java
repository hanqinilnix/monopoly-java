package commons;

import java.util.Random;

public class Die {
    private Random rand = new Random();

    private int value = 0;

    public int roll() {
        value = rand.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        assert value != 0;
        return value;
    }
}
