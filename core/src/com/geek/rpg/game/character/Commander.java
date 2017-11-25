package com.geek.rpg.game.character;

import java.io.Serializable;

/**
 * Created by FlameXander on 16.11.2017.
 */

public class Commander implements Serializable {
    private boolean isAI;
    private Unit[][] units;

    public Unit[][] getUnits() {
        return units;
    }

    public Commander() {
        units = new Unit[2][3];
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public void setArmy(Unit... inUnits) {
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
