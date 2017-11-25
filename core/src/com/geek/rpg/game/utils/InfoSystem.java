package com.geek.rpg.game.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InfoSystem {
    private com.geek.rpg.game.utils.FlyingText[] msgs;
    private int msgCount;

    public InfoSystem() {
        this.msgs = new com.geek.rpg.game.utils.FlyingText[20];
        for (int i = 0; i < msgs.length; i++) {
            this.msgs[i] = new com.geek.rpg.game.utils.FlyingText();
        }
    }

    public void addMessage(String text, com.geek.rpg.game.character.Unit unit, com.geek.rpg.game.utils.FlyingText.Colors color) {
        addMessage(text, unit.getPosition().x + unit.WIDTH / 2, unit.getPosition().y + unit.HEIGHT / 2, color);
    }

    public void addMessage(String text, float x, float y, com.geek.rpg.game.utils.FlyingText.Colors color) {
        for (int i = 0; i < msgs.length; i++) {
            if (!msgs[i].isActive()) {
                msgs[i].setup(text, x, y - msgCount * 20, color);
                break;
            }
        }
        msgCount++;
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        for (int i = 0; i < msgs.length; i++) {
            if (msgs[i].isActive()) {
                msgs[i].render(batch, font);
            }
        }
    }

    public void update(float dt) {
        msgCount = 0;
        for (int i = 0; i < msgs.length; i++) {
            if (msgs[i].isActive()) {
                msgs[i].update(dt);
            }
        }
    }
}
