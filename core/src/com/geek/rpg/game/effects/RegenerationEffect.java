package com.geek.rpg.game.effects;


import com.geek.rpg.game.utils.FlyingText;
import com.geek.rpg.game.character.Unit;

public class RegenerationEffect extends Effect {
    @Override
    public void start(Unit unit, int rounds) {
        super.start(unit, rounds);
        unit.getBattleScreen().getInfoSystem().addMessage("Regeneration 3T/+2HP", unit, FlyingText.Colors.GREEN);
    }

    @Override
    public void tick() {
        super.tick();
        unit.getBattleScreen().getInfoSystem().addMessage("Regeneration", unit, FlyingText.Colors.GREEN);
        unit.changeHp((int)(unit.getMaxHp() * 0.05f));
    }

    @Override
    public void end() {
        unit.getBattleScreen().getInfoSystem().addMessage("Regeneration end", unit, FlyingText.Colors.WHITE);
    }
}
