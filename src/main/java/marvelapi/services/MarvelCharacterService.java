package marvelapi.services;

import lombok.extern.slf4j.Slf4j;
import marvelapi.model.CharactersData;
import marvelapi.utils.CharacterUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@PropertySource("classpath:application.properties")
public class MarvelCharacterService {
    private WebClient client;

    private final String END_POINT = "https://gateway.marvel.com:443/v1/public/";
    private final String publicKey = System.getenv("PUBLIC_KEY");
    private final String privateKey = System.getenv("PRIVATE_KEY");

    public MarvelCharacterService(WebClient.Builder builder) {
        client = builder.baseUrl(END_POINT).build();
    }

    public Flux<CharactersData> getCharacters() {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/characters")
                        .queryParam("ts", CharacterUtils.timeStamp)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", CharacterUtils.md5Apache(publicKey, privateKey, CharacterUtils.timeStamp))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CharactersData.class);
    }

    public Mono<CharactersData> getCharacterById(Integer id) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/characters/" + id)
                        .queryParam("ts", CharacterUtils.timeStamp)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", CharacterUtils.md5Apache(publicKey, privateKey, CharacterUtils.timeStamp))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CharactersData.class);
    }
}

