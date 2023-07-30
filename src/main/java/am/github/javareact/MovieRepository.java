package am.github.javareact;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // this is like an accessor
    // so the MongoRepository will automatically split the method name like:
    // findMovieByImdbId = find (native) + movies (collection) + imdbId (property)
    Optional<Movie> findMovieByImdbId(String imdbId);

}
