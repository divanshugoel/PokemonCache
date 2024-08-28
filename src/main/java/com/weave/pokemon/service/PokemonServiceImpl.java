package com.weave.pokemon.service;

import com.weave.pokemon.PokemonAppError;
import com.weave.pokemon.cache.CacheFactory;
import com.weave.pokemon.cache.PokemonCache;
import com.weave.pokemon.entity.Pokemon;
import com.weave.pokemon.exception.PokemonAppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private final PokemonCache cache = CacheFactory.createCache(10);

    @Override
    public void addPokemon(Pokemon pokemon) {
        log.info("adding pokemon to cache with name {} ", pokemon.getName());
        cache.set(pokemon);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        log.info("getting pokemon with name {} ", name);
        // TODO :: throw not found exception
        Pokemon pokemon = cache.get(name);
        if (pokemon == null) {
            throw new PokemonAppException(PokemonAppError.NOT_FOUND.getErrorCode(),
                    PokemonAppError.NOT_FOUND.getErrorMessage(),
                    HttpStatus.NOT_FOUND);
        }
        return pokemon;
    }

    @Override
    public Pokemon getPokemonById(int id) {
        log.info("getting pokemon with Id {} ", id);
        return cache.map.values().stream()
                .map(node -> (Pokemon) node.getPokemon())
                .filter(pokemon -> pokemon.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deletePokemonById(int id) {
        log.info("deleting pokemon with Id {} ", id);
        Pokemon pokemon = getPokemonById(id);
        if (pokemon == null) {
            log.info("no pokemon found with Id {} ", id);
            return;
        }
        cache.delete(pokemon.getName());
    }

}
