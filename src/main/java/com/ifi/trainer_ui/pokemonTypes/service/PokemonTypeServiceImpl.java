package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    public List<PokemonType> listPokemonsTypes() {
        var url = pokemonServiceUrl + "/pokemon-types/";
        PokemonType[] pokemons = restTemplate.getForObject(url, PokemonType[].class);
        Arrays.sort(pokemons);
        return Arrays.asList(pokemons);
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        var url = pokemonServiceUrl + "/pokemon-types/{id}";
        return restTemplate.getForObject(url, PokemonType.class, id);
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
        // TODO
    }
}
