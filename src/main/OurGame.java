package main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;

import screen.*;

import object.Inventory;
import object.Stats;

public class OurGame extends Game {
    public static final String playerName = "Lu";
    public static final Sprite playerSprite = null;
    public static final Stats playerStats = null;
    public static final Inventory playerInventory = null;

    @Override
    public void create() {
	// setScreen(new Intro(this));
	setScreen(new GameScreen(this));
    }

}
