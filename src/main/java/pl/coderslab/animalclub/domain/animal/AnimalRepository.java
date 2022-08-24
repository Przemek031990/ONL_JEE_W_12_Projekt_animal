package pl.coderslab.animalclub.domain.animal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAllByPromotedIsTrue();
    List<Animal> findAllByGenre_NameIgnoreCase(String genre);
}
