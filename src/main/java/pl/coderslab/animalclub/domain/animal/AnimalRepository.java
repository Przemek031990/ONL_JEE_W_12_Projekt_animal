package pl.coderslab.animalclub.domain.animal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAllByPromotedIsTrue();
    List<Animal> findAllByGenre_NameIgnoreCase(String genre);
    @Query("select a from Animal a join a.ratings r group by a order by avg(r.rating) desc")
    List<Animal> findTopByRating(Pageable page);
}
