package com.example.cobeosijek.premierleague.data.models;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class Player extends BaseModel {

    private String name;
    private String position;
    private int jerseyNumber;
    private String nationality;
    private String dateOfBirth;
    private String contractUntil;

    public Player(String name, String position, int jerseyNumber, String nationality, String dateOfBirth, String contractUntil) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.contractUntil = contractUntil;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContractUntil() {
        return contractUntil;
    }
}
