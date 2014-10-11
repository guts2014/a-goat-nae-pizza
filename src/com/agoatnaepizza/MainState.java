package com.agoatnaepizza;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 12:10
 */
public class MainState extends StateBasedGame {
    public MainState(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new GameLoop());
        enterState(1);
    }
}
