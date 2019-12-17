package com.ifi.trainer_ui.trainers.service;

import java.util.Arrays;
import java.util.List;


import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Pokemon;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainerServiceImpl implements TrainerService {

    private PokemonTypeService pokemonService;

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        var url = trainerServiceUrl + "/trainers/";
        var trainers = restTemplate.getForObject(url, Trainer[].class);
        Arrays.sort(trainers);
        return Arrays.asList(trainers);
    }

    @Override
    public Trainer getTrainer(String name) {
        var url = trainerServiceUrl + "/trainers/{name}";
        Trainer  oldT = restTemplate.getForObject(url, Trainer.class, name);
        Trainer newT = this.addPokemons(oldT);
        return newT;
    }
    private Trainer addPokemons(Trainer t){
        for (Pokemon p : t.getTeam()) {
            p.setType(pokemonService.getPokemonType(p.getPokemonType()));
        }
        return t;
    }


    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String pokemonServiceUrl) {
        this.trainerServiceUrl = pokemonServiceUrl;
    }

    @Autowired
    void setPokemonService(PokemonTypeService pokemonService) {
        this.pokemonService = pokemonService;
    }
}
