package com.example.cobeosijek.premierleague.data.models;

import java.io.Serializable;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class BaseModel implements Serializable {

    protected String getValueOrEmpty(String string) {
        return (string != null) ? string : "";
    }
}
