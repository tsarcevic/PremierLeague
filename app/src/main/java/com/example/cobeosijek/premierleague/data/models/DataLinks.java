package com.example.cobeosijek.premierleague.data.models;

/**
 * Created by cobeosijek on 30/10/2017.
 */

public class DataLinks extends BaseModel {

    private PlayerLink players;

    public DataLinks(PlayerLink players) {
        this.players = players;
    }

    public PlayerLink getPlayers() {
        return players;
    }
}
