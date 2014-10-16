package com.agoatnaepizza.Game.GameUI;

import com.agoatnaepizza.Game.*;
import com.agoatnaepizza.Game.NonGameUI.Buildable;
import com.agoatnaepizza.Game.Tiles.Objects.Computer;
import com.agoatnaepizza.Game.Tiles.Objects.Phone;
import com.agoatnaepizza.Game.Entities.Staff;
import com.agoatnaepizza.Game.Tiles.Tile;
import com.agoatnaepizza.Game.Tasks.TaskQueue;
import com.agoatnaepizza.Game.Tiles.Floor;
import com.agoatnaepizza.Game.Tiles.GroundTile;
import com.agoatnaepizza.Game.Tiles.StaffTile;
import com.agoatnaepizza.Game.Tiles.Wall;
import com.agoatnaepizza.Game.maps.Map;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Calendar;

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

    private long lastTickTime = 0;
    private static final int TargetFrameRate = 30;
    private static final Double TargetFrameTime = 1./TargetFrameRate*1000;

    private TaskQueueRenderer taskQueueRenderer = new TaskQueueRenderer();

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
        GroundTile floor = new Floor();
        GroundTile wall = new Wall();

        Phone.taskQueue = PhoneQueue;
        Computer.taskQueue = emailQueue;

        taskQueueRenderer.addTasks("Phone", PhoneQueue);
        taskQueueRenderer.addTasks("Email", emailQueue);

        map = new Map(25, 25, floor, wall);
        
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


        long time = Calendar.getInstance().getTimeInMillis();
        if (time - lastTickTime < TargetFrameTime) {
            return;
        } else {
            HandleInput(gameContainer);

            System.out.println("FrameTime: "+(time-lastTickTime)+"ms Target: "+TargetFrameTime+"ms");
            lastTickTime = time;

            PhoneQueue.tick();
            emailQueue.tick();
            map.Tick();
        }
    }

    private void HandleInput(GameContainer gameContainer) {
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

        @SuppressWarnings("PointlessArithmeticExpression")
        final int offset = 1 * (600/TargetFrameRate);
        if (input.isKeyDown(Input.KEY_LEFT)) {
            keyDownX -= offset;
        }

        if (input.isKeyDown(Input.KEY_DOWN)) {
            keyDownY += offset;
        }

        if (input.isKeyDown(Input.KEY_RIGHT)) {
            keyDownX += offset;
        }

        if (input.isKeyDown(Input.KEY_UP)) {
            keyDownY -= offset;
        }

        int x = max(min((int) Math.floor(Math.floor((input.getMouseX() / scale - keyDownX)) / Tile.getSize()), map.x - 2), 1);
        int y = max(min((int) Math.floor(Math.floor((input.getMouseY() / scale - keyDownY)) / Tile.getSize()), map.x - 2), 1);
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (model.getPlaceStaff()) {
                map.setStaff(x, y, new Staff("BOB", new Vector2f(x, y)));
            }
            if (model.getPlaceObject()) {
                map.getObjects(x, y).add(model.getSelectedBuildable());
            }
        }

        if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
            if (model.getPlaceStaff()) {
                map.setStaff(x, y, null);
            }
            if (model.getPlaceObject()) {
                map.getObjects(x, y).clear();
            }
        }

        mouseX = x;
        mouseY = y;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	graphics.translate(keyDownX, keyDownY);
    
    	graphics.scale(scale, scale);
        map.render(graphics);

        if (model.getPlaceObject()) {
            graphics.drawImage(
                model.getSelectedBuildable().getTile(), mouseX * Tile.getSize(), mouseY * Tile.getSize(),
                new Color(1.0f, 1.0f, 1.0f, 0.5f)
            );
        }

        if (model.getPlaceStaff()) {
            graphics.drawImage(
                  new StaffTile().getTile(), mouseX * Tile.getSize(), mouseY * Tile.getSize(),
                  new Color(1.0f, 1.0f, 1.0f, 0.5f)
            );
        }

        taskQueueRenderer.render(graphics, 100, 100, 200, 200);
    	
    	graphics.drawString("Emails: "+emailQueue.waiting()+" Phone Calls: "+PhoneQueue.waiting(), 50, 400);
        graphics.drawString("Reputation: "+Company.company.getReputation(), 50, 350);
        graphics.drawString("Money: "+ Company.company.getMoney(), 60, 50);
    }
}
