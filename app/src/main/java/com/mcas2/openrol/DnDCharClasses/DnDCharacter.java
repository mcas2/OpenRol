package com.mcas2.openrol.DnDCharClasses;

import android.os.Build;

import androidx.annotation.RequiresApi;

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
}