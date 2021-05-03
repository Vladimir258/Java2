package ru.geekbrains;

import ru.geekbrains.actions.IActions;
import ru.geekbrains.participants.Cat;
import ru.geekbrains.participants.Man;
import ru.geekbrains.participants.Robot;
import java.util.Random;

public class Gamers {
    public IActions[] ceateGamers(int quantityGamers) {

        if(quantityGamers < 1) quantityGamers = 10;
        IActions[] participiantsArray = new IActions[quantityGamers]; // Массив участников

        int a = 0, b = 0, c = 0; // Счетчики для имен участников соревнований

        // Регистрация участников
        for (int i = 0; i < participiantsArray.length; i++) {
            int whoI = new Random().nextInt(3);
            Random rnd = new Random();
            switch (whoI) {
                case 0 -> {
                    participiantsArray[i] = new Cat("Кот " + a, rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10));
                    a++;
                }
                case 1 -> {
                    participiantsArray[i] = new Man("Человек " + b, rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10));
                    b++;
                }
                case 2 -> {
                    participiantsArray[i] = new Robot("Робот " + c, rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10));
                    c++;
                }
            }
            System.out.println(participiantsArray[i].hello());
        }
        return participiantsArray;
    }
}
