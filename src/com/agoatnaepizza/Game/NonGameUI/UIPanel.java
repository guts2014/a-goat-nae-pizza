package com.agoatnaepizza.Game.NonGameUI;

import com.agoatnaepizza.Game.InteractionModel;
import net.java.dev.designgridlayout.DesignGridLayout;

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
    DesignGridLayout layout;

    ButtonGroup group = new ButtonGroup();
    JRadioButton None = new JRadioButton("None"), Object = new JRadioButton("Objects"), Staff = new JRadioButton("Staff");

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     * @param model
     */
    public UIPanel(InteractionModel model) {
        this.model = model;
        this.layout = new DesignGridLayout(this);

        group.add(None);
        group.add(Object);
        group.add(Staff);
    }

    public void populate() {

        this.buildables = new JComboBox<>(Buildable.getNames().toArray());

        None.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlaceStaff(false);
                model.setPlaceObject(false);
            }
        });

        Object.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlaceStaff(false);
                model.setPlaceObject(true);
            }
        });

        Staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlaceStaff(true);
                model.setPlaceObject(false);
            }
        });

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

        None.setSelected(true);

        layout.row().grid().add(buildables);
        layout.row().grid().add(None);
        layout.row().grid().add(Object);
        layout.row().grid().add(Staff);
    }

}
