package com.agoatnaepizza;

import com.agoatnaepizza.Game.Buildable;
import com.agoatnaepizza.Game.Company;
import com.agoatnaepizza.Game.InteractionModel;
import com.agoatnaepizza.Game.Map;
import com.agoatnaepizza.Game.Objects.Phone;
import com.agoatnaepizza.Game.Objects.Staff;
import com.agoatnaepizza.Game.Objects.Tile;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import com.agoatnaepizza.Game.Tiles.Floor;
import com.agoatnaepizza.Game.Tiles.Wall;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
    InteractionModel model;
	private int mouseX;
	private int mouseY;

    TaskQueue PhoneQueue = new TaskQueue();
    TaskQueue emailQueue = new TaskQueue();

    public GameLoop(InteractionModel model) {
        super();
        this.model = model;
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Tile floor = new Floor();
        Tile wall = new Wall();

        Phone.taskQueue = PhoneQueue;

        map = new Map(10, 10, floor, wall);
        
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        if (model.getSelectedBuildable() == null) {
            model.setSelectedBuildable(Buildable.getBuildables().get(Buildable.getNames().get(0)));
        }

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
    
    	int x = max(min((int) Math.floor(Math.floor((input.getMouseX() / scale - keyDownX)) / Tile.getSize()), map.x - 2), 1);
		int y = max(min((int) Math.floor(Math.floor((input.getMouseY() / scale - keyDownY)) / Tile.getSize()), map.x - 2), 1);
    	if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (model.getPlaceStaff()) {
                map.setStaff(x, y, new Staff("BOB", new Vector2f(x, y)));
            }
            if (model.getPlaceObject()) {
                map.getObjects().get(x).get(y).add(model.getSelectedBuildable());
            }
    	}
    	
    	if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
    		if (model.getPlaceStaff()) {
                map.setStaff(x, y, null);
            }
            if (model.getPlaceObject()) {
                map.getObjects().get(x).get(y).clear();
            }
    	}
    	
    	mouseX = x;
    	mouseY = y;

        PhoneQueue.tick();
        emailQueue.tick();
        map.Tick();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	graphics.translate(keyDownX, keyDownY);
    
    	graphics.scale(scale, scale);
        map.render(graphics);
        graphics.drawImage(
            model.getSelectedBuildable().getTile(), mouseX * Tile.getSize(), mouseY * Tile.getSize(),
            new Color(1.0f, 1.0f, 1.0f, 0.5f)
        );
        graphics.drawString("", 10, 100);
    	
    	graphics.drawString("Emails: "+emailQueue.waiting()+" Phone Calls: "+PhoneQueue.waiting(), 50, 400);
        graphics.drawString("Reputation: "+Company.company.getReputation(), 50, 350);
        graphics.drawString("Money: "+ Company.company.getMoney(), 60, 50);
    }
}
