package com.simonapetrova.iwannnadie;

import com.badlogic.gdx.Game;
import com.simonapetrova.iwannnadie.assets.Assets;
import com.simonapetrova.iwannnadie.screen.SplashScreen;

public class IWannaDie extends Game {

    public enum GAME_STATE{
        PLAYING,
        MENU
    }

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static float WORLD_HEIGHT = 10;

	public static final String TITLE = "I Wanna Die";

    public Assets assets;
    public GAME_STATE gameState;
//    public int highscore;
	
	@Override
	public void create () {
        this.assets = new Assets();
        this.setScreen(new SplashScreen(this));

    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		this.assets.dispose();
	}
}
