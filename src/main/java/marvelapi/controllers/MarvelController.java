package marvelapi.controllers;

import marvelapi.model.character.CharactersData;
import marvelapi.model.comics.Comics;
import marvelapi.model.comics.ComicsData;
import marvelapi.services.MarvelCharacterService;
import marvelapi.services.MarvelComicsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MarvelController {
    private MarvelCharacterService characterService;
    private MarvelComicsService comicsService;

    public MarvelController(MarvelCharacterService characterService, MarvelComicsService comicsService) {
        this.characterService = characterService;
        this.comicsService = comicsService;
    }

    @GetMapping("/characters")
    public Flux<CharactersData> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("/characters/{id}")
    public Mono<CharactersData> getCharacterById(@PathVariable("id") Integer id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping("/comics/{id}")
    public Mono<ComicsData> getComicsById(@PathVariable("id") Integer id){
        return comicsService.getComicsById(id);
    }

    @GetMapping("/comics")
    public Flux<ComicsData> getComics(){
        return comicsService.getComics();
    }
}
