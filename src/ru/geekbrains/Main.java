package ru.geekbrains;

import ru.geekbrains.myExceptions.MyArrayDataException;
import ru.geekbrains.myExceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3d", "3"},
                {"d", "3", "4", "5"},
                {"e", "f55", "7", "8"},
                {"g", "9", "5", "h"}};

        System.out.println("**********   Массив   ***********");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("*********************************");
        System.out.println();
        System.out.println("*****Отфильтрованный Массив******");

        try {
            CatchException.getArray(array);
        } catch (MyArraySizeException exc) {
            System.out.println("Неверный размер массива\n");
            exc.printStackTrace();
        }
        catch (MyArrayDataException exc) {
            System.out.print("  -");
            //exc.printStackTrace();
        }

        System.out.println();
        System.out.println("*********Следующий массив********");

        String[][] array1 = new String[4][7];
        try {
            CatchException.getArray(array1);
        } catch (MyArraySizeException exc) {
            System.out.println("Не верный размер массива\n");
            exc.printStackTrace();
        }
    }
}
