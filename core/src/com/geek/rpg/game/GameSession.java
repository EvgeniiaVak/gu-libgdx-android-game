package com.geek.rpg.game;

import com.badlogic.gdx.Gdx;
import com.geek.rpg.game.character.Commander;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by FlameXander on 20.11.2017.
 */

public class GameSession {
    private static final GameSession ourInstance = new GameSession();

    public static GameSession getInstance() {
        return ourInstance;
    }

    private Commander player;

    private GameSession() {
    }

    public Commander getPlayer() {
        return player;
    }

    public void startNewSession() {
        player = new Commander();
        makeStandartArmy();
    }

    public void saveSession() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Gdx.files.local("mydata.sav").file()));
            oos.writeObject(player);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSession() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Gdx.files.local("mydata.sav").file()));
            this.player = (Commander)ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeStandartArmy() {
        com.geek.rpg.game.character.UnitFactory factory = new com.geek.rpg.game.character.UnitFactory();
        player.setArmy(
                null, factory.createUnit(com.geek.rpg.game.character.UnitFactory.UnitType.KNIGHT, false, false, 1),
                factory.createUnit(com.geek.rpg.game.character.UnitFactory.UnitType.MAGE, false, false, 1), factory.createUnit(com.geek.rpg.game.character.UnitFactory.UnitType.SKELETON, false, false, 1),
                null, null
        );
    }
}
