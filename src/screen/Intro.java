package screen;

import main.OurGame;
import object.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
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



public class Intro implements Screen{
	private OurGame game;
    private ShapeRenderer sr;
    private BitmapFont text;
    private SpriteBatch batch;
    private SpriteCache cache;
	
	public Intro(OurGame gameRef){
		game = gameRef;
				sr = new ShapeRenderer();
		batch = new SpriteBatch();
		cache = new SpriteCache();
		text = new BitmapFont();
	}
    @Override
	public void render(float delta){
    	Gdx.gl.glClearColor(1, 1, 1, 1);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	batch.begin();

        //batch.draw(image, 250, 200);
        batch.draw(new Texture("../resource/background/introduction.jpg"), 0, 0);

        batch.end();
    	if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
    		game.setScreen(new DiagnosticII(game));
    	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
    	    Gdx.app.exit();
    	if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
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
	// TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
	//viewport.update(width, height);
	//batch = new SpriteBatch();
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
	game.dispose();
	sr.dispose();
	batch.dispose();
	cache.dispose();
	text.dispose();
    }
}
