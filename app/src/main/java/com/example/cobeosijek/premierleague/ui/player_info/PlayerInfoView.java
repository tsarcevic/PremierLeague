package com.example.cobeosijek.premierleague.ui.player_info;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.presentation.PlayerInfoPresenter;
import com.example.cobeosijek.premierleague.ui.team_list.TeamListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerInfoView extends AppCompatActivity implements PlayerInfoInterface.View {

    private static String KEY_PLAYER_PLAYER_INFO = "id";

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.nationality)
    TextView playerNationality;

    @BindView(R.id.number)
    TextView playerJerseyNumber;

    @BindView(R.id.contract)
    TextView playerContract;

    @BindView(R.id.position)
    TextView playerPosition;

    @BindView(R.id.name)
    TextView playerName;

    @BindView(R.id.birth_date)
    TextView playerBirthDate;

    @BindView(R.id.back_button)
    ImageView backButton;

    PlayerInfoInterface.Presenter presenter;

    public static Intent getLaunchIntent(Context from, Player player) {
        Intent intent = new Intent(from, PlayerInfoView.class);
        intent.putExtra(KEY_PLAYER_PLAYER_INFO, player);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        ButterKnife.bind(this);

        presenter = new PlayerInfoPresenter();
        presenter.setView(this);

        getExtras();
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_PLAYER_PLAYER_INFO)) {
            Player player = (Player) getIntent().getSerializableExtra(KEY_PLAYER_PLAYER_INFO);
            presenter.setPlayer(player);
        }
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        presenter.backPressed();
    }

    @Override
    public void navigateBack() {
        finish();
    }

    @OnClick(R.id.home_button)
    public void startingPage() {
        presenter.homePressed();
    }

    @Override
    public void navigateHome() {
        startActivity(TeamListView.onLaunchIntent(this).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }

    @Override
    public void setPlayerName(String name) {
        playerName.setText(String.format(getString(R.string.player_name), name));
    }

    @Override
    public void setPlayerNationality(String nationality) {
        playerNationality.setText(String.format(getString(R.string.player_nationality), nationality));
    }

    @Override
    public void setPlayerNumber(String jerseyNumber) {
        playerJerseyNumber.setText(String.format(getString(R.string.player_number), jerseyNumber));
    }

    @Override
    public void setPlayerBirthDate(String dateOfBirth) {
        playerBirthDate.setText(String.format(getString(R.string.player_birth_date), dateOfBirth));
    }

    @Override
    public void setPlayerPosition(String position) {
        playerPosition.setText(String.format(getString(R.string.player_position), position));
    }

    @Override
    public void setPlayerContract(String contractUntil) {
        playerContract.setText(String.format(getString(R.string.player_contract), contractUntil));
    }
}
