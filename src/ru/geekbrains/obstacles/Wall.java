package ru.geekbrains.obstacles;
import ru.geekbrains.actions.ILevelObstacles;

public class Wall implements ILevelObstacles {

    private final int levelObst;

    public Wall(int lev) {
        if(lev == 0) {
            levelObst = 3;
        }
        else {
            levelObst = lev;
        }
    }
    @Override
    public int getLevel() {
        return levelObst;
    }
    @Override
    public String iObstacle() {
        if(getLevel()==1) {
            return "Стена длинной " + getLevel() + " метр";
        }
        else {
            return "Стена длинной " + getLevel() + " метров(а)";
        }
    }

}
