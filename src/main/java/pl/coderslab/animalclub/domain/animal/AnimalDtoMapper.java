package pl.coderslab.animalclub.domain.animal;

import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;
import pl.coderslab.animalclub.domain.rating.Rating;

class AnimalDtoMapper {
    static AnimalDto map(Animal animal) {
        double avgRating = animal.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(val -> val)
                .average().orElse(0);
        int ratingCount = animal.getRatings().size();
        return new AnimalDto(
                animal.getId(),
                animal.getName(),
                animal.getAge(),
                animal.getWeight(),
                animal.getDescription(),
                animal.getGenre().getName(),
                animal.isPromoted(),
                animal.getPhoto(),
                avgRating,
                ratingCount
        );
    }
}
