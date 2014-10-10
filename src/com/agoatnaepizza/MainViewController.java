package com.agoatnaepizza;

import javax.swing.*;
import java.awt.*;

/**
 * User: nishad
 * Date: 10/10/14
 * Time: 22:41
 */
public class MainViewController extends JFrame {
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
    public MainViewController(String title) throws HeadlessException {
        super(title);
    }


}
