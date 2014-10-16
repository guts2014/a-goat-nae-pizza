package com.agoatnaepizza.Game.GameUI;

import org.newdawn.slick.Graphics;

/**
 * User: nishad
 * Date: 16/10/14
 * Time: 12:16
 */
public interface Renderable {
    public void render(Graphics graphics, float x, float y);
    public void render(Graphics graphics, float x, float y, float dx, float dy);
}
