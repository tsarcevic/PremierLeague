package com.example.cobeosijek.premierleague.data.models;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class Player extends BaseModel {

    private int id;
    private String name;
    private String position;
    private int jerseyNumber;
    private String nationality;
    private String marketValue;

    public Player(int id, String name, String position, int jerseyNumber, String nationality, String marketValue) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
        this.marketValue = marketValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return getValueOrEmpty(name);
    }

    public String getPosition() {
        return getValueOrEmpty(position);
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getNationality() {
        return getValueOrEmpty(nationality);
    }

    public String getMarketValue() {
        return getValueOrEmpty(marketValue);
    }
}
