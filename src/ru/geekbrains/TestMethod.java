package ru.geekbrains;

import java.util.Arrays;

public class TestMethod {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 0b010;
    static final float UNIT_ONE = 1.0f;

    public static void methodOne() {
        float[] array = new float[SIZE];
        long timeBefore = 0, timeAfter = 0;

        timeBefore = System.currentTimeMillis();
        Arrays.fill(array, UNIT_ONE);
        timeAfter = System.currentTimeMillis();
        System.out.println("Заполнение массива 1-ми в одном потоке, заняло:       " + (timeAfter - timeBefore) + "    мс");

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        timeAfter = System.currentTimeMillis();
        System.out.println("Заполнение массива по формуле в одном потоке, заняло: " + (timeAfter - timeBefore) + " мс");
    }

    public static void methodTwo() {
        float[] array = new float[SIZE];
        float[] arrayFirstHalf = new float[HALF];
        float[] arraySecondHalf = new float[HALF];
        long timeBefore = 0, timeAfter = 0;

        timeBefore = System.currentTimeMillis();
        System.arraycopy(array,0,arrayFirstHalf,0,HALF);
        System.arraycopy(array,HALF,arraySecondHalf,0,HALF);

        Thread thread1 = new Thread(() -> {
            Arrays.fill(arrayFirstHalf, UNIT_ONE);
            System.arraycopy(arrayFirstHalf, 0, array, 0, HALF);
        });

        Thread thread2 = new Thread(() -> {
            Arrays.fill(arraySecondHalf, UNIT_ONE);
            System.arraycopy(arraySecondHalf, 0, array, HALF, HALF);
        });

        thread1.start();
        thread2.start();

        timeAfter = System.currentTimeMillis();
        System.out.println("Заполнение массива 1-ми в двух потоках, заняло:       " + (timeAfter - timeBefore) + "   мс");

        timeBefore = System.currentTimeMillis();
        System.arraycopy(array,0,arrayFirstHalf,0,HALF);
        System.arraycopy(array,HALF,arraySecondHalf,0,HALF);

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < arrayFirstHalf.length; i++) {
                arrayFirstHalf[i] = (float)(arrayFirstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arrayFirstHalf, 0, array, 0, HALF);
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < arraySecondHalf.length; i++) {
                arraySecondHalf[i] = (float)(arraySecondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arraySecondHalf, 0, array, HALF, HALF);
        });

        thread3.start();
        thread4.start();

        timeAfter = System.currentTimeMillis();
        System.out.println("Заполнение массива по формуле в двух потоках, заняло: " + (timeAfter - timeBefore) + "    мс");
    }
}
