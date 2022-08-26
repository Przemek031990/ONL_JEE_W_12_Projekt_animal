package pl.coderslab.animalclub.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.animalclub.domain.rating.RatingService;

@Controller
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/ocen-pupila")
    public String addAnimalRating(@RequestParam long animalId,
                                  @RequestParam int rating,
                                  @RequestHeader String referer,
                                  Authentication authentication) {
        String currentUserEmail = authentication.getName();
        ratingService.addOrUpdateRating(currentUserEmail, animalId, rating);
        return "redirect:" + referer;
    }
}
