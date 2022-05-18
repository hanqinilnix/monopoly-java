package model.spaces;

public abstract class ActionSpace extends Space {
    protected ActionSpace(String name) {
        super(name);
    }

    public abstract void action();
}
