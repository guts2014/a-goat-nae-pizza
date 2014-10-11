package com.agoatnaepizza;

import com.agoatnaepizza.Game.InteractionModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 12:10
 */
public class MainState extends StateBasedGame {
    InteractionModel model;

    public MainState(String name, InteractionModel model) {
        super(name);
        this.model = model;
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new GameLoop(this.model));
        enterState(1);
    }
}
