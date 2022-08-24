package pl.coderslab.animalclub.web;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.animalclub.domain.animal.AnimalService;
import pl.coderslab.animalclub.domain.animal.dto.AnimalDto;
import pl.coderslab.animalclub.domain.genre.GenreService;
import pl.coderslab.animalclub.domain.genre.dto.GenreDto;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;
    private final AnimalService animalService;

    public GenreController(GenreService genreService, AnimalService animalService) {
        this.genreService = genreService;
        this.animalService = animalService;
    }

    @GetMapping("/rasa/{name}")
    public String getGenre(@PathVariable String name, Model model) {
        GenreDto genre = genreService.findGenreByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<AnimalDto> animals = animalService.findAnimalsByGenreName(name);
        model.addAttribute("heading", genre.getName());
        model.addAttribute("description", genre.getDescription());
        model.addAttribute("animals", animals);
        return "animal-listing";

    }

    @GetMapping("/rasy-zwierząt")
    public String getGenreList(Model model) {
        List<GenreDto> genres = genreService.findAllGenres();
        model.addAttribute("genres", genres);
        return "genre-listing";
    }

}
