package com.geek.rpg.game.character;

import java.io.Serializable;

/**
 * Created by FlameXander on 16.11.2017.
 */

public class Commander implements Serializable {
    private com.geek.rpg.game.character.Unit[][] units;

    public com.geek.rpg.game.character.Unit[][] getUnits() {
        return units;
    }

    public Commander() {
        units = new com.geek.rpg.game.character.Unit[2][3];
    }

    public void setArmy(com.geek.rpg.game.character.Unit... inUnits) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                units[j][i] = inUnits[counter];
                if(units[j][i] != null) {
                    units[j][i].setCommander(this);
                }
                counter++;
            }
        }
    }
}
