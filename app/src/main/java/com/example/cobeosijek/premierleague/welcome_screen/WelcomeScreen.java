package com.example.cobeosijek.premierleague.welcome_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.team_list.TeamListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forward_button)
    public void moveToFirstScreen() {
        startActivity(TeamListActivity.onLaunchIntent(this));

        finish();
    }
}