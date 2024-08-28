package com.weave.pokemon.cache;

//class Node<K, V> {
//    public K key;
//    public V value;
//    public Node<K, V> prev;
//    public Node<K, V> next;
//
//    public Node(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public void setKey(K key) {
//        this.key = key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//
//    public void setValue(V value) {
//        this.value = value;
//    }
//}

public class Node<Pokemon> {
    public Pokemon pokemon;
    Node prev;
    Node next;

    public Node(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.prev = null;
        this.next = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
