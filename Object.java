package ru.geekbrains.lesson1;

public abstract class Object {

    protected int maxRunDistance;
    protected int maxJumpHeight;

    public Object(int MaxRunDistance, int MaxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public abstract boolean run(int distance);
    public abstract boolean jump(int height);

    public void printInfo () {System.out.println(this);}

    @Override
    public String toString () {
        return this.getClass() .getSimpleName() + "{" +
        "maxRunDistance=" + maxRunDistance +
        ", maxJumpHeight" + maxJumpHeight +
        '}';
    }
}
