package com.agoatnaepizza.Game.Tiles;

import com.agoatnaepizza.Game.maps.Atmospherics.atmosphereEffector;
import com.agoatnaepizza.Game.maps.Atmospherics.temperatureEffector;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 19:49
 */
public class StaffTile extends Tile implements atmosphereEffector, temperatureEffector {

    public StaffTile() {
        super("Resources/Staff/Staff.png", false);
    }

    @Override
    public float getAtmosphereEffect() {
        return (float) -0.5;
    }

    @Override
    public direction getFlowDirection() {
        return direction.all;
    }

    @Override
    public float getTemperatureEffect() {
        return (float) 36.7;
    }
}
