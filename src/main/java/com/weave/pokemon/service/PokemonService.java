package com.weave.pokemon.service;

import com.weave.pokemon.entity.Pokemon;

public interface PokemonService {
    void addPokemon(Pokemon pokemon);
    Pokemon getPokemonByName(String name);
    Pokemon getPokemonById(int id);
    void deletePokemonById(int id);
}
