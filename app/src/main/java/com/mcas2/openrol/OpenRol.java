package com.mcas2.openrol;

import android.app.Application;
import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.DnDWeapon;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenRol extends Application {
    // Nombre personaje --> Personaje
    List<DnDCharacter> characters = new ArrayList<DnDCharacter>() {{
        add(new DnDCharacter("Maedhros", 10, new HashMap<>(), new HashMap<> (), new HashMap<>()));
        add(new DnDCharacter("Zanzagaes", 15, new HashMap<>(), new HashMap<> (), new HashMap<>()));
    }};;

    private SelectCharDnD selector;
    public List<DnDCharacter> getCharacters() {return this.characters;}

    public void addCharacter(DnDCharacter newCharacter) {
        this.characters.add(newCharacter);
        selector.informNewCharacter();
    }

    public void setSelector(SelectCharDnD selector) {
        this.selector = selector;
    }
}
