package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.*;

public class GameScreen implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private CharSequence str;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private int counter;

    public GameScreen(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	spriteBatch = new SpriteBatch();
	font = new BitmapFont();
	counter = 0;
    }

    @Override
    public void dispose() {
	game.dispose();
    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	str = Integer.toString(counter);
	counter++;

	spriteBatch.begin();
	font.draw(spriteBatch, str, 10, 470);
	spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

}
