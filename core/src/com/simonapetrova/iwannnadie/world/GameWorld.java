package com.simonapetrova.iwannnadie.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.simonapetrova.iwannnadie.IWannaDie;
import com.simonapetrova.iwannnadie.assets.Assets;
import com.simonapetrova.iwannnadie.listener.B2dContactListener;
import com.simonapetrova.iwannnadie.model.Coffee;
import com.simonapetrova.iwannnadie.model.GameObject;
import com.simonapetrova.iwannnadie.model.Ramen;
import com.simonapetrova.iwannnadie.model.Sleep;
import com.simonapetrova.iwannnadie.model.Uni;
import com.simonapetrova.iwannnadie.model.Work;
import com.simonapetrova.iwannnadie.screen.MenuScreen;
import com.simonapetrova.iwannnadie.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorld {
    final static float SIZE = 1;

    private IWannaDie iWannaDie;
    private World physicsWorld;
    private Player player;
    private Stage stage;
    private List<GameObject> gameObjects;

    private float worldWidth;
//    private int score;

    public GameWorld(IWannaDie iWannaDie){
        this.iWannaDie = iWannaDie;
        this.physicsWorld = new World(new Vector2(0,-9.8f),false);
        this.physicsWorld.setContactListener(new B2dContactListener(this));
        float ratio = (float) Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth();
        this.worldWidth = IWannaDie.WORLD_HEIGHT / ratio;
        this.player = new Player(iWannaDie,physicsWorld,iWannaDie.assets.manager.get(Assets.player, Texture.class),
                worldWidth/3 ,IWannaDie.WORLD_HEIGHT / 2,1,1);
        this.stage = new Stage(new StretchViewport(worldWidth,IWannaDie.WORLD_HEIGHT));

        this.stage.addActor(player);
        this.initObjects();

//        this.initWalls();

//        this.score = 0;
    }

    public void render(){
        this.stage.draw();
        physicsWorld.step(Gdx.graphics.getDeltaTime(),6,2);
    }

    public void update(){
        this.stage.act();
        if(!this.player.getTransition()) {
            this.stage.getCamera().position.x = player.getX()+2;
        }
        if(Gdx.input.justTouched()){
            this.player.jump();
        }
        this.regenerateGameObject();
//        this.updateScore();
        if(iWannaDie.gameState == IWannaDie.GAME_STATE.MENU){
//            if(iWannaDie.highscore < score){
//                iWannaDie.highscore = score;
//                iWannaDie.updateHighscore(score);
//            }
            iWannaDie.setScreen(new MenuScreen(iWannaDie));
        }
    }

    private void initObjects(){
        float minX = this.stage.getCamera().position.x;
        float minY =  this.stage.getCamera().position.y;

        gameObjects = new ArrayList<GameObject>(8);
        for(int i = 0; i<2;i++){
            gameObjects.add(new Coffee(iWannaDie,physicsWorld,stage,randNumInInterval(minX,worldWidth*2),
                    randNumInInterval(minY,iWannaDie.WORLD_HEIGHT),SIZE,SIZE));
            gameObjects.add(new Ramen(iWannaDie,physicsWorld,stage,randNumInInterval(minX,worldWidth*2),
                    randNumInInterval(minY,iWannaDie.WORLD_HEIGHT),SIZE,SIZE));
            gameObjects.add(new Sleep(iWannaDie,physicsWorld,stage,randNumInInterval(minX,worldWidth*2),
                    randNumInInterval(minY,iWannaDie.WORLD_HEIGHT),SIZE,SIZE));
        }
        gameObjects.add(new Uni(iWannaDie,physicsWorld,stage,randNumInInterval(minX,worldWidth*2),
                randNumInInterval(minY,iWannaDie.WORLD_HEIGHT),SIZE,SIZE));
        gameObjects.add(new Work(iWannaDie,physicsWorld,stage,randNumInInterval(minX,worldWidth*2),
                randNumInInterval(minY,iWannaDie.WORLD_HEIGHT),SIZE,SIZE));

        for(GameObject e: gameObjects){
            stage.addActor(e);
        }
    }

    private float randNumInInterval(float min, float length){
        Random r = new Random();
        float random = min + r.nextFloat() * length;
        return random;
    }

    private void regenerateGameObject(){
        if(gameObjects.get(0).getX() < stage.getCamera().position.x - worldWidth/2){
            float minX = this.stage.getCamera().position.x;
            float minY =  this.stage.getCamera().position.y;
            GameObject gameObject = new GameObject(iWannaDie,physicsWorld, stage,randNumInInterval(minX,worldWidth*2),
                    randNumInInterval(minY,iWannaDie.WORLD_HEIGHT), SIZE, SIZE, gameObjects.get(0).getTexture());
            gameObjects.remove(0);
            gameObjects.add(gameObject);
        }
    }


    public void remove (GameObject gameObject){
        for(Actor a : stage.getActors()){
            if(a.equals(gameObject)){
                a.remove();
            }
        }
    }
}
