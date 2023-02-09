package com.example.webclient.models;

import lombok.Data;

@Data
public class RickAndMortyCharacter {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;


}
