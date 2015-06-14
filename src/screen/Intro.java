package screen;

import main.OurGame;
import object.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Intro implements Screen {
    private OurGame game;
    private ShapeRenderer sr;
    private BitmapFont text, title;
    private SpriteBatch batch;
    private SpriteCache cache;
    private Texture background;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator generator2;
    private FreeTypeFontParameter parameter;
    private FreeTypeFontParameter parameter2;

    public Intro(OurGame gameRef) {
	game = gameRef;
	sr = new ShapeRenderer();
	batch = new SpriteBatch();
	cache = new SpriteCache();
	text = new BitmapFont();
	title = new BitmapFont();
	background = new Texture(new FileHandle(
		"resource/background/introduction.jpg"));
	generator = new FreeTypeFontGenerator(
		Gdx.files.internal("resource/fonts/Olde English Regular.ttf"));
	generator2 = new FreeTypeFontGenerator(
		Gdx.files.internal("resource/fonts/Tangerine_Regular.ttf"));
	parameter = new FreeTypeFontParameter();
	parameter2 = new FreeTypeFontParameter();
	parameter.size = 250;
	title = generator.generateFont(parameter);
	parameter2.size = 42;
	text = generator2.generateFont(parameter2);
    }


    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(1, 1, 1, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	batch.begin();

	// batch.draw(image, 250, 200);
	batch.draw(background, 0, 0, Gdx.graphics.getWidth(),
		Gdx.graphics.getHeight());
	// text.setColor(0.7f, 0.2f, 0.2f, 1);
	title.setColor(Color.MAROON);
	title.draw(batch, "Origin", 375, 700);
	text.draw(batch, "Press Any Key to Start", 500, 175);
	batch.end();
	if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
	    dispose();
	    game.setScreen(new GameScreen(game));
	}
	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();
	if (Gdx.input.isKeyJustPressed(Keys.F11)) {
	    if (!Gdx.graphics.isFullscreen()) {
		Gdx.graphics.setDisplayMode(
			Gdx.graphics.getDesktopDisplayMode().width,
			Gdx.graphics.getDesktopDisplayMode().height, true);
		Gdx.input.setCursorCatched(true);
	    } else {
		Gdx.graphics.setDisplayMode(1280, 720, false);
		Gdx.input.setCursorCatched(false);
	    }
	}
    }

    @Override
    public void show() {
	OurGame.backgroundTheme.play();
    }

    @Override
    public void resize(int width, int height) {
	// viewport.update(width, height);
	// batch = new SpriteBatch();
    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
	sr.dispose();
	batch.dispose();
	cache.dispose();
	text.dispose();
	generator.dispose();
	generator2.dispose();
    }
}
