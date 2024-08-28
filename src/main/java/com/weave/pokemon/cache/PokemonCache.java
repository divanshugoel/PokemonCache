package com.weave.pokemon.cache;

//import java.util.Collection;
//
//public class PokemonLRUCache<String,Pokemon> extends LRUCache<String,Pokemon>{
//
////    Cache<String,Pokemon> cache;
//
//    public PokemonLRUCache(int capacity) {
//        super(capacity);
//    }
//
//    private void deleteById(int id) {
//        Collection<Node<String,Pokemon>> pokemonList = cache.values();
//        if(!pokemonList.isEmpty()) {
//            for (Node<String, Pokemon> pokemon : cache.values()) {
//
//                for(Pokemon pokemon11 :list){
//
//                }
//                Pokemon pokemon1 = (Pokemon) pokemon.getValue();
//                pokemon1
//
//                pokemonList.removeIf(pokemon -> pokemon.getId() == id);
//                if (pokemonList.isEmpty()) {
//                    cache.values().remove(pokemonList);
//                }
//            }
//        }
//    }
//}

import com.weave.pokemon.entity.Pokemon;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class PokemonCache {
    private static PokemonCache instance;
    public final Map<String, Node> map;
    private final int capacity;
    private Node head;
    private Node tail;

    // Private constructor
    private PokemonCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public static PokemonCache getInstance(int capacity) {
        if (instance == null) {
            synchronized (PokemonCache.class) {
                if (instance == null) {
                    log.debug("creating singleton instance of Pokemon Cache Object");
                    instance = new PokemonCache(capacity);
                }
            }
        }
        log.info("returning singleton instance of Pokemon Cache Object");
        return instance;
    }

    // Add or update Pokemon
    public synchronized void set(Pokemon pokemon) {
        String key = pokemon.getName();
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        if (map.size() >= capacity) {
            log.info("cache is full, removing from last");
            removeLast();
        }
        Node newNode = new Node(pokemon);
        addNode(newNode);
        log.info("updating cache with key {} " , key);
        map.put(key, newNode);
    }

    // Get Pokemon by name
    public synchronized Pokemon get(String name) {
        Node node = map.get(name);
        if (node == null) {
            log.error("{} not found in cache " , name);
            return null;
        }
        removeNode(node);
        addNode(node);
        return (Pokemon) node.pokemon;
    }

    // Delete Pokemon by name
    public synchronized void delete(String name) {
        Node node = map.get(name);
        if (node != null) {
            removeNode(node);
            map.remove(name);
        } else {
            log.error("{} not found in cache, nothing to delete " , name);
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeLast() {
        if (tail.prev != head) {
            map.remove(((Pokemon) tail.prev.pokemon).getName());
            removeNode(tail.prev);
        }
    }
}
