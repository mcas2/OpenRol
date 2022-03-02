package com.mcas2.openrol.DnDCharClasses;

import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DnDCharacter implements Serializable {
    private Map<String, Integer> attributes;
    private Map<String, String> miscAttributes;
    private Map<String, Boolean> competences;
    private String name;
    private Integer level;
    private Bitmap image;


    private List<DnDWeapon> dndWeapons = new ArrayList<>();

    public DnDCharacter() {
        this.name = "";
        this.level = 1;
        this.attributes = new HashMap<>();
        this.miscAttributes = new HashMap<>();
        this.competences = new HashMap<>();
    }

    public DnDCharacter(String name, Integer level, Map<String, Integer> attributes, Map<String, String> miscAttributes, Map<String, Boolean> competences) {
        if (name == null || level == null)
            throw new MissingFields();

        this.name = name;
        this.level = level;
        this.attributes = attributes;
        this.miscAttributes = miscAttributes;
        this.competences = competences;
    }

    public Integer getAttribute(String nameAttribute){
        return attributes.getOrDefault(nameAttribute, 0);
    }

    public void setAttribute(String nameAttribute, Integer newValue) {
        this.attributes.put(nameAttribute, newValue);
    }

    public Boolean getCompetences(String nameCompetence) {
        return competences.getOrDefault(nameCompetence, false);
    }

    public void setCompetences(String nameCompetence, Boolean competence) {
        this.competences.put(nameCompetence, competence);
    }

    public String getCharAttribute(String nameCharAttribute){
        return miscAttributes.get(nameCharAttribute);
    }

    public void setCharAttribute(String nameCharAttribute, String newValue) {
        this.miscAttributes.put(nameCharAttribute, newValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public JSONObject serialize (){
        //En el primero se guardan los otros
        JSONObject personaje = new JSONObject();
        //Pertenencen a personaje
        JSONObject atributos = new JSONObject();
        JSONObject miscAttributes = new JSONObject();
        JSONObject competencias = new JSONObject();

        try{
            personaje.put("name", this.name);
            personaje.put("level", this.level);

            //Atributos
            for (String key : this.attributes.keySet()) {
                atributos.put(key, this.attributes.get(key));
            }

            personaje.put("attributes", atributos);

            //Misc
            for (String key : this.miscAttributes.keySet()) {
                miscAttributes.put(key, this.miscAttributes.get(key));
            }

            personaje.put("miscAttributes", miscAttributes);

            //Competencias
            for (String key : this.competences.keySet()) {
                competencias.put(key, this.competences.get(key));
            }

            personaje.put("competences", competencias);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personaje;
    }

    public static DnDCharacter deserialize (JSONObject personajeJSON) throws JSONException {
        //Individual
        String name = personajeJSON.getString("name");
        Integer level = Integer.parseInt(personajeJSON.getString("level"));

        // Read attributes
        Map attributes = new HashMap<String, Integer>();
        JSONObject attributesJSON = personajeJSON.getJSONObject("attributes");
        Iterator<String> keys = attributesJSON.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            attributes.put(key, attributesJSON.getInt(key));
        }

        // Read miscAttributes
        Map miscAttributes = new HashMap<String, String>();
        JSONObject miscAttributesJSON = personajeJSON.getJSONObject("miscAttributes");
        keys = miscAttributesJSON.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            miscAttributes.put(key, miscAttributesJSON.getString(key));
        }

        // Read competences
        Map competences = new HashMap<String, Boolean>();
        JSONObject competencesJSON = personajeJSON.getJSONObject("competences");
        keys = competencesJSON.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            competences.put(key, competencesJSON.getBoolean(key));
        }

        return new DnDCharacter(name, level, attributes, miscAttributes, competences);
    }

    public boolean isComplete() {
        return name != null && name != "" && level != null;
    }
}