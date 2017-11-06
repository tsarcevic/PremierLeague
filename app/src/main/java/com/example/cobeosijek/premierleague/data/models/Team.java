package com.example.cobeosijek.premierleague.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class Team extends BaseModel {

    @SerializedName("_links")
    private DataLinks links;
    private int id;
    private String name;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;

    public Team(DataLinks links, int id, String name, String shortName, String squadMarketValue, String crestUrl) {
        this.links = links;
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.squadMarketValue = squadMarketValue;
        this.crestUrl = crestUrl;
    }

    public DataLinks getLinks() {
        return links;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return getValueOrEmpty(name);
    }

    public String getShortName() {
        return getValueOrEmpty(shortName);
    }

    public String getSquadMarketValue() {
        return getValueOrEmpty(squadMarketValue);
    }

    public String getCrestUrl() {
        return getValueOrEmpty(crestUrl);
    }
}
