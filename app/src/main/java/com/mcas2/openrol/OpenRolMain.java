package com.mcas2.openrol;

import android.app.Application;
import android.util.Log;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.MissingFields;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpenRolMain extends Application {

    List<DnDCharacter> characters = new ArrayList<>();

    public DnDCharacter inConstruction = null;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            File file = new File(getFilesDir(), "dnd_characters2.json");
            InputStream is = new FileInputStream(file);
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            JSONArray ja = new JSONArray(new JSONTokener(result));

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                DnDCharacter character = DnDCharacter.deserialize(jo);
                characters.add(character);
            }

            is.close();

        } catch (IOException e) {
              e.printStackTrace();
       } catch (JSONException | MissingFields e) {
            Log.e("Error: ", "Personajes incompletos en el JSON. No se lee archivo" );
            characters = new ArrayList<>();
        }
    }


    private SelectCharDnD selector;
    public List<DnDCharacter> getCharacters() {return this.characters;}

    public void addCharacter(DnDCharacter newCharacter) {
        this.characters.add(newCharacter);
    }

    public void informChanges() {
        selector.informNewCharacter();
    }

    public void setSelector(SelectCharDnD selector) {
        this.selector = selector;
    }


    public DnDCharacter getCharacterByPosition(Integer index) {
        return characters.get(index);
    }
}
