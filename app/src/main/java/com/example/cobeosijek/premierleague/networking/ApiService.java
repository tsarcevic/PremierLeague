package com.example.cobeosijek.premierleague.networking;

import com.example.cobeosijek.premierleague.data.response.PlayersResponse;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public interface ApiService {

    @GET("competitions/445/teams")
    Call<TeamsResponse> getAllTeams();

    @GET("teams/{id}/players")
    Call<PlayersResponse> getTeamPlayers(@Path(value = "id") int id);

}