package com.example.cobeosijek.premierleague.image;

import android.widget.ImageView;

import com.example.cobeosijek.premierleague.R;
import com.example.cobeosijek.premierleague.image.GlideApp;

/**
 * Created by cobeosijek on 30/10/2017.
 */

public class ImageLoader {

    public static void loadImage(ImageView target, String url) {
        GlideApp.with(target.getContext())
                .load(url)
                .into(target);
    }

    public static void loadCrestImage(ImageView target, String url) {
        GlideApp.with(target.getContext())
                .load(url)
                .error(R.drawable.ic_premier_league_crest)
                .into(target);
    }
}
