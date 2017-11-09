package com.example.cobeosijek.premierleague.player_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.networking.NetworkManager;
import com.example.cobeosijek.premierleague.player_info.PlayerInfoActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerListActivity extends AppCompatActivity implements PlayerListInterface.View, ItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static String KEY_TEAM_NAME_PLAYER_LIST = "team_name";

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.player_recycler)
    RecyclerView playerList;

    @BindView(R.id.back_button)
    ImageView backButton;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    PlayerListAdapter playerListAdapter;

    PlayerListInterface.Presenter presenter;

    public static Intent getLaunchIntent(Context from, Team team) {
        Intent intent = new Intent(from, PlayerListActivity.class);
        intent.putExtra(KEY_TEAM_NAME_PLAYER_LIST, team);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        presenter = new PlayerListPresenter(NetworkManager.get());
        presenter.setView(this);

        setUI();
        getExtras();
        presenter.viewReady();
//        presenter.setTeamId(team.getLinks().getPlayers().getHref());
    }

    private void setUI() {
        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(this);

        playerListAdapter = new PlayerListAdapter();
        playerListAdapter.setItemClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        playerList.setLayoutManager(layoutManager);
        playerList.setAdapter(playerListAdapter);
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_TEAM_NAME_PLAYER_LIST)) {
            Team team = (Team) getIntent().getSerializableExtra(KEY_TEAM_NAME_PLAYER_LIST);
            presenter.setTeam(team);
            return;
        }
        presenter.noTeamReceived();
    }

    @Override
    public void setTeamName(String shortName) {
        toolbarText.setText(shortName);
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        presenter.backPressed();
    }

    @Override
    public void onBackPressed() {
        presenter.backPressed();
    }

    @Override
    public void navigateBack() {
        finish();
    }

    @Override
    public void onItemClicked(int position) {
        presenter.listItemSelected(position);
    }

    @Override
    public void onRefresh() {
        presenter.listRefresh();
    }

    @Override
    public void showRefreshing() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(getApplicationContext(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPlayersList(List<Player> playersList) {
        playerListAdapter.setPlayerList(playersList);
    }

    @Override
    public void openPlayerDetails(Player player) {
        startActivity(PlayerInfoActivity.getLaunchIntent(this, player));
    }
}
