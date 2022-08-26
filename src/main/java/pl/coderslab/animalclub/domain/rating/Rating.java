package pl.coderslab.animalclub.domain.rating;


import pl.coderslab.animalclub.domain.animal.Animal;
import pl.coderslab.animalclub.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "animal_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Animal animal, Integer rating) {
        this.user = user;
        this.animal = animal;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
