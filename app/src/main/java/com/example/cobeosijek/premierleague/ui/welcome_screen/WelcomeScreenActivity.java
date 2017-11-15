package com.example.cobeosijek.premierleague.ui.welcome_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.ui.team_list.TeamListView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forward_button)
    public void moveToFirstScreen() {
        startActivity(TeamListView.onLaunchIntent(this));

        finish();
    }
}