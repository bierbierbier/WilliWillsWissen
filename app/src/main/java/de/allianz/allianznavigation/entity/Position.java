package de.allianz.allianznavigation.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nadine on 25.08.2017.
 */

public class Position extends Point {
    List<Wifi> wifis = new LinkedList<>();

    public Position(int id, int x, int y, int mapId, List<Wifi> wifis) {
        super(id, x, y, mapId);
        this.wifis = wifis;
    }



}
