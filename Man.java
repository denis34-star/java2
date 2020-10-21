package ru.geekbrains.lesson1;

public class Man extends Object {
    public static final int DEFAULT_MAX_RUN_DISTANCE = 500;
    public static final int DEFAULT_MAX_JUMP_HEIGHT = 1;

    public Man(int maxRunDistance, int maxJumpHeight) {
        super(maxRunDistance, maxJumpHeight);
    }

    public Man() {super(DEFAULT_MAX_RUN_DISTANCE, DEFAULT_MAX_JUMP_HEIGHT);}

    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance >= distance) {
            System.out.printf("Человек пробежал дистанцию %d. Max = %d%n", distance, maxRunDistance);
            return true;
        }
        System.out.printf("Человек не смог пробежать дистанцию %d. Max = %d%n", distance, maxRunDistance);
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (this.maxJumpHeight >= height) {
            System.out.printf("Человек перепрыгнул препятствие %d. Max = %d%n", height, maxJumpHeight);
            return true;
        }
        System.out.printf("Человек не смог перепрыгнуть препятствие %d. = %d%", height, maxJumpHeight);
        return false;
    }
}
