package com.example.cobeosijek.premierleague;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

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
    }
}