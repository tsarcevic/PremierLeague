package com.example.cobeosijek.premierleague.data.response;

import com.example.cobeosijek.premierleague.data.models.Player;

import java.util.List;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class PlayersResponse {

    private int count;
    private List<Player> players;

    public int getCount() {
        return count;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
