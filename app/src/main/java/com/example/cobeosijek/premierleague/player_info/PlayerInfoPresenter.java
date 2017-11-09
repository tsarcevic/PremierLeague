package com.example.cobeosijek.premierleague.player_info;

import com.example.cobeosijek.premierleague.data.models.Player;

/**
 * Created by cobeosijek on 09/11/2017.
 */

public class PlayerInfoPresenter implements PlayerInfoInterface.Presenter {

    PlayerInfoInterface.View view;

    @Override
    public void setView(PlayerInfoInterface.View view) {
        this.view = view;
    }

    @Override
    public void viewReady() {

    }

    @Override
    public void backPressed() {
        view.navigateBack();
    }

    @Override
    public void homePressed() {
        view.navigateHome();
    }

    @Override
    public void setPlayer(Player player) {
        view.setPlayerName(player.getName());
        view.setPlayerNationality(player.getNationality());
        view.setPlayerNumber(String.valueOf(player.getJerseyNumber()));
        view.setPlayerBirthDate(player.getDateOfBirth());
        view.setPlayerPosition(player.getPosition());
        view.setPlayerContract(player.getContractUntil());
    }
}
