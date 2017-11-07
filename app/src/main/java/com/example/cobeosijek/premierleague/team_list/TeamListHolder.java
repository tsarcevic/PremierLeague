package com.example.cobeosijek.premierleague.team_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.image.ImageLoader;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;

import butterknife.BindColor;
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

    @BindView(R.id.root_view)
    ViewGroup root;

    @BindColor(R.color.gray)
    int grayColor;

    @BindColor(R.color.white)
    int whiteColor;

    private ItemClickListener itemClickListener;

    public TeamListHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemClickListener = itemClickListener;
    }

    public void setTeamInfo(Team team) {
        if (team != null) {
            ImageLoader.loadCrestImage(teamCrest, team.getCrestUrl());
            teamName.setText(team.getName());
            shortTeamName.setText(team.getShortName());
        }
    }

    @OnClick
    public void teamClicked() {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(getAdapterPosition());
        }
    }

    public void setGray() {
        root.setBackgroundColor(grayColor);
    }

    public void setWhite() {
        root.setBackgroundColor(whiteColor);
    }
}
