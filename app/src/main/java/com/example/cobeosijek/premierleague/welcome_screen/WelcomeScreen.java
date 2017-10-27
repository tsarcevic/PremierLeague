package com.example.cobeosijek.premierleague.welcome_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.team_list.TeamList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeScreen extends AppCompatActivity {

    @BindView(R.id.premier_league_crest)
    ImageView premierLeagueCrest;

    @BindView(R.id.welcome_screen_text)
    TextView welcomeScreenText;

    @BindView(R.id.forward_button)
    ImageView forwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forward_button)
    public void moveToFirstScreen() {
        startActivity(TeamList.onLaunchIntent(this));
    }
}