package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import main.*;

public class GameScreen implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture tileImage;
    private SpriteBatch batch;
    private ShapeRenderer sr;

    public GameScreen(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new FillViewport(80, 45, camera);
	tileImage = new Texture(new FileHandle("resource/img/stile.png"));
	batch = new SpriteBatch();
	sr = new ShapeRenderer();
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
	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
	    Gdx.app.exit();
	}

	camera.update();

	batch.setProjectionMatrix(camera.combined);
	batch.begin();
	batch.end();

	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0, 0.1f, 0.5f, 1);
	sr.circle(0, 0, 1, 20);
	sr.setColor(0.7f, 0, 0, 1);
	sr.circle(0, 0, 0.3f, 10);
	sr.end();
    }

    @Override
    public void dispose() {
	game.dispose();
	batch.dispose();
	sr.dispose();
	tileImage.dispose();
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
    public void resize(int width, int height) {
	viewport.update(width, height);
    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub
    }

}
