package ru.geekbrains;

import ru.geekbrains.actions.IActions;
import ru.geekbrains.actions.ILevelObstacles;
import ru.geekbrains.obstacles.SwimmingPool;
import ru.geekbrains.obstacles.Track;
import ru.geekbrains.obstacles.Wall;
import java.util.Random;

public class Course {
    public void startGame(IActions[] participiantsArr, int quantityOfObstacles) {

        if(quantityOfObstacles < 1) quantityOfObstacles = 4;
        ILevelObstacles[] obstaclesArray = new ILevelObstacles[quantityOfObstacles]; // Массив препядствий для соревнования

        // Выбор препядствий для соревнования
        for (int i = 0; i < obstaclesArray.length; i++) {
            int obst = new Random().nextInt(3);
            Random rnd = new Random();
            switch (obst) {
                case 0:
                    obstaclesArray[i] = new SwimmingPool(rnd.nextInt(5));
                    break;
                case 1:
                    obstaclesArray[i] = new Track(rnd.nextInt(5));
                    break;
                case 2:
                    obstaclesArray[i] = new Wall(rnd.nextInt(5));
                    break;
            }
        }

        // Соревнования !!!
        for (int i = 0; i < obstaclesArray.length; i++) {
            System.out.println("=======================================================");
            System.out.println("Спортсмены проходят препятствие № " + (i + 1));
            String str = obstaclesArray[i].iObstacle();
            System.out.println(str);
            System.out.println("=======================================================");

            for (int j = 0; j < participiantsArr.length; j++) {
                if (str.contains("Стена")) {
                    participiantsArr[j].jump(obstaclesArray[i].getLevel());
                } else if (str.contains("дорожка")) {
                    participiantsArr[j].run(obstaclesArray[i].getLevel());
                } else if (str.contains("Бассейн")) {
                    participiantsArr[j].swim(obstaclesArray[i].getLevel());
                }
            }
        }
    }
}
