package am.github.javareact;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired // this will make sure that the property below
    // (repository service class instance)
    // will be initialized in the constructor automatically
    private MovieService movieService;

    @GetMapping // by default, it is "/api/v1/movies"
    @CrossOrigin(origins = {
            "http://localhost:3000"
    })
    public ResponseEntity<List<Movie>> all() {
        // ResponseEntity will collect the response body stuff
        return new ResponseEntity<List<Movie>>(movieService.getAll(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    // the Mongo findById method may return null
//    // so the return type must be aware about that
//    // that is why we need to use <Optional<Movie>> instead of <Movie>
//    // actually the IDE will say about that
//    public ResponseEntity<Optional<Movie>> one(@PathVariable ObjectId id) {
//        return new ResponseEntity<Optional<Movie>>(movieService.getOne(id), HttpStatus.OK);
//    }

    @GetMapping("/{imdbId}")
    @CrossOrigin(origins = {
            "http://localhost:3000"
    })
    public ResponseEntity<Optional<Movie>> one(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getOne(imdbId), HttpStatus.OK);
    }

}
