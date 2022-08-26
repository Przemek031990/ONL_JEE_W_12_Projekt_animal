package pl.coderslab.animalclub.domain.rating;


import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findByUser_EmailAndAnimal_Id(String userEmail, Long animalId);
}
