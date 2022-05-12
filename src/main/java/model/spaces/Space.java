package model.spaces;

public abstract class Space {
    protected final String name;

    protected Space(String name) {
        this.name = name;
    }

    // getter method

    public String getName() {
        return name;
    }
}
