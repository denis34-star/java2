package ru.geekbrains.lesson1;

import java.util.Random;

public class Running_track {
    public static void main(String[] args) {
        java.lang.Object[] participants = prepareParticipants();
        playGame(participants);
    }
    private static java.lang.Object [] prepareParticipants() {
        return new java.lang.Object[] {
                new Cat(200, 2),
                new Man(500,1),
                new Robot(1000,3)
        };
    }
    private static void playGame(java.lang.Object [] participants) {
        Random random = new Random();

        for (java.lang.Object participant : participants) {
            participant.printInfo();
            System.out.println(participant.run(random.nextInt(100)));
            System.out.println();

        }
    }
}
