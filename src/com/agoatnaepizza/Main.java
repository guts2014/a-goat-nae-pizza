package com.agoatnaepizza;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("java.library.path", "libs");
        //Extracted from Distributing Your LWJGL Application
        System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath());

        try {
            AppGameContainer container = new AppGameContainer(new GameLoop());
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
