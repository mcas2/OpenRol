package com.mcas2.openrol.FutureDevelopment;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

//CLASE SIN FUNCIONAMIENTO, POTENCIAL AMPLIACIÓN
public class DnDWeapon implements Serializable {
    private Drawable icon;
    private String weaponName;
    private Integer dices;
    private Integer diceFaces;
    private String properties;

    public DnDWeapon(String weaponName, Integer dices, Integer diceFaces, String properties, Drawable icon) {
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
