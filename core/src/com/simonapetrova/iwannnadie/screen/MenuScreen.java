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

public class MenuScreen implements Screen {

    private IWannaDie iWannaDie;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture background;
    private Texture playBtn;
//    private BitmapFont font;

    public MenuScreen(IWannaDie iWannaDie){
        this.iWannaDie = iWannaDie;
    }

    @Override
    public void show() {
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false,IWannaDie.WIDTH,IWannaDie.HEIGHT);
        //this.camera.position.set(-0)
        this.camera.update();
        this.background = iWannaDie.assets.manager.get(Assets.background, Texture.class);
        this.playBtn = iWannaDie.assets.manager.get(Assets.playBtn, Texture.class);
//        this.font = new BitmapFont();
//
//        this.font.getData().scale(8);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0/255f, 51/255f, 102/255f, 1); // 	0, 51, 102
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        batch.begin();
        batch.draw(background,0,0);
        batch.draw(playBtn, (IWannaDie.WIDTH/2) - (playBtn.getWidth()/2),(IWannaDie.HEIGHT/2) - (playBtn.getHeight()/2));

//        drawHighScore(genericGame.highscore,batch);
        batch.end();

        if(Gdx.input.justTouched()){
            iWannaDie.gameState = IWannaDie.GAME_STATE.PLAYING;
            iWannaDie.setScreen(new PlayingScreen(iWannaDie));
        }
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
    }


}
