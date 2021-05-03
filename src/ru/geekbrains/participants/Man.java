package ru.geekbrains.participants;
import ru.geekbrains.actions.IActions;

public class Man  implements IActions {
    private final String name;
    private final int runDistance;
    private final int swimDistance;
    private final int jumpHeight;
    private boolean endGame;

    // Конструктор класса Кот
    public Man(String name, int rDist, int sDist, int jHeight) {
        this.name = name;
        runDistance = rDist;
        swimDistance = sDist;
        jumpHeight = jHeight;
        endGame = false;
    }

    @Override
    public void run(int Distance) {
        if (endGame) {
            System.out.println(name + " ВЫБЫЛ ИЗ СОРЕВНОВАНИЙ");
        } else {
            if (Distance < runDistance) {
                System.out.println(name + " успешно пробежал " + Distance + " метров(а).");
            } else {
                System.out.println(name + " не смог пробежать " + Distance + " метров(а).");
                endGame = true;
            }
        }
    }

    @Override
    public void jump(int Height) {
        if (endGame) {
            System.out.println(name + " ВЫБЫЛ ИЗ СОРЕВНОВАНИЙ");
        } else {
            if (Height < jumpHeight) {
                System.out.println(name + " успешно перепрыгнул " + Height + " метров(а).");
            } else {
                System.out.println(name + " не смог перепрыгнуть " + Height + " метров(а).");
                endGame = true;
            }
        }
    }

    @Override
    public void swim(int Distance) {
        if (endGame) {
            System.out.println(name + " ВЫБЫЛ ИЗ СОРЕВНОВАНИЙ");
        } else {
            if (Distance < swimDistance) {
                System.out.println(name + " успешно переплыл " + Distance + " метров(а).");
            } else {
                System.out.println(name + " не смог переплыль " + Distance + " метров(а).");
                endGame = true;
            }
        }
    }

    @Override
    public String hello() {
        String str = "Участник - " + name + ", Дальность бега - " + runDistance + ", Дальность плаванья - " + swimDistance + ", Высота прыжка - " + jumpHeight;
        return str;
    }
}
