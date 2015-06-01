package screen;

import object.Map;
import main.OurGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Diagnostic implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer sr;
    private Map map;

    public Diagnostic(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new FillViewport(80, 45, camera);
	sr = new ShapeRenderer();
	map = new Map("test");
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(1, 1, 1, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
	    Gdx.app.exit();
	}

	camera.update();

	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0, 0.1f, 0.5f, 1);
	sr.circle(0, 0, 1, 20);
	sr.setColor(0.7f, 0, 0, 1);
	sr.circle(0, 0, 0.3f, 10);
	sr.setColor(0.9f, 0, 0, 1);

	char tile;
	for (int x = 0; x < map.length(); x++) {
	    for (int y = 0; y < map.depth(); y++) {
		tile = map.getTile(x, y);
		if (tile == '#')
		    sr.rect(x * 2, y * 2, 2, 2);
		if (tile == 's')
		    sr.circle(x * 2 + 1, y * 2 + 1, 1, 10);
	    }
	}

	sr.end();
    }

    @Override
    public void show() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
	viewport.update(width, height);
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
    }

}
