package marvelapi.model.comics;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Comics {
    Integer id;
    Integer digitalId;
    String title;
    Double issueNumber;
    String variantDescription;
    String description;
    String modified;
    String isbn;
}
