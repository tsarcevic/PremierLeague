package com.example.cobeosijek.premierleague.player_info;

import com.example.cobeosijek.premierleague.data.models.Player;

/**
 * Created by cobeosijek on 09/11/2017.
 */

public interface PlayerInfoInterface {

    interface View {
        void navigateBack();

        void navigateHome();

        void setPlayerName(String name);

        void setPlayerNationality(String nationality);

        void setPlayerNumber(String jerseyNumber);

        void setPlayerBirthDate(String dateOfBirth);

        void setPlayerPosition(String position);

        void setPlayerContract(String contractUntil);
    }

    interface Presenter {
        void setView(View view);

        void viewReady();

        void backPressed();

        void homePressed();

        void setPlayer(Player player);
    }
}
