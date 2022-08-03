package marvelapi.controllers;

import marvelapi.model.CharactersData;
import marvelapi.services.MarvelCharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MarvelController {
    private MarvelCharacterService characterService;

    public MarvelController(MarvelCharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public Flux<CharactersData> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("/characters/{id}")
    public Mono<CharactersData> getCharacterById(@PathVariable("id") Integer id) {
        return characterService.getCharacterById(id);
    }
}
