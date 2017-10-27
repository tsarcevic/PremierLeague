package com.example.cobeosijek.premierleague.models;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class Player {

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
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMarketValue() {
        return marketValue;
    }
}
