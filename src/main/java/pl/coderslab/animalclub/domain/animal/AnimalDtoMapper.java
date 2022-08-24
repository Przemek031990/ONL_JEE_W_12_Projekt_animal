package pl.coderslab.animalclub.domain.animal;

import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;

class AnimalDtoMapper {
    static AnimalDto map(Animal animal) {
        return new AnimalDto(
                animal.getId(),
                animal.getName(),
                animal.getAge(),
                animal.getWeight(),
                animal.getDescription(),
                animal.getGenre().getName(),
                animal.isPromoted(),
                animal.getPhoto()
        );
    }
}
