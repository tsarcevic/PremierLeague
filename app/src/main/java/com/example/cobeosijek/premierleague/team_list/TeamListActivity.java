package com.example.cobeosijek.premierleague.team_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.networking.BackendFactory;
import com.example.cobeosijek.premierleague.networking.NetworkManager;
import com.example.cobeosijek.premierleague.player_list.PlayerListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamListActivity extends AppCompatActivity implements TeamListInterface.View, ItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.team_recycler)
    RecyclerView teamList;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    TeamListAdapter teamListAdapter;
    TeamListInterface.Presenter presenter;


    public static Intent onLaunchIntent(Context from) {
        return new Intent(from, TeamListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        presenter = new TeamListPresenter(NetworkManager.get());
        presenter.setView(this);

        setUI();
        presenter.viewReady();
    }

    private void setUI() {
        ButterKnife.bind(this);
        swipeRefreshLayout.setOnRefreshListener(this);

        teamListAdapter = new TeamListAdapter();
        teamListAdapter.setItemClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        teamList.setLayoutManager(layoutManager);
        teamList.setAdapter(teamListAdapter);
    }

    @Override
    public void showTeamList(List<Team> teamArrayList) {
        teamListAdapter.setTeamList(teamArrayList);
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
    public void showConnectionError() {
        Toast.makeText(getApplicationContext(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
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
    public void openTeamDetails(Team team) {
        startActivity(PlayerListActivity.getLaunchIntent(this, team));
    }
}
