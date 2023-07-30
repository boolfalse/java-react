package am.github.javareact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired // this will make sure that the property below
    // (repository service class instance)
    // will be initialized in the constructor automatically
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> all() {
        // ResponseEntity will collect the response body stuff
        return new ResponseEntity<List<Movie>>(movieService.getAll(), HttpStatus.OK);
    }

}
