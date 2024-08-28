package com.weave.pokemon.cache;

import com.weave.pokemon.entity.Pokemon;

//public class PokemonCacheFactory {
//
//    public PokemonLRUCache<String, Pokemon> createCache(String type, int capacity) {
//
//        switch (type.toUpperCase()) {
//            case "LRU":
//                return new PokemonLRUCache(capacity);
//            default:
//                throw new IllegalArgumentException("Unknown cache type");
//        }
//    }
//}

public class CacheFactory {
    public static PokemonCache createCache(int capacity) {
        return PokemonCache.getInstance(capacity);
    }
}

