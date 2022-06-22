package com.example.battleships.models.DTOs.dataExport;

import javax.validation.constraints.NotNull;

public class BattleShipDTO {

    @NotNull
    private String attacker;
    @NotNull
    private String defender;

    public BattleShipDTO() {
    }

    public String getAttacker() {
        return attacker;
    }

    public BattleShipDTO setAttacker(String attacker) {
        this.attacker = attacker;
        return this;
    }

    public String getDefender() {
        return defender;
    }

    public BattleShipDTO setDefender(String defender) {
        this.defender = defender;
        return this;
    }
}
