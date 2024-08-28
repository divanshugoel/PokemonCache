package com.weave.pokemon.entity;

import java.util.List;

import java.util.*;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private double height;
    private double weight;
    private String abilities;

    public Pokemon(int id, String name, String type, double height, double weight, String abilities) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Pokemon{id=" + id + ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities='" + abilities + '\'' + '}';
    }
}