package com.agoatnaepizza;

import com.agoatnaepizza.Game.Buildable;
import com.agoatnaepizza.Game.InteractionModel;

import javax.swing.*;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:28
 */
public class UIPanel extends JPanel {

    JComboBox<Buildable> buildables;
    InteractionModel model;
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     * @param model
     */
    public UIPanel(InteractionModel model) {
        buildables = new JComboBox<>(Buildable.values());
        this.model = model;
    }
}
