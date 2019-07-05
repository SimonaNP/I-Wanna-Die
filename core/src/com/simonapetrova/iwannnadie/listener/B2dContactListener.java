package com.simonapetrova.iwannnadie.listener;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.simonapetrova.iwannnadie.model.GameObject;
import com.simonapetrova.iwannnadie.model.Player;
import com.simonapetrova.iwannnadie.world.GameWorld;

public class B2dContactListener implements ContactListener {

    private GameWorld gameWorld;

    public B2dContactListener(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    @Override
    public void beginContact(Contact contact) {
        String classA = contact.getFixtureA().getBody().getUserData().getClass().getName();
        String classB = contact.getFixtureB().getBody().getUserData().getClass().getName();

        if(classA.equals("com.simonapetrova.iwannadie.model.Player") &&
                ((classB.equals("com.simonapetrova.iwannadie.model.Coffee")) ||
                (classB.equals("com.simonapetrova.iwannadie.model.Sleep")) ||
                (classB.equals("com.simonapetrova.iwannadie.model.Ramen")))){

//            Player player = (Player)(contact.getFixtureA().getBody().getUserData());
            gameWorld.remove((GameObject)contact.getFixtureB().getBody().getUserData());
        }
        else if(classB.equals("com.simonapetrova.iwannadie.model.Player") &&
                ((classA.equals("com.simonapetrova.iwannadie.model.Coffee")) ||
                        (classA.equals("com.simonapetrova.iwannadie.model.Sleep")) ||
                        (classA.equals("com.simonapetrova.iwannadie.model.Ramen")))){
//            Player player = (Player)(contact.getFixtureB().getBody().getUserData());
            gameWorld.remove((GameObject)contact.getFixtureB().getBody().getUserData());
        }
        else if(classA.equals("com.simonapetrova.iwannadie.model.Player") &&
                ((classB.equals("com.simonapetrova.iwannadie.model.Work")) ||
                        (classB.equals("com.simonapetrova.iwannadie.model.Uni")))){

//            Player player = (Player)(contact.getFixtureA().getBody().getUserData());
            gameWorld.remove((GameObject)contact.getFixtureB().getBody().getUserData());
        }
        else if(classB.equals("com.simonapetrova.iwannadie.model.Player") &&
                ((classA.equals("com.simonapetrova.iwannadie.model.Work")) ||
                        (classA.equals("com.simonapetrova.iwannadie.model.Uni")))){
//            Player player = (Player)(contact.getFixtureB().getBody().getUserData());
            gameWorld.remove((GameObject)contact.getFixtureB().getBody().getUserData());
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}