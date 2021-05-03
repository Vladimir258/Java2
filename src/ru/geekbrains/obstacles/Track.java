package ru.geekbrains.obstacles;
import ru.geekbrains.actions.ILevelObstacles;

public class Track implements ILevelObstacles {

    private final int levelObst;

    public Track(int lev) {
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
            return "Беговая дорожка высотой " + getLevel() + " метр";
        }
        else {
            return "Беговая дорожка высотой " + getLevel() + " метров(а)";
        }
    }
}
