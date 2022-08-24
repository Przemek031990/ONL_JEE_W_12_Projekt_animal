package pl.coderslab.animalclub.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.animalclub.domain.animal.AnimalService;
import pl.coderslab.animalclub.domain.animal.dto.AnimalSaveDto;
import pl.coderslab.animalclub.domain.genre.GenreService;
import pl.coderslab.animalclub.domain.genre.dto.GenreDto;

import java.util.List;

@Controller
public class AnimalManagementController {
    private final AnimalService animalService;
    private final GenreService genreService;

    public AnimalManagementController(AnimalService animalService, GenreService genreService){
        this.animalService = animalService;
        this.genreService = genreService;
    }

    @GetMapping("/admin/dodaj-pupila")
    public String addAnimalForm(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        AnimalSaveDto animal = new AnimalSaveDto();
        model.addAttribute("animal", animal);
        return "admin/animal-form";
    }

    @PostMapping("/admin/dodaj-pupila")
    public String addAnimal(AnimalSaveDto animal, RedirectAttributes redirectAttributes) {
        animalService.addAnimal(animal);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Pupil został zapisany".formatted(animal.getName()));
                return "redirect:/admin";

    }
}
