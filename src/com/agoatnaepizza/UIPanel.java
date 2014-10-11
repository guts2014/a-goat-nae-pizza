package com.agoatnaepizza;

import com.agoatnaepizza.Game.Buildable;
import com.agoatnaepizza.Game.InteractionModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 15:28
 */
public class UIPanel extends JPanel {

    JComboBox<Object> buildables;
    InteractionModel model;
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     * @param model
     */
    public UIPanel(InteractionModel model) {
        this.model = model;
    }

    public void populate() {

        this.buildables = new JComboBox<>(Buildable.getNames().toArray());

        buildables.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = buildables.getSelectedItem();
                if (o instanceof String) {
                    model.setSelectedBuildable(Buildable.getBuildables().get((String) o));
                }
            }
        });

        this.add(buildables);
    }

}
