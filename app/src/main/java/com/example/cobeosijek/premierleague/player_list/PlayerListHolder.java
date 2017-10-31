package com.example.cobeosijek.premierleague.player_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.data.models.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cobeosijek on 27/10/2017.
 */

class PlayerListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.player_name)
    TextView playerName;

    @BindView(R.id.player_position)
    TextView playerPosition;

    @BindView(R.id.player_number)
    TextView playerNumber;

    private ItemClickListener itemClickListener;

    public PlayerListHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemClickListener = itemClickListener;
    }

    public void setPlayerInfo(Player player) {
        if (player != null) {
            playerName.setText(player.getName());
            playerPosition.setText(player.getPosition());
            playerNumber.setText(String.valueOf(player.getJerseyNumber()));
        }
    }

    @OnClick
    public void playerClicked() {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(getAdapterPosition());
        }
    }
}
