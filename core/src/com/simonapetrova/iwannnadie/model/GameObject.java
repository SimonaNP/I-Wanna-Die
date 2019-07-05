package com.simonapetrova.iwannnadie.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.simonapetrova.iwannnadie.IWannaDie;

public class GameObject extends Image {

    private IWannaDie iWannaDie;
    private World physicsWorld;
    private Body body;
    private Texture texture;
    private Stage stage;

    public GameObject(IWannaDie iWannaDie, World physicsWorld,Stage stage, float x, float y,
                      float width, float height, Texture texture){
        super(texture);
        this.iWannaDie = iWannaDie;
        this.physicsWorld = physicsWorld;
        setPosition(x,y);
        setOrigin(x,y);
        setWidth(width);
        setHeight(height);
        this.texture = texture;
        this.stage = stage;
        initBody();
    }

    private void initBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.KinematicBody;

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

        bodyShape.dispose();
    }

    @Override
    public void act(float delta){
        this.setPosition(body.getPosition().x - getWidth() / 2,body.getPosition().y - getHeight() / 2);
        this.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
    }


    public Texture getTexture() {
        return texture;
    }
}
