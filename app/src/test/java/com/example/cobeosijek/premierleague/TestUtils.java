package com.example.cobeosijek.premierleague;

import com.example.cobeosijek.premierleague.data.models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 08/11/2017.
 */

public class TestUtils {

    public static List<Team> generateTeamList() {
        List<Team> list = new ArrayList<>();
        list.add(new Team());
        list.add(new Team());
        list.add(new Team());
        list.add(new Team());
        list.add(new Team());
        return list;
    }
}
