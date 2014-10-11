package com.agoatnaepizza;

import org.newdawn.slick.*;

import com.agoatnaepizza.Game.Map;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.Game.Tiles.Floor;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 09:25
 */
public class GameLoop implements Game {
	Map map;
	float scale = 1;
	int width = 800;
	int height = 600;
	boolean toggled = false;
	private int keyDownX;
	private int keyDownY;
	
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
    	Tile floor = new Floor();
    	Tile wall = floor;
    	
    	map = new Map(10, 10, floor, wall);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
    	Input input = gameContainer.getInput();
    	
    	if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
    		if (!toggled) scale /= 1.2;
    		toggled = true;
    	} else if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
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
    	
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    	graphics.translate(keyDownX, keyDownY);
    
    	graphics.scale(scale, scale);
        map.render(graphics);
    	graphics.drawString("", 10, 100);
    	
    	
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
