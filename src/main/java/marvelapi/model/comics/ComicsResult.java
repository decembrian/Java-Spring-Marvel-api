package marvelapi.model.comics;

import lombok.Data;

import java.util.List;

@Data
public class ComicsResult {
    private List<Comics> result;
}
