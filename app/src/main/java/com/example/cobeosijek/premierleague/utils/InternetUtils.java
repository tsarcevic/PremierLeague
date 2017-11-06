package com.example.cobeosijek.premierleague.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by cobeosijek on 06/11/2017.
 */

public class InternetUtils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
