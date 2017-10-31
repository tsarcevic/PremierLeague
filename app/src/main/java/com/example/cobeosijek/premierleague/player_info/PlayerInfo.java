package com.example.cobeosijek.premierleague.player_info;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.team_list.TeamListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerInfo extends AppCompatActivity {

    private static String KEY_ID_PLAYER_INFO = "id";

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.date_of_birth)
    TextView playerDateOfBirth;

    @BindView(R.id.nationality)
    TextView playerNationality;

    @BindView(R.id.number)
    TextView playerJerseyNumber;

    @BindView(R.id.market_value)
    TextView playerMarketValue;

    @BindView(R.id.position)
    TextView playerPosition;

    @BindView(R.id.back_button)
    ImageView backButton;

    private int playerId;

    public static Intent getLaunchIntent(Context from, int playerId) {
        Intent intent = new Intent(from, PlayerInfo.class);
        intent.putExtra(KEY_ID_PLAYER_INFO, playerId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        ButterKnife.bind(this);
        getExtras();
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_ID_PLAYER_INFO)) {
            playerId = getIntent().getIntExtra(KEY_ID_PLAYER_INFO, -1);
        }
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        onBackPressed();
    }

    @OnClick(R.id.home_button)
    public void startingPage() {
        startActivity(TeamListActivity.onLaunchIntent(this));
    }
}
