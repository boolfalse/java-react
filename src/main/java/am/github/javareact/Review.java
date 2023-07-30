package am.github.javareact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "reviews")
@Data // for getters, setters, etc
@AllArgsConstructor // takes care of model fields
@NoArgsConstructor // setup constructor to be possible to not get any arguments
public class Review {
    @Id // primary field
    private ObjectId id;

    // additional fields
    private String body;
}
