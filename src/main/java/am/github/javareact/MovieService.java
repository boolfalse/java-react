package am.github.javareact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
