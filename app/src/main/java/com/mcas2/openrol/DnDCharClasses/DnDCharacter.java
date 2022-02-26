package com.mcas2.openrol.DnDCharClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DnDCharacter implements Serializable {
    private Map<String, Integer> attributes;
    private Map<String, String> miscAttributes;
    private String name;
    private int level;

    private List<DnDWeapon> dndWeapons = new ArrayList<>();

    public DnDCharacter() {
        this.attributes = new HashMap<>();
        this.miscAttributes = new HashMap<>();
    }

    public DnDCharacter(Map<String, Integer> attributes, Map<String, String> miscAttributes, String name, int level, List<DnDWeapon> dndWeapons) {
        this.attributes = attributes;
        this.miscAttributes = miscAttributes;
        this.name = name;
        this.level = level;
        this.dndWeapons = dndWeapons;
    }

    public Integer getAttribute(String nameAttribute){
        return attributes.get(nameAttribute);
    }

    public void setAttribute(String nameAttribute, Integer newValue) {
        this.attributes.put(nameAttribute, newValue);
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