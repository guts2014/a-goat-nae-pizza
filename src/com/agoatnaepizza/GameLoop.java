package com.agoatnaepizza;

import org.newdawn.slick.*;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 09:25
 */
public class GameLoop implements Game {
    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("", 10, 10);
    }

    @Override
    public boolean closeRequested() {
        return false;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
