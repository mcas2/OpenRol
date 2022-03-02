package com.mcas2.openrol;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.JsonReader;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.DnDWeapon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.grpc.internal.JsonParser;


public class OpenRol extends Application {
    // Nombre personaje --> Personaje
    List<DnDCharacter> characters = new ArrayList<DnDCharacter>() {{
        add(new DnDCharacter("Maedhros", 10, new HashMap<>(), new HashMap<> (), new HashMap<>()));
        add(new DnDCharacter("Zanzagaes", 15, new HashMap<>(), new HashMap<> (), new HashMap<>()));
    }};;

    public OpenRol() throws IOException {
        try {
            FileReader fr = new FileReader("dnd_characters.json");
            Object obj = JsonParser.parse(String.valueOf(fr));
            JSONArray ja = (JSONArray) obj;
            for (int i = 0; i < ja.length(); i++) {
                characters.add(DnDCharacter.deserialize(ja.getJSONObject(i)));
            }
            fr.close();

        } catch (FileNotFoundException | JSONException e){
            List<DnDCharacter> characters = new ArrayList<DnDCharacter>();
        }
    }

    //¿Dónde colocar el onPause? Fragments?

    /*Aquí hacer el fichero*/

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
