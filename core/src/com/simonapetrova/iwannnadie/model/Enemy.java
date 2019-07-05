package com.simonapetrova.iwannnadie.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.simonapetrova.iwannnadie.IWannaDie;

public abstract class Enemy extends GameObject {
    public Enemy(IWannaDie iWannaDie, World physicsWorld, Stage stage, float x, float y, float width, float height, Texture texture) {
        super(iWannaDie, physicsWorld,stage, x, y, width, height, texture);
    }
}
