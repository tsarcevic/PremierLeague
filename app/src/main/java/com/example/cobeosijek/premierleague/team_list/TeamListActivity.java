package com.example.cobeosijek.premierleague.team_list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.networking.ApiService;
import com.example.cobeosijek.premierleague.networking.BackendFactory;
import com.example.cobeosijek.premierleague.player_list.PlayerListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamListActivity extends AppCompatActivity implements ItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.team_recycler)
    RecyclerView teamList;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    TeamListAdapter teamListAdapter;

    List<Team> teamArrayList = new ArrayList<>();

    private ApiService apiService;
    private Retrofit retrofit;

    public static Intent onLaunchIntent(Context from) {
        return new Intent(from, TeamListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        setUI();
        obtainTeamInfo();
    }

    private void setUI() {
        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(this);

        teamListAdapter = new TeamListAdapter();
        teamListAdapter.setItemClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        teamList.addItemDecoration(itemDecoration);
        teamList.setLayoutManager(layoutManager);

        teamList.setAdapter(teamListAdapter);
    }

    private void obtainTeamInfo() {
        retrofit = BackendFactory.setUpRetrofit();
        apiService = BackendFactory.setUpApiService();

        Call<TeamsResponse> call = apiService.getAllTeams();
        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                teamArrayList = response.body().getTeams();
                teamListAdapter.setTeamList(teamArrayList);
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                call.cancel();
                Toast.makeText(TeamListActivity.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(PlayerListActivity.getLaunchIntent(this, teamArrayList.get(position)));
    }

    @Override
    public void onRefresh() {
        obtainTeamInfo();

        swipeRefreshLayout.setRefreshing(false);
    }
}
