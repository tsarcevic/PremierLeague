package com.example.cobeosijek.premierleague.networking;

import com.example.cobeosijek.premierleague.data.response.PlayersResponse;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;

import retrofit2.Callback;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public interface NetworkInterface {

    void getAllTeams(Callback<TeamsResponse> teamListener);

    void getTeamPlayers(Callback<PlayersResponse> playersListener, int teamId);
}
