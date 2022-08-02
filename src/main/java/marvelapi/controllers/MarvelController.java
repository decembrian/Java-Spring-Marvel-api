package marvelapi.controllers;

import marvelapi.model.CharactersData;
import marvelapi.services.MarvelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MarvelController {
    private MarvelService marvelService;

    public MarvelController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping("/characters")
     public Flux<CharactersData> getCharacters(){
        return marvelService.getCharacters();
     }

    @GetMapping( "/characters/{id}")
    public Mono<CharactersData> getCharacterById(@PathVariable("id") Integer id){
        return marvelService.getCharacterById(id);
    }
}
