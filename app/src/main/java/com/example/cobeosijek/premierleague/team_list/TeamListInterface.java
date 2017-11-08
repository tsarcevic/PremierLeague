package com.example.cobeosijek.premierleague.team_list;

import com.example.cobeosijek.premierleague.data.models.Team;

import java.util.List;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public interface TeamListInterface {

    interface View {

        void showTeamList(List<Team> teamArrayList);

        void showConnectionError();

        void showRefreshing();

        void hideRefreshing();

        void openTeamDetails(Team team);
    }

    interface Presenter {

        void setView(View view);

        void viewReady();

        void listRefresh();

        void listItemSelected(int position);
    }
}
