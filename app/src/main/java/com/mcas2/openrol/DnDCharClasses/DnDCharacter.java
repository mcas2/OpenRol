package com.mcas2.openrol.DnDCharClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class DnDCharacter implements Serializable {
    private String name;
    private int level;
    private String race;
    private String charclass;
    private int armorClass;
    private int competencia;
    private int initiative;
    private int speed;
    private int pgm;
    private int pga;
    private int pgt;
    private String dg;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private int athletics;
    private int acrobatics;
    private int sleightOfHand;
    private int stealth;
    private int arcana;
    private int history;
    private int investigation;
    private int nature;
    private int religion;
    private int animalHandling;
    private int insight;
    private int medicine;
    private int perception;
    private int survival;
    private int deception;
    private int intimidation;
    private int performance;
    private int persuasion;



    private boolean inspiration;

    private String magic;
    private String lore;

    private ArrayList<DnDWeapon> dndWeapons;

    public DnDCharacter(String name, int level, String race, String charclass, int armorClass,
                        int competencia, int initiative, int speed, int pgm, int pga, int pgt,
                        String dg, int strength, int dexterity, int constitution, int intelligence,
                        int wisdom, int charisma, int athletics, int acrobatics, int sleightOfHand,
                        int stealth, int arcana, int history, int investigation, int nature, int religion,
                        int animalHandling, int insight, int medicine, int perception, int survival,
                        int deception, int intimidation, int performance, int persuasion, boolean inspiration,
                        String magic, String lore, ArrayList<DnDWeapon> dndWeapons) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.charclass = charclass;
        this.armorClass = armorClass;
        this.competencia = competencia;
        this.initiative = initiative;
        this.speed = speed;
        this.pgm = pgm;
        this.pga = pga;
        this.pgt = pgt;
        this.dg = dg;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.athletics = athletics;
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
        this.arcana = arcana;
        this.history = history;
        this.investigation = investigation;
        this.nature = nature;
        this.religion = religion;
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
        this.inspiration = inspiration;
        this.magic = magic;
        this.lore = lore;
        this.dndWeapons = dndWeapons;
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

    public String getCharclass() {
        return charclass;
    }

    public void setCharclass(String charclass) {
        this.charclass = charclass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getCompetencia() {
        return competencia;
    }

    public void setCompetencia(int competencia) {
        this.competencia = competencia;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPgm() {
        return pgm;
    }

    public void setPgm(int pgm) {
        this.pgm = pgm;
    }

    public int getPga() {
        return pga;
    }

    public void setPga(int pga) {
        this.pga = pga;
    }

    public int getPgt() {
        return pgt;
    }

    public void setPgt(int pgt) {
        this.pgt = pgt;
    }

    public String getDg() {
        return dg;
    }

    public void setDg(String dg) {
        this.dg = dg;
    }

    public boolean isInspiration() {
        return inspiration;
    }

    public void setInspiration(boolean inspiration) {
        this.inspiration = inspiration;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public ArrayList<DnDWeapon> getDndWeapons() {
        return dndWeapons;
    }

    public void setDndWeapons(ArrayList<DnDWeapon> dndWeapons) {
        this.dndWeapons = dndWeapons;
    }
}
