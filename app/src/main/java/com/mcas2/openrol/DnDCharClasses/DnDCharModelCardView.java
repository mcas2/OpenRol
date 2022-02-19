package com.mcas2.openrol.DnDCharClasses;

public class DnDCharModelCardView {
    private String name;
    private int level;
    private int imagen;

    public DnDCharModelCardView(String name, int level, int imagen) {
        this.name = name;
        this.level = level;
        this.imagen = imagen;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
