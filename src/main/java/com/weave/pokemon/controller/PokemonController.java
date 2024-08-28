package com.weave.pokemon.controller;

import com.weave.pokemon.entity.Pokemon;
import com.weave.pokemon.service.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {


    private PokemonServiceImpl service;

    @Autowired
    public PokemonController(PokemonServiceImpl companyServiceImpl) {
        this.service = companyServiceImpl;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {

        // TODO :: Need to Validate Pokemon Data, handle exception if not able to add

        service.addPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemon);

    }
    /**
     * Get Pokémon by name
     *
     * @param name Pokémon name
     * @return ResponseEntity with Pokémon details or 404 if not found
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable("name") String name) {
        Pokemon pokemon = service.getPokemonByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    /**
     * Get Pokémon by ID
     *
     * @param id Pokémon ID
     * @return ResponseEntity with Pokémon details or 404 if not found
     */
    @GetMapping(value= "/id")
    public ResponseEntity<Pokemon> getPokemonById(@RequestParam("id") Integer id) {
        Pokemon pokemon = service.getPokemonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Integer> deletePokemonById(@PathVariable Integer id) {
        service.deletePokemonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
