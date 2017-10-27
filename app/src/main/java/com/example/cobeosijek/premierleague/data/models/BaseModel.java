package com.example.cobeosijek.premierleague.data.models;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class BaseModel {

    protected String getValueOrEmpty(String string) {
        return (string != null) ? string : "";
    }
}
