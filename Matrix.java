package ru.geekbrains.lesson2;

public class Matrix {
    public static void main(String[] args) {
        String[][] correctSizeMatrix = {
                {"4", "5", "7", "9"},
                {"3","8", "4", "0"},
                {"0","2", "5", "9"},
                {"9","1", "8", "4"}

        };
        String[][] wronSizeMatrix = {
                {"4", "5", "7", "9"},
                {"8",  "0", },
                {"0","2", "5", "9"},
                {"9","1", "8", "4"}

        };
        String[][]wronChar = {
                {"4", "5", "7", "9"},
                {"3","8", "4", "0"},
                {"0","2", "5", ""},
                {"9","1", "8", "4"}
        };
        try {
            System.out.println(Converter.strConverter(wronSizeMatrix));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(Converter.strConverter(wronChar));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
    }
}
