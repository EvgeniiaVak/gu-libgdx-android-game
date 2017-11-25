package com.geek.rpg.game.spfx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.geek.rpg.game.character.Unit;
import com.geek.rpg.game.spfx.SpecialFX;

/**
 * Created by FlameXander on 16.11.2017.
 */

public class SpecialFXEmitter {
    private SpecialFX[] fxs;

    public SpecialFXEmitter() {
        this.fxs = new com.geek.rpg.game.spfx.SpecialFX[100];
        for (int i = 0; i < fxs.length; i++) {
            this.fxs[i] = new com.geek.rpg.game.spfx.SpecialFX();
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < fxs.length; i++) {
            if (fxs[i].isActive()) {
                fxs[i].render(batch);
            }
        }
    }

    public void setup(Unit me, Unit target, float maxTime, float scaleFrom, float scaleTo, float delay, boolean oneCycle) {
        for (int i = 0; i < fxs.length; i++) {
            if (!fxs[i].isActive()) {
                fxs[i].setup(me.getPosition().x + 45, me.getPosition().y + 75,
                        target.getPosition().x + 45, target.getPosition().y + 75,
                        maxTime, scaleFrom, scaleTo, delay, oneCycle);
                break;
            }
        }
    }

    public void update(float dt) {
        for (int i = 0; i < fxs.length; i++) {
            if (fxs[i].isActive()) {
                fxs[i].update(dt);
            }
        }
    }
}
