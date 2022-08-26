package pl.coderslab.animalclub.domain.rating;


import org.springframework.stereotype.Service;
import pl.coderslab.animalclub.domain.animal.Animal;
import pl.coderslab.animalclub.domain.animal.AnimalRepository;
import pl.coderslab.animalclub.domain.user.User;
import pl.coderslab.animalclub.domain.user.UserRepository;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;

    public RatingService(RatingRepository ratingRepository,
                         UserRepository userRepository,
                         AnimalRepository animalRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.animalRepository = animalRepository;
    }

    public void addOrUpdateRating(String userEmail, long animalId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndAnimal_Id(userEmail, animalId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Animal animal = animalRepository.findById(animalId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setAnimal(animal);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForAnimal(String userEmail, long animalId) {
        return ratingRepository.findByUser_EmailAndAnimal_Id(userEmail, animalId)
                .map(Rating::getRating);
    }
}
