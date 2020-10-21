package ru.geekbrains.lesson1;

public class Cat extends Object {

    public static final int DEFAULT_MAX_RUN_DISTANCE = 200;
    public static final int DEFAULT_MAX_JUMP_HEIGHT = 2;

    public Cat(int maxRunDistance, int maxJumpHeight) {
        super(maxRunDistance, maxJumpHeight);
    }

    public Cat() {super(DEFAULT_MAX_RUN_DISTANCE, DEFAULT_MAX_JUMP_HEIGHT);}

    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance >= distance) {
            System.out.printf("Кот пробежал дистанцию %d. Max = %d%n", distance, maxRunDistance);
            return true;
        }
        System.out.printf("Кот не смог пробежать дистанцию %d. Max = %d%n", distance, maxRunDistance);
        return false;
    }

    @Override
    public boolean jump(int height) {
        if (this.maxJumpHeight >= height) {
            System.out.printf("Кот перепрыгнул препятствие %d. Max = %d%n", height, maxJumpHeight);
            return true;
        }
        System.out.printf("Кот не смог перепрыгнуть препятствие %d. = %d%", height, maxJumpHeight);
        return false;
    }
}
