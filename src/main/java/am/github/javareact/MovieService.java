package am.github.javareact;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired // this will make sure that the property below
    // (repository class instance)
    // will be initialized in the constructor automatically
    private MovieRepository movieRepository;

    public List<Movie> getAll() {
        // findAll method defined in MovieRepository interface (extended by MongoRepository)
        return movieRepository.findAll();
    }

//    // the Mongo findById method may return null
//    // so the return type must be aware about that
//    // that is why we need to use <Optional<Movie>> instead of <Movie>
//    // actually the IDE will say about that
//    public Optional<Movie> getOne(ObjectId id) {
//        return movieRepository.findById(id);
//    }

    public Optional<Movie> getOne(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
