package com.example.cobeosijek.premierleague.team_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.data.models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class TeamListAdapter extends RecyclerView.Adapter<TeamListHolder> {

    private List<Team> teamList = new ArrayList<>();

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList.clear();
        this.teamList.addAll(teamList);
        notifyDataSetChanged();
    }

    @Override
    public TeamListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View teamView = layoutInflater.inflate(R.layout.item_team, parent, false);

        return new TeamListHolder(teamView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(TeamListHolder holder, int position) {
        Team team = teamList.get(position);

        holder.setTeamInfo(team);

        if (position % 2 == 1) {
            holder.setGray();
        } else {
            holder.setWhite();
        }

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }
}
