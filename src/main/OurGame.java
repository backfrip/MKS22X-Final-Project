package main;

import com.badlogic.gdx.Game;
import screen.*;

public class OurGame extends Game {

    @Override
    public void create() {
	setScreen(new GameScreen(this));
    }

}
