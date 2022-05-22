package model.spaces;

public abstract class Space {
    protected final String name;
    protected final int position;

    public Space(String name, int position) {
        this.name = name;
        this.position = position;
    }

    // getter method

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
