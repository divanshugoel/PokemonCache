//package com.weave.pokemon.entity;
//
//public class PokemonBuilder {
//    private final int id;
//    private final String name;
//    private final String type;
//    private final double height;
//    private final double weight;
//    private final String abilities;
//
//    private PokemonBuilder(Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.type = builder.type;
//        this.height = builder.height;
//        this.weight = builder.weight;
//        this.abilities = builder.abilities;
//    }
//
//    public int getId() {
//        return this.id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String getType() {
//        return this.type;
//    }
//
//    public double getHeight() {
//        return this.height;
//    }
//
//    public double getWeight() {
//        return this.weight;
//    }
//
//    public String getAbilities() {
//        return this.abilities;
//    }
//
//    @Override
//    public String toString() {
//        return "Pokemon{" +
//                "id=" + this.id +
//                ", name='" + this.name + '\'' +
//                ", type='" + this.type + '\'' +
//                ", height=" + this.height +
//                ", weight=" + this.weight +
//                ", abilities='" + this.abilities + '\'' +
//                '}';
//    }
//
//    public static class Builder {
//        private int id;
//        private String name;
//        private String type;
//        private double height;
//        private double weight;
//        private String abilities;
//
//        public Builder setId(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setType(String type) {
//            this.type = type;
//            return this;
//        }
//
//        public Builder setHeight(double height) {
//            this.height = height;
//            return this;
//        }
//
//        public Builder setWeight(double weight) {
//            this.weight = weight;
//            return this;
//        }
//
//        public Builder setAbilities(String abilities) {
//            this.abilities = abilities;
//            return this;
//        }
//
//        public PokemonBuilder build() {
//            return new PokemonBuilder(this);
//        }
//    }
//}
