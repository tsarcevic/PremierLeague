package com.example.cobeosijek.premierleague.presentation;

import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.data.response.PlayersResponse;
import com.example.cobeosijek.premierleague.networking.NetworkInterface;
import com.example.cobeosijek.premierleague.ui.player_list.PlayerListInterface;
import com.example.cobeosijek.premierleague.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public class PlayerListPresenter implements PlayerListInterface.Presenter {

    protected final NetworkInterface network;
    protected PlayerListInterface.View view;
    protected Team team;
    protected int teamId;

    protected List<Player> playersList = new ArrayList<>();

    public PlayerListPresenter(NetworkInterface network) {
        this.network = network;
    }

    @Override
    public void setView(PlayerListInterface.View view) {
        this.view = view;
    }

    @Override
    public void setTeam(Team team) {
        if (team != null) {
            view.setTeamName(team.getShortName());
            this.team = team;
        }
    }

    @Override
    public void noTeamReceived() {
        view.navigateBack();
    }

    @Override
    public void backPressed() {
        view.navigateBack();
    }

    @Override
    public void viewReady() {
        fetchPlayerList();
    }

    @Override
    public void listRefresh() {
        view.showRefreshing();
        fetchPlayerList();
    }

    @Override
    public void listItemSelected(int position) {
        if (playersList != null && playersList.size() > position) {
            view.openPlayerDetails(playersList.get(position));
        }
    }

    private void getTeamId() {
        teamId = StringUtils.getTeamIdFromUrl(team);
    }

    private void fetchPlayerList() {
        getTeamId();
        network.getTeamPlayers(getPlayersListener(), teamId);
    }

    private Callback<PlayersResponse> getPlayersListener() {
        return new Callback<PlayersResponse>() {
            @Override
            public void onResponse(Call<PlayersResponse> call, Response<PlayersResponse> response) {
                view.hideRefreshing();
                if (response != null && response.body() != null && response.body().getPlayers() != null) {
                    playersList = response.body().getPlayers();
                    view.showPlayersList(playersList);
                }
            }

            @Override
            public void onFailure(Call<PlayersResponse> call, Throwable t) {
                view.hideRefreshing();
                view.showConnectionError();
            }
        };
    }
}
