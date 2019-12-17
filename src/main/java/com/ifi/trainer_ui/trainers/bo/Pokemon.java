package com.ifi.trainer_ui.trainers.bo;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;

public class Pokemon {

    private int pokemonType;

    private int level;

    private int hp;

    private PokemonType type;

    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpPercent(){
        return 100 * this.hp / this.type.getStats().getHp();
    }
}
