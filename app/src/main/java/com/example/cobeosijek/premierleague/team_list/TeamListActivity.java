package com.example.cobeosijek.premierleague.team_list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.data.response.TeamsResponse;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.networking.ApiService;
import com.example.cobeosijek.premierleague.networking.BackendFactory;
import com.example.cobeosijek.premierleague.player_list.PlayerListActivity;
import com.example.cobeosijek.premierleague.utils.InternetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamListActivity extends AppCompatActivity implements ItemClickListener {

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.team_recycler)
    RecyclerView teamList;

    @BindView(R.id.no_internet)
    TextView noInternetConnection;

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
        checkInternetConnection();
        setSwiping();
    }

    private void setUI() {
        ButterKnife.bind(this);

        teamListAdapter = new TeamListAdapter();
        teamListAdapter.setItemClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        teamList.addItemDecoration(itemDecoration);
        teamList.setLayoutManager(layoutManager);

        teamList.setAdapter(teamListAdapter);
    }

    private void setSwiping() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                checkInternetConnection();

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void checkInternetConnection() {
        if (InternetUtils.isNetworkAvailable(this)) {
            obtainTeamInfo();
        } else {
            noInternetConnection.setVisibility(View.VISIBLE);
            teamList.setVisibility(View.GONE);
        }
    }

    private void obtainTeamInfo() {
        teamList.setVisibility(View.VISIBLE);
        noInternetConnection.setVisibility(View.GONE);

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
            }
        });
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(PlayerListActivity.getLaunchIntent(this, teamArrayList.get(position)));
    }
}
