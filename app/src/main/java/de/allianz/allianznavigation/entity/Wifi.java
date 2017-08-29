package de.allianz.allianznavigation.entity;

/**
 * Created by Nadine on 25.08.2017.
 */

public class Wifi {
    private int id;
    private String macAdress;
    private int lvl;
    private int posId;

    public Wifi(int id, String macAdress, int lvl, int posId) {
        this.id = id;
        this.macAdress = macAdress;
        this.lvl = lvl;
        this.posId = posId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }
}
