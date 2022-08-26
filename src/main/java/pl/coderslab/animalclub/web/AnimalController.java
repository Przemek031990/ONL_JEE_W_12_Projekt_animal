package pl.coderslab.animalclub.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.animalclub.domain.animal.AnimalService;
import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;
import pl.coderslab.animalclub.domain.rating.RatingService;

import java.util.List;


@Controller
public class AnimalController {
    private final AnimalService animalService;
    private final RatingService ratingService;

    public AnimalController(AnimalService animalService, RatingService ratingService) {
        this.animalService = animalService;
        this.ratingService = ratingService;
    }

    @GetMapping("/profil/{id}")
    public String getAnimal(@PathVariable long id,
                            Model model,
                            Authentication authentication) {
        AnimalDto animal = animalService.findAnimalById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("animal", animal);
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            Integer rating = ratingService.getUserRatingForAnimal(currentUserEmail, id).orElse(0);
            model.addAttribute("userRating", rating );
        }
        return "animal";
    }

    @GetMapping("/top10")
    public String findTop10(Model model) {
        List<AnimalDto> top10Animals = animalService.findTopAnimals(10);
        model.addAttribute("heading", "TOP 10 Pupili");
        model.addAttribute("description", "Pupile najlepiej oceniane przez użytkowników");
        model.addAttribute("animal", top10Animals);
        return "animal-listing";
    }
}
