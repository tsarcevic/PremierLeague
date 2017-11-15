package com.example.cobeosijek.premierleague.ui.player_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.data.models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListHolder> {

    private List<Player> playerList = new ArrayList<>();

    private ItemClickListener itemClickListener;

    public void setPlayerList(List<Player> playerList) {
        this.playerList.clear();
        this.playerList.addAll(playerList);
        notifyDataSetChanged();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public PlayerListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View playerView = layoutInflater.inflate(R.layout.item_player, parent, false);

        return new PlayerListHolder(playerView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(PlayerListHolder holder, int position) {
        Player player = playerList.get(position);

        holder.setPlayerInfo(player);
        if (position % 2 == 1) {
            holder.setGray();
        } else {
            holder.setWhite();
        }

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
