package com.agoatnaepizza;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("java.library.path", "libs");
        //Extracted from Distributing Your LWJGL Application
        System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath());

        JFrame frame = new MainView("");


    }
}
