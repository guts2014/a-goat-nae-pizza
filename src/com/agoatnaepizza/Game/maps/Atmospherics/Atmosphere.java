package com.agoatnaepizza.Game.maps.Atmospherics;

import com.agoatnaepizza.Game.GameUI.Renderable;
import com.agoatnaepizza.Game.Tiles.Tile;
import com.agoatnaepizza.Game.maps.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * User: nishad
 * Date: 15/10/14
 * Time: 13:28
 */
public class Atmosphere implements Renderable {
    private byte[][] passable;
    private float[][] atmosphere;
    private float[][] temperature;
    private byte[][] adjacent;
    public final int dx, dy;

    private boolean adjacencyChanged = true;

    @Override
    public void render(Graphics graphics, float x, float y) {
        int size = Tile.getSize();

        //render floor
        for (int i = 0; i < dx; i++) {
            for (int j = 0; j < dy; j++) {
                graphics.setColor(new Color(
                    min(1f, max(0f, 50 / temperature[i][j])),
                    0f,
                    min(1f, max(0f, atmosphere[i][j])),
                    0.4f
                ));

                graphics.drawRect(x + i*size, y + j*size, size, size);
            }
        }
    }

    @Override
    public void render(Graphics graphics, float x, float y, float dx, float dy) {
        int sizeX = (int) (dx / this.dx);
        int sizeY = (int) (dy / this.dy);

        //render floor
        for (int i = 0; i < dx; i++) {
            for (int j = 0; j < dy; j++) {
                graphics.setColor(new Color(
                    min(1f, max(0f, 50 / temperature[i][j])),
                    0f,
                    min(1f, max(0f, atmosphere[i][j])),
                    0.4f
                ));

                graphics.drawRect(i*sizeX, j*sizeY, sizeX, sizeY);
            }
        }
    }

    public enum AtmosphereType {
        // Passable is 8bits so keep it less than 256 ordinals :)
        WALL, GAS
    }

    public Atmosphere(Map map) {
        this.dy = map.getHeightInTiles();
        this.dx = map.getWidthInTiles();

        passable = new byte[dx][dy];
        atmosphere = new float[dx][dy];
        temperature = new float[dx][dy];
        adjacent = new byte[dx][dy];

        for (int i = 0; i < map.getWidthInTiles(); i++) {
            for (int j = 0; j < map.getHeightInTiles(); j++) {
                passable[i][j] = (byte) (map.getFloor(i, j).impassible
                                                 ? AtmosphereType.WALL.ordinal()
                                                 : AtmosphereType.GAS.ordinal());
            }
        }
    }

    public void adjustAtmosphere(int x, int y, float amount) {
        this.atmosphere[x][y] += amount;
    }

    public void adjustTemperature(int x, int y, float amount) {
        this.temperature[x][y] += amount;
    }

    public float getAtmosphere(int x, int y) {
        return atmosphere[x][y];
    }

    public float getTemperature(int x, int y) {
        return temperature[x][y];
    }

    public void setPassable(int x, int y, AtmosphereType type) {
        passable[x][y] = (byte) type.ordinal();
        adjacencyChanged = true;
    }

    public void tick() {
        if (adjacencyChanged) {
            regenerateAdjacencyMatrix();
        }

        // This is to stop null spaces from effecting other tiles.

        // think about paralleling this and move to a double buffer to make thread-safe.
        float[][] newAtmosphere = new float[dx][dy], newTemperature = new float[dx][dy];
        blur(dx, dy, atmosphere, adjacent, newAtmosphere);
        blur(dx, dy, temperature, adjacent, newTemperature);
        this.atmosphere = newAtmosphere;
        this.temperature = newTemperature;
    }

    private void regenerateAdjacencyMatrix() {
        adjacent = new byte[dx][dy];

        for (int i = 1; i < dx - 1; i++) {
            for (int j = 1; j < dy - 1; j++) {
                adjacent[i][j] = calculateAdjacent(i, j, passable);
            }
        }

        adjacencyChanged = false;
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    private static void blur(int dx, int dy, float[][] matrixToBlur, byte[][] passableMatrix, float[][] toMatrix) {
        for (int i = 1; i < dx - 1; i++) {
            for (int j = 1; j < dy - 1; j++) {
                float sum = 0;

                sum += matrixToBlur[i-1][j-1];
                sum += matrixToBlur[i-1][j+0];
                sum += matrixToBlur[i-1][j+1];
                sum += matrixToBlur[i+0][j-1];
                sum += matrixToBlur[i+0][j+0];
                sum += matrixToBlur[i+0][j+1];
                sum += matrixToBlur[i+1][j-1];
                sum += matrixToBlur[i+1][j+0];
                sum += matrixToBlur[i+1][j+1];

                toMatrix[i][j] = sum / passableMatrix[i][j];
            }
        }
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    private static byte calculateAdjacent(int x, int y, byte[][] passable) {
        byte sum = 0;

        sum += passable[x-1][y-1] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x-1][y+0] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x-1][y+1] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+0][y-1] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+0][y+0] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+0][y+1] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+1][y-1] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+1][y+0] == AtmosphereType.WALL.ordinal()? 1 : 0;
        sum += passable[x+1][y+1] == AtmosphereType.WALL.ordinal()? 1 : 0;

        return sum;
    }
}
