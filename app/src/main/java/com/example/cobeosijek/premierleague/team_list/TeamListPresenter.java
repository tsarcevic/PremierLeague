package com.example.cobeosijek.premierleague.team_list;

import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;
import com.example.cobeosijek.premierleague.networking.NetworkInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public class TeamListPresenter implements TeamListInterface.Presenter {

    protected final NetworkInterface network;
    protected TeamListInterface.View view;
    protected List<Team> teamList = new ArrayList<>();

    public TeamListPresenter(NetworkInterface service) {
        this.network = service;
    }

    @Override
    public void setView(TeamListInterface.View view) {
        this.view = view;
    }

    @Override
    public void viewReady() {
        fetchTeamList();
    }

    @Override
    public void listRefresh() {
        view.showRefreshing();
        fetchTeamList();
    }

    @Override
    public void listItemSelected(int position) {
        if (teamList != null && teamList.size() > position) {
            view.openTeamDetails(teamList.get(position));
        }
    }

    protected void fetchTeamList() {
        network.getAllTeams(getTeamListener());
    }

    protected Callback<TeamsResponse> getTeamListener() {
        return new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                view.hideRefreshing();
                if (response != null && response.body() != null && response.body().getTeams() != null) {
                    teamList = response.body().getTeams();
                    view.showTeamList(teamList);
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                view.hideRefreshing();
                view.showConnectionError();
            }
        };
    }
}
