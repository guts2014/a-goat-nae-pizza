package com.agoatnaepizza;

import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.SlickException;

import javax.swing.*;
import java.awt.*;

/**
 * User: nishad
 * Date: 11/10/14
 * Time: 13:41
 */
public class MainView extends JFrame {

    CanvasGameContainer gc;

    /**
     * Creates a new, initially invisible <code>Frame</code> with the
     * specified title.
     * <p/>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param title the title for the frame
     * @throws java.awt.HeadlessException if GraphicsEnvironment.isHeadless()
     *                                    returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     * @see java.awt.Component#setSize
     * @see java.awt.Component#setVisible
     * @see javax.swing.JComponent#getDefaultLocale
     */
    public MainView(String title) throws HeadlessException {
        super(title);

        JPanel game = new JPanel();
        JPanel UI = new JPanel();

        setSize(1000, 600);
        game.setSize(getWidth() - 200, getHeight());
        game.setFocusable(true);
        game.requestFocus();
        game.setIgnoreRepaint(true);
        game.setVisible(true);

        UI.setSize(200, 800);

        setVisible(true);

        add(game);

        try {
            gc = new CanvasGameContainer(new MainState("Root"));
            game.add(gc);

            gc.setSize(getWidth() - 200, getHeight());
            gc.setFocusable(true);
            gc.requestFocus();
            gc.setIgnoreRepaint(true);
            gc.setVisible(true);

            add(UI);

            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
