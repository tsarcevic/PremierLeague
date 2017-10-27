package com.example.cobeosijek.premierleague.player_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.interfaces.ItemClickListener;
import com.example.cobeosijek.premierleague.models.Player;
import com.example.cobeosijek.premierleague.models.Team;
import com.squareup.picasso.Picasso;

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

    private int id;

    public PlayerListHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemClickListener = itemClickListener;
    }

    public void setPlayerInfo(Player player) {
        if (player != null) {
            id = player.getId();

            playerName.setText(player.getName());
            playerPosition.setText(player.getPosition());
            playerNumber.setText(player.getPosition());
        }
    }

    @OnClick
    public void playerClicked() {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(id);
        }
    }
}
