package pl.coderslab.animalclub.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.animalclub.domain.animal.AnimalService;
import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;

import java.util.Optional;

@Controller
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/profil/{id}")
    public String getAnimal(@PathVariable long id, Model model) {
        Optional<AnimalDto> optionalAnimal = animalService.findAnimalById(id);
        optionalAnimal.ifPresent(animal -> model.addAttribute("animal", animal));
        return "animal";
    }
}
