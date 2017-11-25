package com.geek.rpg.game.actions;

public class MeleeAttackAction extends BaseAction {
    public MeleeAttackAction() {
        super("MELEE_ATTACK", "btnMeleeAttack");
    }

    @Override
    public boolean action(com.geek.rpg.game.character.Unit me) {
        if (me.getTarget() == null) return false;
        if (me.isMyTeammate(me.getTarget())) return false;
        me.setAttackAction(1.0f);
        me.setCurrentAnimation(com.geek.rpg.game.character.Unit.AnimationType.ATTACK);
        if (!com.geek.rpg.game.utils.Calculator.isTargetEvaded(me, me.getTarget())) {
            int dmg = com.geek.rpg.game.utils.Calculator.getMeleeDamage(me, me.getTarget());
            me.getTarget().changeHp(-dmg);
        } else {
            me.getTarget().evade();
        }
        return true;
    }
}
