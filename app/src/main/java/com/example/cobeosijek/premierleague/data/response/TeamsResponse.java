package com.example.cobeosijek.premierleague.data.response;

import com.example.cobeosijek.premierleague.data.models.Team;

import java.util.List;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class TeamsResponse {

    private int count;
    private List<Team> teams;

    public int getCount() {
        return count;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
