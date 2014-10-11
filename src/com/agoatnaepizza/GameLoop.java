package com.agoatnaepizza;

import java.io.IOException;
import java.util.ArrayList;

import com.agoatnaepizza.Game.Map;
import com.agoatnaepizza.Game.Objects.Phone;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.Game.Tiles.Floor;
import com.agoatnaepizza.Game.Tiles.Wall;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 09:25
 */
public class GameLoop extends BasicGameState {
	Map map;
	float scale = 1;
	boolean toggled = false;
	private int keyDownX;
	private int keyDownY;
	
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Tile floor = new Floor();
        Tile wall = new Wall();

        map = new Map(10, 10, floor, wall);
        
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
    	Input input = gameContainer.getInput();
    	int WheelDelta = Mouse.getDWheel();
    	if (WheelDelta > 0) {
    		if (!toggled) scale /= 1.2;
    		toggled = true;
    	} else if (WheelDelta < 0) {
    		if (!toggled) scale *= 1.2;
    		toggled = true;
    	} else {
    		toggled = false;
    	}

    	if (input.isKeyDown(Input.KEY_LEFT)) {
    		keyDownX -= 1;
    	}
    	if (input.isKeyDown(Input.KEY_DOWN)) 
    		keyDownY += 1;
    	
    	if (input.isKeyDown(Input.KEY_RIGHT)) 
    		keyDownX += 1;
    	
    	if (input.isKeyDown(Input.KEY_UP)) 
    		keyDownY -= 1;
    
    	if (input.isKeyDown(Input.KEY_W)) {
    		int x = (int) Math.floor((input.getMouseX() / scale - keyDownX) / Tile.getSize());
    		int y = (int) Math.floor((input.getMouseY() / scale - keyDownY) / Tile.getSize());
    		map.getObjects().get(x).get(y).add(new Wall());
    	}
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	graphics.translate(keyDownX, keyDownY);
    
    	graphics.scale(scale, scale);
        map.render(graphics);
    	graphics.drawString("", 10, 100);
    	
    	
    }
}
