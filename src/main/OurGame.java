package main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;

import screen.*;
import object.Inventory;
import object.Stats;

public class OurGame extends Game {
    public static final String playerName = "Lu";
    public static final Sprite playerSprite = null;
    public static final Stats playerStats = null;
    public static final Inventory playerInventory = null;
    public static Music backgroundTheme;

    @Override
    public void create() {
	backgroundTheme = Gdx.audio.newMusic(new FileHandle(
		"resource/music/music1.mp3"));
	backgroundTheme.setLooping(true);
	setScreen(new Intro(this));
	// setScreen(new GameScreen(this));
    }

}
