package com.example.cobeosijek.premierleague.team_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cobeosijek on 27/10/2017.
 */

class TeamListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.team_crest)
    ImageView teamCrest;

    @BindView(R.id.team_name)
    TextView teamName;

    @BindView(R.id.short_team_name)
    TextView shortTeamName;

    @BindView(R.id.market_value)
    TextView marketValue;

    private ItemClickListener itemClickListener;

    private int id;

    public TeamListHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemClickListener = itemClickListener;
    }

    public void setTeamInfo(Team team) {
        if (team != null) {
            id = team.getId();

            if (team.getCrestUrl() != null && !team.getCrestUrl().isEmpty()) {
                Picasso.with(teamCrest.getContext()).load(team.getCrestUrl()).into(teamCrest);
            }

            teamName.setText(team.getName());
            shortTeamName.setText(team.getShortName());
            marketValue.setText(team.getSquadMarketValue());
        }
    }

    @OnClick
    public void teamClicked() {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(id);
        }
    }
}
