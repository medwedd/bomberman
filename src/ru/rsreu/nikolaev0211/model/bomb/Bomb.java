package ru.rsreu.nikolaev0211.model.bomb;

import ru.rsreu.nikolaev0211.Settings;
import ru.rsreu.nikolaev0211.events.EventType;
import ru.rsreu.nikolaev0211.model.Game;
import ru.rsreu.nikolaev0211.model.GameState;
import ru.rsreu.nikolaev0211.model.UpdatableModel;

public class Bomb implements Runnable {

    private UpdatableModel model;
    private boolean isAlive;
    private int x;
    private int y;

    public Bomb(int x, int y, UpdatableModel model) {
        this.x = x;
        this.y = y;
        this.model = model;
        this.isAlive = true;
    }

    private void boom() {
        System.out.println("Bomb made boommm!!! on x = " + x + " y = " + y);
        isAlive = false;
        model.update(EventType.BOMB_UPDATE);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        isAlive = true;
        while (isAlive && GameState.RUNNING.equals(Game.getGameState())) {
            if (System.currentTimeMillis() - startTime > Settings.BOMB_ALIVE_TIME) {
                boom();
            }
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Bomb{" +
                "model=" + model +
                ", isAlive=" + isAlive +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
