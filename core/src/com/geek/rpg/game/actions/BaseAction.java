package com.geek.rpg.game.actions;

import com.geek.rpg.game.character.Unit;

public abstract class BaseAction {
    String name;
    String textureName;

    public BaseAction(String name, String textureName) {
        this.name = name;
        this.textureName = textureName;
    }

    public String getName() {
        return name;
    }

    public String getTextureName() {
        return textureName;
    }

    public abstract boolean action(Unit me);
}
