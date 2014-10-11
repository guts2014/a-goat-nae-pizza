package com.agoatnaepizza.Game;

import com.agoatnaepizza.Game.Objects.Tile;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:48
 */
public class InteractionModel {
    Tile selectedBuildable;
    Boolean placeStaff = false;

    public Tile getSelectedBuildable() {
        return selectedBuildable;
    }

    public void setSelectedBuildable(Tile buildable) {
        this.selectedBuildable = buildable;
    }

    public Boolean getPlaceStaff() {
        return placeStaff;
    }

    public void setPlaceStaff(Boolean placeStaff) {
        this.placeStaff = placeStaff;
    }
}
