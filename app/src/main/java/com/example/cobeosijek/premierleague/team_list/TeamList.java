package com.example.cobeosijek.premierleague.team_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.player_list.PlayerList;

import butterknife.BindView;

public class TeamList extends AppCompatActivity implements ItemClickListener {

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.team_recycler)
    RecyclerView teamList;

    public static Intent onLaunchIntent(Context from) {
        return new Intent(from, TeamList.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
    }

    @Override
    public void onItemClicked(int id) {
        startActivity(PlayerList.getLaunchIntent(this, id));
    }
}
