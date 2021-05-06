package ru.geekbrains.myExceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException(int needRow, int needColum,  int actualRow, int actualColum) {
        super(String.format("Нужен массив %d строк, %d колонок. Получен массив %d строк, %d колонок.",
                needRow,
                needColum,
                actualRow,
                actualColum));
    }
}
