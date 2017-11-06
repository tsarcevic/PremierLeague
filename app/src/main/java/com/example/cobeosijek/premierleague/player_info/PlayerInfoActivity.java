package com.example.cobeosijek.premierleague.player_info;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.team_list.TeamListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerInfoActivity extends AppCompatActivity {

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

    private Player player;

    public static Intent getLaunchIntent(Context from, Player player) {
        Intent intent = new Intent(from, PlayerInfoActivity.class);
        intent.putExtra(KEY_PLAYER_PLAYER_INFO, player);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        ButterKnife.bind(this);
        getExtras();
        insertText();
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_PLAYER_PLAYER_INFO)) {
            player = (Player) getIntent().getSerializableExtra(KEY_PLAYER_PLAYER_INFO);
        }
    }

    private void insertText() {
        playerName.setText(String.format(getString(R.string.player_name), player.getName()));
        playerNationality.setText(String.format(getString(R.string.player_nationality), player.getNationality()));
        playerJerseyNumber.setText(String.format(getString(R.string.player_number), player.getJerseyNumber()));
        playerPosition.setText(String.format(getString(R.string.player_position), player.getPosition()));
        playerBirthDate.setText(String.format(getString(R.string.player_birth_date), player.getDateOfBirth()));
        playerContract.setText(String.format(getString(R.string.player_contract), player.getContractUntil()));
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        onBackPressed();
    }

    @OnClick(R.id.home_button)
    public void startingPage() {
        startActivity(TeamListActivity.onLaunchIntent(this).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }
}
