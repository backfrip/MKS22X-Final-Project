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

    public GameScreen(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
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
	Gdx.gl.glClearColor(1, 1, 1, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
