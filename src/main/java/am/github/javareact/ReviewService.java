package am.github.javareact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired // this will make sure that the property below
    // (repository class instance)
    // will be initialized in the constructor automatically
    private ReviewRepository reviewRepository;

    // make a template to form up a new dynamic complex query
    // instead of using repository
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review create(String imdbId, String body) {
        // create a new Review instance with initializing the data in it
        // and save the data into the database
        Review review = reviewRepository.insert(new Review(body));

        // attach the new review to the appropriate movie (one-to-many)
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
