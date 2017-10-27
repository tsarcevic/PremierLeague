package com.example.cobeosijek.premierleague.player_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.player_info.PlayerInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerList extends AppCompatActivity implements ItemClickListener {

    private static String KEY_ID_PLAYER_LIST = "id";

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.player_recycler)
    RecyclerView playerRecycler;

    @BindView(R.id.back_button)
    ImageView backButton;

    private int teamId;

    public static Intent getLaunchIntent(Context from, int teamId) {
        Intent intent = new Intent(from, PlayerList.class);
        intent.putExtra(KEY_ID_PLAYER_LIST, teamId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        ButterKnife.bind(this);
        getExtras();
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_ID_PLAYER_LIST)) {
            teamId = getIntent().getIntExtra(KEY_ID_PLAYER_LIST, -1);
        }
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        onBackPressed();
    }

    @Override
    public void onItemClicked(int id) {
        startActivity(PlayerInfo.getLaunchIntent(this, id));
    }
}
