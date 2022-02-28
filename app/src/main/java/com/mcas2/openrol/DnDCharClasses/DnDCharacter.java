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
import java.util.List;
import java.util.Map;

public class DnDCharacter implements Serializable {
    private Map<String, Integer> attributes;
    private Map<String, String> miscAttributes;
    private Map<String, Boolean> competences;
    private String name;
    private int level;
    private Bitmap image;


    private List<DnDWeapon> dndWeapons = new ArrayList<>();

    public DnDCharacter() {
        this.attributes = new HashMap<>();
        this.miscAttributes = new HashMap<>();
        this.competences = new HashMap<>();
    }

    public DnDCharacter(String name, int level, Map<String, Integer> attributes, Map<String, String> miscAttributes, Map<String, Boolean> competences) {
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

    public int getLevel() {
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
        JSONObject personaje = new JSONObject();
        JSONObject atributos = new JSONObject();

        try{
        personaje.put("name", this.name);

        for (String key : this.attributes.keySet()) {
            atributos.put(key, this.attributes.get(key));
        }

        personaje.put("attributes", atributos);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personaje;
    }

    public static DnDCharacter deserialize (JSONObject personajeJSON){
        try {
            //Individual
            String name = personajeJSON.getString("name");

            //Map
            Map attributes = new HashMap<String, Integer>();

            JSONObject attributesJSON = personajeJSON.getJSONObject("attributes");
            JSONArray keys = attributesJSON.names ();

            for (int i = 0; i < keys.length (); i++) {
                String key = keys.getString (i); // Here's your key
                Integer value = attributesJSON.getInt(key); // Here's your value
                attributes.put(key, value);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //return new Character(name, attributes, );
    }
}