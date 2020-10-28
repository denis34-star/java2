package ru.geekbrains.lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class Words {
    public static void main(String [] args) {
         String[] words = {"собака", "кошка", "ручка", "журнал", "клюшка", "журнал", "вилка", "собака", "бита", "часы"};

    //     Задание 1.а

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

       // Задание 1.b

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        //Задание 2

        Phonebook pb = new Phonebook();
        pb.add("Иванов", "237541");
        pb.add("Петров", "235680");
        pb.add("Сидоров","230617");
        pb.add("Смирнов","235435");
        pb.add("Петухов", "231405");
        pb.add("Петухов", "170105");
        pb.add("Логинов", "230975");

        System.out.println(pb.get("Петухов"));

    }
}
