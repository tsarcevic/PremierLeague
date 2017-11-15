package com.example.cobeosijek.premierleague.ui.player_list;

import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.data.models.Team;

import java.util.List;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public interface PlayerListInterface {

    interface View {

        void showRefreshing();

        void hideRefreshing();

        void showConnectionError();

        void showPlayersList(List<Player> playersList);

        void openPlayerDetails(Player player);

        void setTeamName(String shortName);

        void navigateBack();
    }

    interface Presenter {

        void setView(View view);

        void listRefresh();

        void viewReady();

        void listItemSelected(int position);

        void setTeam(Team team);

        void backPressed();

        void noTeamReceived();

    }
}
