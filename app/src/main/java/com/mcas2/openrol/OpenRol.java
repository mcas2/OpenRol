package com.mcas2.openrol;

import android.app.Application;
import com.mcas2.openrol.DnDCharClasses.DnDCharacter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenRol extends Application {
    // Nombre personaje --> Personaje
    Map<String, DnDCharacter> characters = new HashMap<>();

    public Map<String, DnDCharacter> getCharacters() {return this.characters;}

    public void addCharacter(DnDCharacter newCharacter) {
        this.characters.put(newCharacter.getName(), newCharacter);
    }

    public DnDCharacter getCharacterByName(String characterName) {
        return this.characters.get(characterName);
    }
}
