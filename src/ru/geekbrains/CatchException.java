package ru.geekbrains;

import ru.geekbrains.myExceptions.MyArrayDataException;
import ru.geekbrains.myExceptions.MyArraySizeException;

public class CatchException {

    static final int NEED_ROW = 4;
    static final int NEED_COLUM = 4;

    public static void getArray(String[][] array)  {
        int sum = 0;
        String[][] arraySample = new String[NEED_ROW][NEED_COLUM];

        int n = 0,m = 0;
        for (int i = 0; i < array.length; i++) {
            n++;
            m = 0;
            for (int j = 0; j < array[i].length; j++) {
                m++;
            }
        }

        if (array.length != arraySample.length) throw new MyArraySizeException(NEED_ROW,NEED_COLUM,n,m);
        for (int i = 0; i < array.length; i++) {

            if (array[i].length != arraySample[i].length) throw new MyArraySizeException(NEED_ROW,NEED_COLUM,n,m);

            for (int j = 0; j < array[i].length; j++) {
                try {
                    System.out.print(Integer.parseInt(array[i][j]) + "   ");
                    sum += Integer.parseInt(array[i][j]);
                } catch(NumberFormatException exc) {
                    System.out.print("-   ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        System.out.println("Сумма всех чисел в массиве равна: " + sum);
        System.out.println("*********************************");
    }
}
