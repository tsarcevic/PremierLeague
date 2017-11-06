package com.example.cobeosijek.premierleague.player_list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Player;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.data.response.PlayersResponse;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.networking.ApiService;
import com.example.cobeosijek.premierleague.networking.BackendFactory;
import com.example.cobeosijek.premierleague.player_info.PlayerInfoActivity;
import com.example.cobeosijek.premierleague.utils.InternetUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlayerListActivity extends AppCompatActivity implements ItemClickListener {

    private static String KEY_TEAM_NAME_PLAYER_LIST = "team_name";
    private static String KEY_ID_PLAYER_LIST = "id";

    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @BindView(R.id.player_recycler)
    RecyclerView playerList;

    @BindView(R.id.back_button)
    ImageView backButton;

    @BindView(R.id.no_internet)
    TextView noInternetConnection;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    PlayerListAdapter playerListAdapter;

    private ApiService apiService;
    private Retrofit retrofit;
    private List<Player> playerArrayList;

    Team team;

    public static Intent getLaunchIntent(Context from, Team team) {
        Intent intent = new Intent(from, PlayerListActivity.class);
        intent.putExtra(KEY_TEAM_NAME_PLAYER_LIST, team);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        setUI();
        getExtras();
        extractTeamId();
        checkInternetConnection();
        setSwiping();
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

    private void setUI() {
        ButterKnife.bind(this);

        playerListAdapter = new PlayerListAdapter();
        playerListAdapter.setItemClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        playerList.addItemDecoration(itemDecoration);
        playerList.setLayoutManager(layoutManager);

        playerList.setAdapter(playerListAdapter);
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_TEAM_NAME_PLAYER_LIST)) {
            team = (Team) getIntent().getSerializableExtra(KEY_TEAM_NAME_PLAYER_LIST);
        }

        toolbarText.setText(team.getShortName());
    }

    private int extractTeamId() {
        String teamId = team.getLinks().getPlayers().getHref();

        String[] segmentSeparator = teamId.split("/");

        teamId = segmentSeparator[segmentSeparator.length - 2];

        return Integer.parseInt(teamId);
    }

    private void checkInternetConnection() {
        if (InternetUtils.isNetworkAvailable(this)) {
            obtainPlayerInfo();
        } else {
            noInternetConnection.setVisibility(View.VISIBLE);
            playerList.setVisibility(View.GONE);
        }
    }

    private void obtainPlayerInfo() {
        noInternetConnection.setVisibility(View.GONE);
        playerList.setVisibility(View.VISIBLE);

        retrofit = BackendFactory.setUpRetrofit();
        apiService = BackendFactory.setUpApiService();

        Call<PlayersResponse> call = apiService.getTeamPlayers(extractTeamId());
        call.enqueue(new Callback<PlayersResponse>() {
            @Override
            public void onResponse(Call<PlayersResponse> call, Response<PlayersResponse> response) {
                playerArrayList = response.body().getPlayers();
                playerListAdapter.setPlayerList(playerArrayList);
            }

            @Override
            public void onFailure(Call<PlayersResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @OnClick(R.id.back_button)
    public void returnBack() {
        onBackPressed();
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(PlayerInfoActivity.getLaunchIntent(this, playerArrayList.get(position)));
    }
}
