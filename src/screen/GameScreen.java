package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import main.*;

public class GameScreen implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture tileImage;
    private SpriteBatch batch;

    public GameScreen(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new FillViewport(80, 45, camera);
	tileImage = new Texture(new FileHandle("resource/img/tile.png"));
	batch = new SpriteBatch();
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

	if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
	    if (!Gdx.graphics.isFullscreen()) {
		Gdx.graphics.setDisplayMode(
			Gdx.graphics.getDesktopDisplayMode().width,
			Gdx.graphics.getDesktopDisplayMode().height, true);
	    } else {
		Gdx.graphics.setDisplayMode(1280, 720, false);
	    }
	}

	camera.update();

	batch.setProjectionMatrix(camera.combined);
	batch.begin();
	drawTile(0, 0);
	drawTile(1, 1);
	drawTile(-1, 1);
	drawTile(-1, -1);
	drawTile(1, -1);
	batch.end();
    }

    private void drawTile(float xpos, float ypos) {
	batch.draw(tileImage, xpos * 4 - (34f / 8), ypos * 2 - (17f / 8),
		34f / 4, 17f / 4);
    }

    @Override
    public void resize(int width, int height) {
	viewport.update(width, height);
    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

}
