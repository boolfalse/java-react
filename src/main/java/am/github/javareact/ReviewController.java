package am.github.javareact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired // this will make sure that the property below
    // (repository service class instance)
    // will be initialized in the constructor automatically
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Map<String, String> payload) {
        String imdbId = payload.get("imdbId");
        String body = payload.get("body");
        return new ResponseEntity<Review>(reviewService.create(imdbId, body), HttpStatus.CREATED);
    }

}
