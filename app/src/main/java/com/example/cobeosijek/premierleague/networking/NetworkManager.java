package com.example.cobeosijek.premierleague.networking;

import com.example.cobeosijek.premierleague.data.response.PlayersResponse;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;

import retrofit2.Callback;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public class NetworkManager implements NetworkInterface {

    private static NetworkManager networkManager;
    private final ApiService apiService;

    public NetworkManager() {
        apiService = BackendFactory.getApiServiceInstance();
    }

    public static NetworkInterface get() {
        if (networkManager == null) {
            networkManager = new NetworkManager();
        }
        return networkManager;
    }

    @Override
    public void getAllTeams(Callback<TeamsResponse> teamListener) {
        apiService.getAllTeams().enqueue(teamListener);
    }

    @Override
    public void getTeamPlayers(Callback<PlayersResponse> playersListener, int teamId) {
        apiService.getTeamPlayers(teamId).enqueue(playersListener);
    }
}
