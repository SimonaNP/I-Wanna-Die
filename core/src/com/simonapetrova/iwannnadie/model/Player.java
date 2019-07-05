package com.simonapetrova.iwannnadie.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.simonapetrova.iwannnadie.IWannaDie;

public class Player extends Image {

    private IWannaDie iWannaDie;
    private World physicsWorld;
    private Body body;
    private boolean transition;

    public Player(IWannaDie iWannaDie, World physicsWorld, Texture texture,float x, float y,
                  float width, float height){
        super(texture);
        this.setX(x);
        this.setY(y);
        this.setOrigin(x,y);
        this.setWidth(width);
        this.setHeight(height);
        this.iWannaDie = iWannaDie;
        this.physicsWorld = physicsWorld;
        this.initBody();
        this.transition = false;
    }

    private void repositionBody(float y){

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(body.getPosition().x,y);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        physicsWorld.destroyBody(body);


        body = physicsWorld.createBody(bodyDef);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(getWidth() / 2,getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = bodyShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.5f;

        body.createFixture(fixtureDef);
        body.setUserData(this);
        body.setLinearVelocity(5,0);

        bodyShape.dispose();


    }
    private void initBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        body = physicsWorld.createBody(bodyDef);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(getWidth() / 2,getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = bodyShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0f;

        body.createFixture(fixtureDef);
        body.setUserData(this);
        body.setLinearVelocity(5,0);

        bodyShape.dispose();

    }

    @Override
    public void act(float delta){
        this.setPosition(body.getPosition().x - getWidth() / 2,body.getPosition().y - getHeight() / 2);

        if(getY() > IWannaDie.WORLD_HEIGHT) {
            repositionBody(-getHeight());
            transition = true;
        }else if(getY() < -2*getHeight()){
            repositionBody(IWannaDie.WORLD_HEIGHT);
            transition = true;
        } else {
            transition = false;
        }
    }

    public boolean getTransition(){
        return this.transition;
    }
    public void jump(){
        body.setLinearVelocity(body.getLinearVelocity().x,0);
        body.applyForceToCenter(0, 150f, true);
    }

    public void die(){
        iWannaDie.gameState = IWannaDie.GAME_STATE.MENU;
    }

}