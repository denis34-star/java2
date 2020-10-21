package ru.geekbrains.lesson1;

public class Robot extends Object {
    public static final int DEFAULT_MAX_RUN_DISTANCE = 1000;
    public static final int DEFAULT_MAX_JUMP_HEIGHT = 3;

    public Robot(int maxRunDistance, int maxJumpHeight) {
        super(maxRunDistance, maxJumpHeight);
    }

    public Robot() {super(DEFAULT_MAX_RUN_DISTANCE, DEFAULT_MAX_JUMP_HEIGHT);}

    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance >= distance) {
            System.out.printf("Робот пробежал дистанцию %d. Max = %d%n", distance, maxRunDistance);
            return true;
        }
        System.out.printf("Робот не смог пробежать дистанцию %d. Max = %d%n", distance, maxRunDistance);
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (this.maxJumpHeight >= height) {
            System.out.printf("Робот перепрыгнул препятствие %d. Max = %d%n", height, maxJumpHeight);
            return true;
        }
        System.out.printf("Робот не смог перепрыгнуть препятствие %d. = %d%", height, maxJumpHeight);
        return false;
    }
}
