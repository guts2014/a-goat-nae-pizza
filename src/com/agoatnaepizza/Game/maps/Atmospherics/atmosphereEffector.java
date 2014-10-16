package com.agoatnaepizza.Game.maps.Atmospherics;

/**
 * User: nishad
 * Date: 15/10/14
 * Time: 22:03
 */
public interface atmosphereEffector {

    public enum direction {
        up, down, left, right, all
    }

    public float getAtmosphereEffect();
    public direction getFlowDirection();
}
