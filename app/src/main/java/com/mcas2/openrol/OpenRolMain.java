package com.mcas2.openrol;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.JsonReader;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.DnDWeapon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenRolMain extends Application {
    // Nombre personaje --> Personaje
    List<DnDCharacter> characters = new ArrayList<DnDCharacter>() {{
        add(new DnDCharacter("Mario", 10, new HashMap<>(), new HashMap<> (), new HashMap<>()));
        add(new DnDCharacter("Rodrigo", 15, new HashMap<>(), new HashMap<> (), new HashMap<>()));
    }};;

    //Hacer aquí el fichero
    public OpenRolMain() throws IOException {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "dnd_characters.json");
            JsonReader reader = new JsonReader(new FileReader(file));
            reader.setLenient(true);

            for (int i = 0; i < jar.length(); i++) {
                JSONObject obj = jar.getJSONObject(i);
                addCharacter(DnDCharacter.deserialize(obj));
            }
            fr.close();

        } catch (FileNotFoundException | JSONException e){
            e.printStackTrace();
        }
    }

    //¿Dónde colocar el onPause? Fragments?

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
