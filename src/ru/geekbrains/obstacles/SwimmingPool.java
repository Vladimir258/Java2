package ru.geekbrains.obstacles;
import ru.geekbrains.actions.ILevelObstacles;

public class SwimmingPool implements ILevelObstacles {

    private final int levelObst;

    public SwimmingPool(int lev) {
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
            return "Бассейн длинной " + getLevel() + " метр";
        }
        else {
            return "Бассейн длинной " + getLevel() + " метров(а)";
        }
    }
}