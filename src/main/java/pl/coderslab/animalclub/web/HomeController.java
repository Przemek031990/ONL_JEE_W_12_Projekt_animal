package pl.coderslab.animalclub.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.animalclub.domain.animal.AnimalService;
import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;

import java.util.List;

@Controller
public class HomeController {
    private final AnimalService animalService;

    public HomeController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<AnimalDto> promotedAnimals = animalService.findAllPromotedAnimals();
        model.addAttribute("heading", "Promowane profile");
        model.addAttribute("description", "Profile polecane przez nasz zespół");
        model.addAttribute("animal", promotedAnimals);
        return "animal-listing";
    }
}
