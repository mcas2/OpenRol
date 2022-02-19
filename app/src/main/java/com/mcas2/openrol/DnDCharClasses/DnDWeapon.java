package com.mcas2.openrol.DnDCharClasses;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class DnDWeapon implements Serializable {
    private Drawable icon;
    private String weaponName;
    private int dices;
    private int diceFaces;
    private String properties;

    public DnDWeapon(String weaponName, int dices, int diceFaces, String properties, Drawable icon) {
        this.icon = icon;
        this.weaponName = weaponName;
        this.dices = dices;
        this.diceFaces = diceFaces;
        this.properties = properties;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDices() {
        return dices;
    }

    public void setDices(int dices) {
        this.dices = dices;
    }

    public int getDiceFaces() {
        return diceFaces;
    }

    public void setDiceFaces(int diceFaces) {
        this.diceFaces = diceFaces;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
