package pl.coderslab.animalclub.domain.animal;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;
import pl.coderslab.animalclub.domain.animal.dto.AnimalSaveDto;
import pl.coderslab.animalclub.domain.genre.Genre;
import pl.coderslab.animalclub.domain.genre.GenreRepository;
import pl.coderslab.animalclub.storage.FileStorageService;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;


    public AnimalService(AnimalRepository animalRepository, GenreRepository genreRepository, FileStorageService fileStorageService) {
        this.animalRepository = animalRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<AnimalDto> findAllPromotedAnimals() {
        return animalRepository.findAllByPromotedIsTrue().stream()
                .map(AnimalDtoMapper::map)
                .toList();
    }

    public Optional<AnimalDto> findAnimalById(long id) {
        return animalRepository.findById(id).map(AnimalDtoMapper::map);
    }

    public List<AnimalDto> findAnimalsByGenreName(String genre) {
        return animalRepository.findAllByGenre_NameIgnoreCase(genre).stream()
                .map(AnimalDtoMapper::map)
                .toList();
    }

    public void addAnimal(AnimalSaveDto animalToSave) {
        Animal animal = new Animal();
        animal.setName(animalToSave.getName());
        animal.setAge(animalToSave.getAge());
        animal.setWeight(animalToSave.getWeight());
        animal.setDescription(animalToSave.getDescription());
        Genre genre = genreRepository.findByNameIgnoreCase(animalToSave.getGenre()).orElseThrow();
        animal.setGenre(genre);
        if (animalToSave.getPhoto() != null) {
            String savedFileName = fileStorageService.saveImage(animalToSave.getPhoto());
            animal.setPhoto(savedFileName);
        }
        animalRepository.save(animal);
    }

    public List<AnimalDto> findTopAnimals(int size) {
        Pageable page = Pageable.ofSize(size);
        return animalRepository.findTopByRating(page).stream()
                .map(AnimalDtoMapper::map)
                .toList();
    }
}
