package marvelapi.model;

import lombok.Data;

import java.util.List;

@Data
public class CharactersResult {
    private List<Character> results;
}
