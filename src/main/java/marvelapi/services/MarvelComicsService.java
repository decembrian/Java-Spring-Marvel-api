package marvelapi.services;

import marvelapi.model.comics.Comics;
import marvelapi.model.comics.ComicsData;
import marvelapi.utils.CharacterUtils;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.properties")
public class MarvelComicsService {
    private WebClient client;
    private final String END_POINT = "https://gateway.marvel.com:443/v1/public/";

    private final String publicKey = System.getenv("PUBLIC_KEY");
    private final String privateKey = System.getenv("PRIVATE_KEY");

    public MarvelComicsService(WebClient.Builder builder){
        client = builder.baseUrl(END_POINT).build();
    }

    public Mono<ComicsData> getComicsById(Integer id){
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/comics/" + id)
                        .queryParam("ts", CharacterUtils.timeStamp)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", CharacterUtils.md5Apache(publicKey, privateKey, CharacterUtils.timeStamp))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ComicsData.class);
    }

    public Flux<ComicsData> getComics(){
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/comics")
                        .queryParam("ts", CharacterUtils.timeStamp)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", CharacterUtils.md5Apache(publicKey, privateKey, CharacterUtils.timeStamp))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ComicsData.class);
    }
}
