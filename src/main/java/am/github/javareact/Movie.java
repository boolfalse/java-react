package am.github.javareact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // for getters, setters, etc
@AllArgsConstructor // takes care of model fields
@NoArgsConstructor // setup constructor to be possible to not get any arguments
public class Movie {
    @Id // primary field
    private ObjectId id;

    // additional fields
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference // store only the ids of reviews (manual reference relationship)
    private List<Review> reviewIds;
}
