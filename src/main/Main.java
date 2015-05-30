package main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Launcher class for game.
 */
public class Main {
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.useGL30 = false;
	config.title = "ORIGIN";
	config.width = 1280;
	config.height = 720;
	config.resizable = false;
	// config.addIcon(null, null);
	config.fullscreen = false;
	new LwjglApplication(new OurGame(), config);
    }
}
