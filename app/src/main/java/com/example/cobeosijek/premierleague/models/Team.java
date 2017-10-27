package com.example.cobeosijek.premierleague.models;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class Team {

    private int id;
    private String name;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;

    public Team(int id, String name, String shortName, String squadMarketValue, String crestUrl) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.squadMarketValue = squadMarketValue;
        this.crestUrl = crestUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }
}
