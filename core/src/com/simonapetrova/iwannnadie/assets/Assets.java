package com.simonapetrova.iwannnadie.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public AssetManager manager;

    public static String player = "stickman.png";
    public static String playBtn = "playBtn.png";
    public static String sleep = "sleep.png";
    public static String coffee = "coffee.png";
    public static String ramen = "ramen.png";
    public static String uni = "uni.png";
    public static String work = "work.png";
    public static String background = "bg.png";

    public Assets(){
        manager = new AssetManager();
    }

    public void load(){
        manager.load(player, Texture.class);
        manager.load(playBtn, Texture.class);
        manager.load(sleep, Texture.class);
        manager.load(coffee, Texture.class);
        manager.load(ramen, Texture.class);
        manager.load(uni, Texture.class);
        manager.load(work, Texture.class);
        manager.load(background, Texture.class);
    }

    public void dispose(){
        manager.dispose();
    }
}
