package com.simonapetrova.iwannnadie.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.simonapetrova.iwannnadie.IWannaDie;
import com.simonapetrova.iwannnadie.assets.Assets;

public class Ramen extends GameObject {
    public Ramen(IWannaDie iWannaDie, World physicsWorld, Stage stage, float x, float y,
                 float width, float height) {
        super(iWannaDie, physicsWorld,stage, x, y, width, height, iWannaDie.assets.manager.get(Assets.ramen, Texture.class));
    }
}
