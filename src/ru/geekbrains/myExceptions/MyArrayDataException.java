package ru.geekbrains.myExceptions;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException() {
        super(String.format("Число отсутствует"));
    }

}

