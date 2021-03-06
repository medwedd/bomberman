package ru.rsreu.nikolaev0211.view.object;

import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.view.GameScreenParameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BombView {
    public void render(Graphics2D graphics, Bomb bomb) {
        graphics.setColor(new Color(255, 0, 18));
        graphics.fill(new Ellipse2D.Double(
                bomb.getX() * GameScreenParameters.getScaleXTest(),
                bomb.getY() * GameScreenParameters.getScaleYTest(),
                GameScreenParameters.getScaleXTest() - 1,
                GameScreenParameters.getScaleYTest() - 1
        ));
    }

}
