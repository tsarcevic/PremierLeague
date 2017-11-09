package com.example.cobeosijek.premierleague.utils;

import com.example.cobeosijek.premierleague.data.models.Team;

/**
 * Created by cobeosijek on 09/11/2017.
 */

public class StringUtils {

    public static int getTeamIdFromUrl(Team team) {

        int teamId = 0;

        if (team != null) {
            String[] segmentSeparator = team.getLinks().getPlayers().getHref().split("/");
            teamId = Integer.parseInt(segmentSeparator[segmentSeparator.length - 2]);
        }

        return teamId;
    }
}
