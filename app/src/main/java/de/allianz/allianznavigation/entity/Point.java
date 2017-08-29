package de.allianz.allianznavigation.entity;

/**
 * Created by Nadine on 25.08.2017.
 */

public abstract class Point {
    protected int id;
    protected int x;
    protected int y;
    protected int mapId;

    public Point(int id, int x, int y, int mapId) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.mapId = mapId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }
}
