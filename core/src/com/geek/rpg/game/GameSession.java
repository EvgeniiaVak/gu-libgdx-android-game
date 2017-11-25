package com.geek.rpg.game;

import com.badlogic.gdx.Gdx;
import com.geek.rpg.game.character.Commander;
import com.geek.rpg.game.character.UnitFactory;

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

    private Commander player, enemy;

    private GameSession() {
    }

    public Commander getPlayer() {
        return player;
    }
    public Commander getEnemy() {
        return enemy;
    }

    public void startNewSession() {
        player = new Commander();
        enemy = new Commander();
        enemy.setAI(true);
        makeStandardArmy(player);
        makeStandardArmy(enemy);
    }

    public void saveSession() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Gdx.files.local("mydata.sav").file()));
            oos.writeObject(player);
            oos.writeObject(enemy);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSession() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Gdx.files.local("mydata.sav").file()));
            this.player = (Commander)ois.readObject();
            this.enemy = (Commander)ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeStandardArmy(Commander commander) {
        UnitFactory factory = new UnitFactory();

        // FIXME: 11/25/17 make enemy army revert rows

        commander.setArmy(
                null,
                factory.createUnit(UnitFactory.UnitType.KNIGHT, commander.isAI(), commander.isAI(), 1),
                factory.createUnit(UnitFactory.UnitType.MAGE, commander.isAI(), commander.isAI(), 1),
                factory.createUnit(UnitFactory.UnitType.SKELETON, commander.isAI(), commander.isAI(), 1),
                null, null
        );
    }
}
