package com.weave.pokemon.service;

import com.weave.pokemon.cache.CacheFactory;
import com.weave.pokemon.cache.PokemonCache;
import com.weave.pokemon.entity.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class PokemonServiceImplTest{

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    PokemonCache cache;

    @BeforeEach
    void initialize(){
        cache= CacheFactory.createCache(3);
        Pokemon charmander = new Pokemon(4, "Charmander", "Fire", 0.6, 8.5, "Blaze, Solar Power");
        Pokemon bulbasaur = new Pokemon(7, "Bulbasaur", "Grass/Poison", 0.7, 6.9, "Overgrow, Chlorophyll");
        Pokemon squirtle = new Pokemon(10, "Squirtle", "Water", 0.5, 9.0, "Torrent, Rain Dish");
        cache.set(charmander);
        cache.set(bulbasaur);
        cache.set(squirtle);

    }
    @Test
    void addPokemon() {
        Pokemon pokemon = getPokemon();
        pokemonService.addPokemon(pokemon);
        assertEquals("Pikachu",pokemon.getName());
    }

    private Pokemon getPokemon() {
        Pokemon pikachu = new Pokemon(1, "Pikachu", "Electric", 0.4, 6.0, "Static, Lightning Rod");
//        Pokemon charmander = new Pokemon(4, "Charmander", "Fire", 0.6, 8.5, "Blaze, Solar Power");
//        Pokemon bulbasaur = new Pokemon(7, "Bulbasaur", "Grass/Poison", 0.7, 6.9, "Overgrow, Chlorophyll");
//        Pokemon squirtle = new Pokemon(10, "Squirtle", "Water", 0.5, 9.0, "Torrent, Rain Dish");
        return pikachu;
    }

    @Test
    void getPokemonByName() {
        Pokemon pokemon = pokemonService.getPokemonByName("Bulbasaur");
        assertEquals(7, pokemon.getId());
    }

    @Test
    void getPokemonById() {
        Pokemon pokemon = pokemonService.getPokemonById(7);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    void deletePokemonById() {
        int actualSize = cache.map.size();
        pokemonService.deletePokemonById(7);
        assertEquals(actualSize-1, cache.map.size());
    }
}