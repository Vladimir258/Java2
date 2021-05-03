package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Course course = new Course();
        Gamers gamers = new Gamers();

        course.startGame(gamers.ceateGamers(10),4);
    }
}
