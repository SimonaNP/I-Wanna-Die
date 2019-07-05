package com.simonapetrova.iwannnadie.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simonapetrova.iwannnadie.IWannaDie;
import com.simonapetrova.iwannnadie.assets.Assets;
import com.simonapetrova.iwannnadie.world.GameWorld;

public class PlayingScreen implements Screen {

    private IWannaDie iWannaDie;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private GameWorld gameWorld;
    private Texture background;
//    private BitmapFont font;

    public PlayingScreen(IWannaDie iWannaDie){
        this.iWannaDie = iWannaDie;
    }

    @Override
    public void show() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false,IWannaDie.WIDTH,IWannaDie.HEIGHT);
        this.gameWorld = new GameWorld(this.iWannaDie);
        this.background = iWannaDie.assets.manager.get(Assets.background, Texture.class);
//        this.font = new BitmapFont();

//        this.font.getData().scale(8);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(55/255f, 51/255f, 102/255f, 1); // 	0, 51, 102
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background,0,0);
        batch.end();
        gameWorld.render();
        batch.begin();
//        drawScore(gameWorld.getScore(),batch);
        batch.end();

        gameWorld.update();
        camera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
